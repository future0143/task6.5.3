package validator;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class ValidationOfElements {

    public static void checkTransitionToNewPage(String urlBeforeSwitch, String currentUrlNewWindow) {
        Assertions.assertNotEquals(urlBeforeSwitch, currentUrlNewWindow);
    }

    public static void checkTransitionToPreviousPage(String urlBeforeSwitch, String currentUrlNewWindow) {
        Assertions.assertEquals(urlBeforeSwitch, currentUrlNewWindow);
    }

    public static void validateElementByText(String newPageText, String expectedText) {
        Assertions.assertEquals(expectedText, newPageText);
    }

    public static void validateAlertByText(Alert alertText, String expectedText) {
        Assertions.assertEquals(expectedText, alertText.getText());
    }

    public static void checkTextOnPage(String text, WebDriver driver) {
        Assertions.assertTrue(driver.getPageSource().contains(text));
    }
}