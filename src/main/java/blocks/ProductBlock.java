package blocks;

import FinallProject.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductBlock extends BasePage {

  private final By productItem = By.xpath("//div[contains(@class,'js-product')]");
  private final By productName = By.xpath("//h3[contains(@class,'product-title')]");

  public int checkProductSize() {
    return findElements(productItem).size();
  }

  public enum ProductValues {
    Name
  }

  public boolean isExistProductValue(ProductValues value) {
    switch (value) {
      case Name:
        return checkProductValue(productName);
      default:
        throw new IllegalStateException("Unknown value");
    }

  }

  public boolean checkProductValue(By locator) {
    List<WebElement> listPopularProduct = findElements(productItem);
    boolean returnValue = false;
    for (WebElement product : listPopularProduct) {
      if (product.findElement(locator).isDisplayed()) {
        returnValue = true;
      } else {
        returnValue = false;
      }
    }
    return returnValue;
  }
}
