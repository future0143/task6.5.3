package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import pages.ElementsOfPageWithFrames;

public class StepsForFrames extends ElementsOfPageWithFrames {

    @Step(value = "Нажатие на фрейм и переход на него")
    public static void clickFrame(WebDriver driver) {
        WebElement webElement = driver.findElement(By.cssSelector(buttonFrame));
        webElement.click();
        waitTime(3000);
        WebElement iframe = driver.findElement(By.id(idOfFrame));
        driver.switchTo().frame(iframe);
        waitTime(3000);
    }

    @Step(value = "Очищение текстового поля внутри фрейма и ввод текста")
    public static WebElement inputTextIntoFramesField(String textForInput, WebDriver driver) {
        WebElement textFieldInsideIFrame = driver.findElement(By.tagName(tagNameOfFieldIntoFrame));
        textFieldInsideIFrame.clear();
        waitTime(3000);
        textFieldInsideIFrame.sendKeys(textForInput);
        waitTime(3000);

        return textFieldInsideIFrame;
    }

    @Step(value = "Сделать текст жирным через кнопку B в окне фрейма")
    public static void makeTextBold(WebElement textFieldInsideIFrame, WebDriver driver) {
        textFieldInsideIFrame.sendKeys(Keys.COMMAND + "A");
        waitTime(3000);
        driver.switchTo().defaultContent();
        WebElement buttonBold = driver.findElement(By.cssSelector(cssSelectorBoldButton));
        buttonBold.click();
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