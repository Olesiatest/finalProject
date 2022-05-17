package blocks;

import FinallProject.BasePage;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationMenuBlock extends BasePage {

  private Actions actions;

  public NavigationMenuBlock() {
    actions = new Actions(getDriver());
  }

  public enum Categories {
    Clothes, Accessories, Art
  }

  private final By clothesCategory = By.id("category-3");
  private final By accessoriesCategory = By.id("category-6");
  private final By artCategory = By.id("category-9");
  private final By dropdownItemMenuClothes = By.xpath(
      "//li[@id='category-3']//a[@class='dropdown-item dropdown-submenu']");
  private final By dropdownItemMenuAccessories = By.xpath(
      "//li[@id='category-6']//a[@class='dropdown-item dropdown-submenu']");
  private final By artMenu = By.xpath(
      "//li[@id='category-9']//a[@class='dropdown-item dropdown-submenu']");
  private final By topMenu = By.id("top-menu");
  private final By subMenu = By.xpath("//div[contains(@class, 'sub-menu')]");

  public boolean checkSubMenu(By locator) {
    return find(topMenu).findElement(locator).findElement(subMenu).isDisplayed();
  }

  public void hoverOnCategory(By locator) {
    WebElement category = find(locator);
    actions.moveToElement(category).build().perform();
  }

  public boolean selectCategory(Categories category) {
    switch (category) {
      case Clothes:
        hoverOnCategory(clothesCategory);
        if (!checkSubMenu(clothesCategory)) {
          return false;
        }
        List<WebElement> clothesMenuItems = findElements(dropdownItemMenuClothes);
        List<String> checkListDropdownClothes = Arrays.asList("MEN", "WOMEN");
        return checkSubMenuCategories(clothesMenuItems, checkListDropdownClothes);
      case Accessories:
        hoverOnCategory(accessoriesCategory);
        if (!checkSubMenu(accessoriesCategory)) {
          return false;
        }
        List<WebElement> accessoriesMenuItems = findElements(dropdownItemMenuAccessories);
        List<String> checkListDropdownAccessories = Arrays.asList("STATIONERY", "HOME ACCESSORIES");
        return checkSubMenuCategories(accessoriesMenuItems, checkListDropdownAccessories);
      case Art:
        hoverOnCategory(artCategory);
        if (!checkSubMenu(artCategory)) {
          return false;
        }
      default:
        throw new IllegalStateException("Unknown category");
    }
  }

  public boolean checkSubMenuCategories(List<WebElement> subMenu, List<String> checkList) {
    boolean returnValue = false;
    for (WebElement item : subMenu) {
      if (checkList.contains(item.getText())) {
        returnValue = true;
      } else {
        returnValue = false;
      }
    }
    return returnValue;
  }
}

