package FinallProject;

import org.openqa.selenium.By;
import utils.Utils;

public class MainPage extends BasePage {

  private final By textLeftEmailInput = By.xpath("//p[@id='block-newsletter-label']");
  private final By textBottomEmailInput = By.xpath("//div[@class='col-xs-12']/p");
  private final By textUppercase = By.xpath(
      "//input[@class='btn btn-primary float-xs-right hidden-xs-down']");


  public String checkTextLeftEmailInput() {

    Utils.scrollToElement(getDriver(), findWithWaitPresence(textLeftEmailInput, 10));
    return find(textLeftEmailInput).getText();
  }

  public String checkTextBottomEmailInput() {
    return find(textBottomEmailInput).getText();
  }

  public String checkTextUppercase() {
    return find(textUppercase).getAttribute("value");
  }


}
