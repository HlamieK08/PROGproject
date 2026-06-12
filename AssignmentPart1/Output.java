import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Output {

    Input login = new Input();

    // Constructor
    public Output() {
    }

    @Test
    public void checkUserName() {
        // Test should return true for valid username
        assertTrue(login.checkUserName("kyl_1"));

        // Test should return false for invalid username
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void checkPasswordComplexity() {
        // Test valid password
        assertTrue(login.checkPasswordComplexity("Kyle123$#"));

        // Test invalid password
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void checkCellPhoneNumber() {
        // Test valid international cellphone number
        assertTrue(login.checkCellPhoneNumber("+2783896897"));

        // Test invalid cellphone number
        assertFalse(login.checkCellPhoneNumber("06966553"));
    }

    @Test
    public void testReturnStatus() {
        // Expected output for successful login
        String expected = "A successful login";

        // Actual output from method
        String actual = login.returnLoginStatus(true);

        // Compare expected and actual results
        assertEquals(expected, actual);
    }
}