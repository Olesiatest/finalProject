package blocks;

import FinallProject.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HeaderBlock extends BasePage {

  private final By languageButton = By.xpath("//button[@class='hidden-sm-down btn-unstyle']");
  private final By languageItem = By.xpath("//ul[@class='dropdown-menu hidden-sm-down']/li");

  public int checkLanguageSize() {
    find(languageButton).click();
    return findElements(languageItem).size();
  }

  public boolean isExistLanguage(String code) {
    find(languageButton).click();
    List<WebElement> languageList = findElements(languageItem);
    boolean returnValue = false;
    for (WebElement lang : languageList) {
      String langCode = lang.findElement(By.tagName("a")).getAttribute("data-iso-code");
      if (langCode.equals(code)) {
        returnValue = true;
      }

    }
    return returnValue;
  }


}
