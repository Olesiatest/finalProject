package blocks;

import FinallProject.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductBlock extends BasePage {

  private final By productItem = By.xpath("//div[contains(@class,'thumbnail-container')]");
  private final By productName = By.xpath("//h3[contains(@class,'product-title')]");
  private final By productPrice = By.xpath("//span[@class='price']");

  public int checkProductSize() {
    return findElements(productItem).size();
  }

  public enum ProductValues {
    Name, Price
  }

  public boolean isExistProductValue(ProductValues value) {
    switch (value) {
      case Name:
        return checkProductValue(productName);
      case Price:
        return checkProductValue(productPrice);
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
