package FinallProject;

import blocks.ProductBlock;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class ProductsPage extends BasePage {

  ProductBlock productBlock = new ProductBlock();

  public ProductBlock getProductBlock() {
    return productBlock;

  }

  private final By sortingButton = By.xpath("//button[@class='btn-unstyle select-title']");
  private final By dropdownMenu = By.xpath("//div[@class='dropdown-menu']");
  private final By sortItem = By.xpath("//a[contains(@class,'select-list')]");


  public enum ProductSorting {
    sortingAZ, sortingZA, lowToHightPrice, hightToLowPrice
  }

  public void sortBy(String sortName) {
    WebElement dropdown = find(dropdownMenu);
    List<WebElement> sortList = dropdown.findElements(sortItem);
    for (WebElement item : sortList) {
      System.out.println(item.getText());
      if (item.getText().toLowerCase(Locale.ROOT).equals(sortName.toLowerCase(Locale.ROOT))) {
        item.click();
        break;
      }

    }
  }

  public void selectSorting(ProductSorting value) {
    switch (value) {
      case sortingAZ:
        sortBy("Name, A to Z");
        break;
      case sortingZA:
        sortBy("Name, Z to A");
        break;
      case lowToHightPrice:
        sortBy("Price, low to high");
        break;
      case hightToLowPrice:
        sortBy("Price, high to low");
        break;
      default:
        throw new IllegalStateException("Unknown value");
    }
  }


  public ProductsPage clickSortingButton() {
    Utils.scrollToElement(getDriver(), find(sortingButton));
    find(sortingButton).click();
    return this;
  }

  public ProductsPage chooseDropdownMenu() {
    find(dropdownMenu).click();
    return this;
  }


}
