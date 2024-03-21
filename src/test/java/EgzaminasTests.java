import org.example.Main;
import org.junit.jupiter.api.*;

import static org.example.Main.*;

public class EgzaminasTests {
    @BeforeEach
    public void setUp() {
        Main.setUp();
    }
    // @AfterEach
    public void testDown() {
        Main.closeBrowser();
    }
    @Test
    public void signUpPositive() {
        Main.signUp("Sau888", "12345");
        String expected_title = "Registracija";
        String actual = browser.getTitle();
        Assertions.assertEquals(expected_title, actual, "Title is not correct");
    }
    @Test
    public void signUpNegative() {
        Main.signUp("Saulius1", "12345");
        Assertions.assertFalse(browser.getPageSource().contains("Error"));

    }
    @Test
    public void logInPositive() {
        Main.logIn("Saulius1", "12345");
        Assertions.assertEquals("Skaičiuotuvas", browser.getTitle(), "Login positive test failed.");
    }
    @Test
    public void logInNegative() {
        Main.logIn("Sauliuz1", "12345");
        Assertions.assertNotEquals("Skaičiuotuvas", browser.getTitle(), "Login positive test failed.");
        Assertions.assertFalse(browser.getPageSource().contains("Error"));
    }
}
