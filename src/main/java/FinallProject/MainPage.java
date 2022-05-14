package FinallProject;

import blocks.HeaderBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

public class MainPage extends BasePage {

  private Actions actions;

  public MainPage() {
    actions = new Actions(getDriver());
  }

  HeaderBlock headerBlock = new HeaderBlock();

  public HeaderBlock getHeaderBlock() {
    return headerBlock;
  }

  private final By textLeftEmailInput = By.xpath("//p[@id='block-newsletter-label']");
  private final By textBottomEmailInput = By.xpath("//div[@class='col-xs-12']/p");
  private final By textUppercase = By.xpath(
      "//input[@class='btn btn-primary float-xs-right hidden-xs-down']");
  private final By loader = By.xpath("//div[@id='loadingMessage']");
  private final By iframeLocator = By.id("framelive");

  public boolean waitLoadingPage() {
    return findElemAttrToBE(loader, 10);
  }

  public MainPage switchToIframe() {
    WebElement iframeElement = find(iframeLocator);
    getDriver().switchTo().frame(iframeElement);
    return this;
  }

  public String checkTextLeftEmailInput() {
    Utils.scrollInBottomPage(getDriver());
    return find(textLeftEmailInput).getText();
  }

  public String checkTextBottomEmailInput() {
    return find(textBottomEmailInput).getText();
  }

  public String checkTextUppercase() {
    return find(textUppercase).getAttribute("value");
  }


}
