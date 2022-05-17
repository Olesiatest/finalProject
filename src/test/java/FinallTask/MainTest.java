package FinallTask;

import FinallProject.MainPage;
import blocks.NavigationMenuBlock.Categories;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

  @Test(priority = 1)
  public void checkTextEmail() {
    MainPage mainPage = new MainPage();
    String textLeftEmailInput = mainPage.switchToIframe().checkTextLeftEmailInput();
    String actualTextEmailInput = "Get our latest news and special sales";
    Assertions.assertThat(actualTextEmailInput).as("The text is not correct")
        .isEqualTo(textLeftEmailInput);
    String textBottomEmailInput = mainPage.checkTextBottomEmailInput();
    String actualTextBottomEmailInput = "You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.";
    Assertions.assertThat(actualTextBottomEmailInput).as("The text in bottom is not correct")
        .isEqualTo(textBottomEmailInput);
    String textFromButtonSubscribe = mainPage.checkTextUppercase();
    String actualTextFromButtonSubscribe = "SUBSCRIBE";
    Assertions.assertThat(actualTextFromButtonSubscribe).as("The text button is not Uppercase")
        .isEqualTo(textFromButtonSubscribe);
  }

  @Test(priority = 2)
  public void checkCategories() {
    MainPage mainPage = new MainPage();
    boolean checkClothesCategory = mainPage.switchToIframe().getNavigationMenuBlock()
        .selectCategory(
            Categories.Clothes);
    Assertions.assertThat(checkClothesCategory).as("That not All category in submenu Clothes")
        .isTrue();
    boolean checkAccessoriesCategory = mainPage.getNavigationMenuBlock()
        .selectCategory(
            Categories.Accessories);
    Assertions.assertThat(checkAccessoriesCategory)
        .as("That not All category in submenu Accessories").isTrue();
    boolean checkArtCategory = mainPage.getNavigationMenuBlock()
        .selectCategory(
            Categories.Art);
    Assertions.assertThat(checkArtCategory)
        .as("That not All category in submenu Art").isFalse();
  }
}
