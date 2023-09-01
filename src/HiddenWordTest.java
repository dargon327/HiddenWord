import static org.junit.jupiter.api.Assertions.*;

class HiddenWordTest {

    private String hiddenWord;
    private HiddenWord hw;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        hiddenWord = "fantastic";
        hw = new HiddenWord(hiddenWord);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

        hiddenWord = null;
        hw = null;

    }

    @org.junit.jupiter.api.Test
    void capitalizedHiddenWord() {

        assertEquals("FANTASTIC", hw.getHiddenWord());

    }

    @org.junit.jupiter.api.Test
    void guessCapitalized() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> hw.getHint("awesome"));

        String expectedMessage = "Your guess ( awesome ) does not contain all uppercase letters. Your guess must contain all uppercase letters!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @org.junit.jupiter.api.Test
    void guessEqualLength() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> hw.getHint("AWESOME"));

        String expectedMessage = "Your guess ( AWESOME ) has 7 characters. The hidden word has 9 characters. Your guess must be a word with 9 characters!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @org.junit.jupiter.api.Test
    void getHint() {

        String hint = hw.getHint("FEELINGIT");
        assertEquals("F***++*I+", hint);

        String hint2 = hw.getHint("IMTOOGOOD");
        assertEquals("+*+******", hint2);

        String hint3 = hw. getHint("WHATISUP?");
        assertEquals("**+T+S***", hint3);
    }

}