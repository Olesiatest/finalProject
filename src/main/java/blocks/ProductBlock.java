package blocks;

import FinallProject.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductBlock extends BasePage {

  private final By productItem = By.xpath("//div[contains(@class,'thumbnail-container')]");
  private final By productName = By.xpath(".//h3[contains(@class,'product-title')]");
  private final By productPrice = By.xpath(".//span[@class='price']");
  private final By discountPrice = By.xpath(".//span[@class='regular-price']");
  private final By discountPercent = By.xpath(".//li[@class='product-flag discount']");
  private final By productsBlock = By.xpath("//div[contains(@class,'products')]");

  public int checkProductSize() {
    return findElements(productItem).size();
  }

  public enum ProductValues {
    Name, Price, Discount
  }

  public boolean checkDiscountPrice() {
    WebElement productsElement = find(productsBlock);
    List<WebElement> productList = productsElement.findElements(productItem);
    boolean returnValue = false;
    for (WebElement product : productList) {
      String beforeAmountStr = product.findElement(discountPrice).getText();
      String newAmountStr = product.findElement(productPrice).getText();
      String percentStr = product.findElement(discountPercent).getText();
      double beforeAmount = Double.parseDouble(
          beforeAmountStr.substring(1, beforeAmountStr.length()));
      double newAmount = Double.parseDouble(
          newAmountStr.substring(1, newAmountStr.length()));
      double percent = Double.parseDouble(
          percentStr.substring(1, percentStr.length() - 1)) / 100;
      double calcDiscountPrice = beforeAmount * percent;
      double price = beforeAmount - calcDiscountPrice;
      if (truncate(price, 2) == newAmount) {
        returnValue = true;
      } else {
        returnValue = false;
        break;
      }

    }
    return returnValue;
  }

  public boolean isExistProductValue(ProductValues value) {
    switch (value) {
      case Name:
        return checkProductValue(productName);
      case Price:
        return checkProductValue(productPrice);
      case Discount:
        return checkProductValue(discountPrice);
      default:
        throw new IllegalStateException("Unknown value");
    }
  }

  public boolean checkProductValue(By locator) {
    WebElement productElement = find(productItem);
    List<WebElement> listPopularProduct = productElement.findElements(locator);
    boolean returnValue = false;
    for (WebElement product : listPopularProduct) {
      if (product.isDisplayed()) {
        returnValue = true;
      } else {
        returnValue = false;
        break;
      }
    }
    return returnValue;
  }

  public boolean checkSumProduct() {
    WebElement productElement = find(productItem);
    List<WebElement> pricesList = productElement.findElements(productPrice);
    double sumProduct = 0.00;
    for (WebElement product : pricesList) {
      double amount = Double.parseDouble(
          product.getText().substring(1, product.getText().length()));
      sumProduct = sumProduct + amount;
    }
    if (sumProduct > 0) {
      return true;
    } else {
      return false;
    }
  }


}
