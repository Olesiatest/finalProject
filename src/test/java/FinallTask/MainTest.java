package FinallTask;

import FinallProject.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

  @Test(priority = 1)
  public void checkTextEmail() {
    MainPage mainPage = new MainPage();
    String checkTextEmailLeft = mainPage.checkTextLeftEmailInput();
    Assertions.assertThat("Get our latest news and special sales").as("The text is not correct")
        .isEqualTo(checkTextEmailLeft);

  }

}
