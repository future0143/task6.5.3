package alerts_windows_frames_tests;

import config.ConfigSetup;
import config.TestProperties;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

import static steps.StepsForWindows.*;
import static validator.ValidationOfElements.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WorkingWithWindows extends ConfigSetup {

    private static final String urlWindow = TestProperties.getValue("testWindow.url");

    @BeforeEach
    public void openBrowser() {
        openBrowser(urlWindow);
    }

    @Test
    @DisplayName("Переключение между окнами")
    @Description("Скрипт, который открывает новое окно или вкладку, переключается между ними и затем закрывает новое окно")
    public void scriptForWorkWithWindows() {
        String currentUrlBefore = driver.getCurrentUrl();
        String winHandleBefore = driver.getWindowHandle();

        String currentUrlNewWindow = clickWindow(driver, winHandleBefore);

        checkTransitionToNewPage(currentUrlBefore, currentUrlNewWindow);

        checkTextOnPage(driver);

        closeNewWindow(driver, winHandleBefore);

        checkTransitionToPreviousPage(currentUrlBefore, driver.getCurrentUrl());
    }
}