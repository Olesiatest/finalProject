package FinallTask;

import FinallProject.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

  @Test(priority = 1)
  public void checkTextEmail() {
    MainPage mainPage = new MainPage();
//    boolean isLoadingPage = mainPage.waitLoadingPage();
//    Assertions.assertThat(isLoadingPage).as("Page is not loading").isTrue();

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


}
