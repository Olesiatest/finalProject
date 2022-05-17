package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

  public static void scrollToElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public static void scrollInBottomPage(WebDriver driver) {
    ((JavascriptExecutor) driver).executeScript("scrollTo(0,document.body.scrollHeight)");
  }

  public static void foundSubmitButton(WebDriver driver) {
    ((JavascriptExecutor) driver).executeScript(
        "return document.getElementById('submit').click();");
  }
}


