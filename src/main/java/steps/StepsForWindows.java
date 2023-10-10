package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ElementsOfPageWithWindows;

import java.util.Set;

import static validator.ValidationOfElements.validateElementByText;


public class StepsForWindows extends ElementsOfPageWithWindows {

    @Step(value = "Нажатие на кнопку перехода на новую страницу")
    public static String clickWindow(WebDriver driver, String winHandleBefore) {
        WebElement webElement = driver.findElement(By.linkText(buttonClickHere));
        webElement.click();

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(winHandleBefore)) {
                driver.switchTo().window(handle);

                return driver.getCurrentUrl();
            }
        }
        return null;
    }

    @Step(value = "Поиск текста на странице")
    public static String findTextOnPage(WebDriver driver) {
        WebElement newPageText = driver.findElement(By.tagName(tagNameOfTextOnNewWindow));

        return newPageText.getText();
    }

    @Step(value = "Закрытие нового окна")
    public static void closeNewWindow(WebDriver driver, String winHandleBefore) {
        driver.close();
        driver.switchTo().window(winHandleBefore);
    }

    @Step(value = "Проверить текст на странице")
    public static void checkTextOnPage(WebDriver driver) {
        String textOnPage = findTextOnPage(driver);
        String expectedText = "New Window";
        validateElementByText(textOnPage, expectedText);
    }
}