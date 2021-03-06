package FinallProject;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  private static WebDriver driver;

  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }

  public static WebDriver getDriver() {
    return driver;
  }

  protected WebElement find(By locator) {
    return getDriver().findElement(locator);
  }

  protected WebElement findWithWait(By locator, int timeout) {
    return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(
        ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected boolean findElemAttrToBE(By locator, int timeout) {
    return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(
        ExpectedConditions.attributeToBe(locator, "display", "none"));
  }

  protected WebElement findWithWaitPresence(By locator, int timeout) {
    return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(
        ExpectedConditions.presenceOfElementLocated(locator));
  }

  protected double truncate(double number, int precision) {
    double prec = Math.pow(10, precision);
    int integerPart = (int) number;
    double fractionalPart = number - integerPart;
    fractionalPart = fractionalPart * prec;
    int fractPart = (int) fractionalPart;
    fractionalPart = (double) (integerPart) + (double) (fractPart) / prec;
    return fractionalPart;
  }

  protected List<WebElement> findElements(By locator) {
    return getDriver().findElements(locator);
  }
}


