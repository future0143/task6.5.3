package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ElementsOfPageWithAlerts;

import java.util.concurrent.TimeUnit;

public class StepsForAlerts extends ElementsOfPageWithAlerts {

    @Step(value = "Нажатие на JS Alert")
    public static Alert clickJSAlert(WebDriver driver) {
        WebElement webElement = driver.findElement(By.cssSelector(buttonJsAlert));
        webElement.click();
        waitTime(3000);
        Alert alert = driver.switchTo().alert();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return alert;
    }

    @Step(value = "проверка закрытия алерта")
    public static void checkClosingAlert(WebDriver driver, String text) {
        Assertions.assertTrue(driver.getPageSource().contains(text));
    }

    @Step(value = "Нажатие на JS Confirm")
    public static Alert clickJSConfirm(WebDriver driver) {
        WebElement webElement = driver.findElement(By.cssSelector(buttonJsConfirm));
        webElement.click();
        waitTime(3000);
        Alert alert = driver.switchTo().alert();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return alert;
    }

    @Step(value = "Нажатие на JS Prompt")
    public static Alert clickJSPrompt(WebDriver driver) {
        WebElement webElement = driver.findElement(By.cssSelector(buttonJsPrompt));
        webElement.click();
        waitTime(3000);
        Alert alert = driver.switchTo().alert();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return alert;
    }

    @Step(value = "Ввод текста в текстовое поле алерта")
    public static void inputTextIntoAlert(Alert alert, String text) {
        alert.sendKeys(text);
        waitTime(6000);
        alert.accept();
        waitTime(3000);
    }

    public static void waitTime(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}