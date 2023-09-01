public class HiddenWord {
    private String hiddenWord;
    private String returnWord;
    public HiddenWord(String hiddenWord) {
        this.hiddenWord = cap(hiddenWord);
    }
    public String cap(String preHiddenWord) {
        String hiddenWord = "";
        for (int i = 0; i < preHiddenWord.length();i++) {
            char temp = preHiddenWord.charAt(i);
            if ((int)preHiddenWord.charAt(i) > 96) {
                temp -= 32;
            }
            hiddenWord += temp;
        }
        return hiddenWord;
    }
    public boolean checkCap(String preHiddenWord) {
        boolean hiddenWord = false;
        for (int i = 0; i < preHiddenWord.length();i++) {
            if ((int)preHiddenWord.charAt(i) > 96) {
                hiddenWord = true;
            }
        }
        return hiddenWord;
    }
    public String getHint(String guess) {
        if (checkCap(guess)) {
            throw new IllegalArgumentException("Your guess ( "+ guess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
        }
        if (guess.length() != hiddenWord.length()) {
            throw new IllegalArgumentException("Your guess ( "+ guess+" ) has " + guess.length() +" characters. The hidden word has "+ hiddenWord.length() + " characters. Your guess must be a word with "+ hiddenWord.length() +" characters!");
        }
        returnWord = "";
        for (int i = 0; i <hiddenWord.length();i++) {
            if (i > guess.length()-1) {
                returnWord += "*";
                continue;
            }
            if (guess.charAt(i) == hiddenWord.charAt(i)) {
                returnWord += "" + guess.charAt(i);
            } else {
                boolean a = false;
                for (int j = 0; j < hiddenWord.length(); j++) {
                    if (guess.charAt(i) == hiddenWord.charAt(j)) {
                        a = true;
                        break;
                    }
                }
                if (a) {
                    returnWord += "+";
                } else {
                    returnWord += "*";
                }
            }
        }
        return returnWord;
    }
    public void setHiddenWord(String newWord) {
        hiddenWord = cap(newWord);
    }
    public String getHiddenWord() {
        return hiddenWord;
    }
}