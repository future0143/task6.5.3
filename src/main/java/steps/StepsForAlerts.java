package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ElementsOfPageWithAlerts;

public class StepsForAlerts extends ElementsOfPageWithAlerts {

    @Step(value = "Нажатие на JS Alert")
    public static Alert clickJSAlert(WebDriver driver) {
        WebElement webElement = driver.findElement(By.cssSelector(buttonJsAlert));
        webElement.click();

        return driver.switchTo().alert();
    }

    @Step(value = "проверка закрытия алерта")
    public static void checkClosingAlert(WebDriver driver, String text) {
        Assertions.assertTrue(driver.getPageSource().contains(text));
    }

    @Step(value = "Нажатие на JS Confirm")
    public static Alert clickJSConfirm(WebDriver driver) {
        WebElement webElement = driver.findElement(By.cssSelector(buttonJsConfirm));
        webElement.click();

        return driver.switchTo().alert();
    }

    @Step(value = "Нажатие на JS Prompt")
    public static Alert clickJSPrompt(WebDriver driver) {
        WebElement webElement = driver.findElement(By.cssSelector(buttonJsPrompt));
        webElement.click();

        return driver.switchTo().alert();
    }

    @Step(value = "Ввод текста в текстовое поле алерта")
    public static void inputTextIntoAlert(Alert alert, String text) {
        alert.sendKeys(text);
        alert.accept();
    }
}