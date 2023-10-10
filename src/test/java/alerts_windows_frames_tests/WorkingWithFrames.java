package alerts_windows_frames_tests;

import config.ConfigSetup;
import config.TestProperties;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebElement;

import static steps.StepsForFrames.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WorkingWithFrames extends ConfigSetup {

    private final String urlFrame = TestProperties.getValue("testFrame.url");

    @BeforeEach
    public void openUrl() {
        openBrowser(urlFrame);
    }

    @Test
    @DisplayName("Взаимодействие с элементами внутри фрейма")
    @Description("Скрипт, в котором необходимо взаимодействовать с элементами внутри фрейма")
    public void workWithFramesElements() {
        clickFrame(driver);

        String textForFramesField = "Hello World";
        WebElement textFieldInsideIFrame = inputTextIntoFramesField(textForFramesField, driver);

        makeTextBold(textFieldInsideIFrame, driver);
    }
}