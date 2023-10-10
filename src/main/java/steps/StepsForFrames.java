package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import pages.ElementsOfPageWithFrames;

public class StepsForFrames extends ElementsOfPageWithFrames {

    @Step(value = "Нажатие на фрейм и переход на него")
    public static void clickFrame(WebDriver driver) {
        WebElement webElement = driver.findElement(By.cssSelector(buttonFrame));
        webElement.click();

        WebElement iframe = driver.findElement(By.id(idOfFrame));
        driver.switchTo().frame(iframe);
    }

    @Step(value = "Очищение текстового поля внутри фрейма и ввод текста")
    public static WebElement inputTextIntoFramesField(String textForInput, WebDriver driver) {
        WebElement textFieldInsideIFrame = driver.findElement(By.tagName(tagNameOfFieldIntoFrame));
        textFieldInsideIFrame.clear();
        textFieldInsideIFrame.sendKeys(textForInput);

        return textFieldInsideIFrame;
    }

    @Step(value = "Сделать текст жирным через кнопку B в окне фрейма")
    public static void makeTextBold(WebElement textFieldInsideIFrame, WebDriver driver) {
        textFieldInsideIFrame.sendKeys(Keys.COMMAND + "A");

        driver.switchTo().defaultContent();

        WebElement buttonBold = driver.findElement(By.cssSelector(cssSelectorBoldButton));
        buttonBold.click();
    }
}