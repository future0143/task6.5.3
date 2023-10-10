package alerts_windows_frames_tests;

import config.ConfigSetup;
import config.TestProperties;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;

import static steps.StepsForAlerts.*;
import static validator.ValidationOfElements.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WorkingWithAlerts extends ConfigSetup {

    private final String urlAlert = TestProperties.getValue("testAlert.url");

    @BeforeEach
    public void openUrl() {
        openBrowser(urlAlert);
    }

    @Test
    @DisplayName("Принятие уведомления")
    @Description("Открыть, прочитать и принять уведомление")
    public void acceptAlert() {
        Alert alertJS = clickJSAlert(driver);

        String expectedText = "I am a JS Alert";
        validateAlertByText(alertJS, expectedText);

        alertJS.accept();
    }

    @Test
    @DisplayName("Отклонить уведомление")
    @Description("Отказаться от алерта и проверить, что алерт закрылся")
    public void dismissAlert() {
        String text = "You successfully clicked an alert";
        checkClosingAlert(driver, text);

        Alert alertJSConfirm = clickJSConfirm(driver);

        alertJSConfirm.dismiss();

        String textAfterClosingAlert = "You clicked: Cancel";
        checkClosingAlert(driver, textAfterClosingAlert);
    }

    @Test
    @DisplayName("Ввести текст в окне алерта")
    @Description("Ввести текст в окне алерта и проверить, что он появился на странице")
    public void inputTextInAlert() {
        Alert alertJSPrompt = clickJSPrompt(driver);

        String textForAlert = "Hello World";
        inputTextIntoAlert(alertJSPrompt, textForAlert);

        String textOnPage = "You entered: Hello World";
        checkTextOnPage(textOnPage, driver);
    }
}