package FinallTask;

import FinallProject.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CreateAccountTask extends BaseTest {

  @Test(priority = 1)
  public void checkUserSignIn() {
    MainPage mainPage = new MainPage();
    boolean successNewAccount = mainPage.switchToIframe().getHeaderBlock().clickSignInButton()
        .clickCreateNewAccount()
        .selectGender().fillFirstnameField("olesia").fillLastnameField("Demchuk")
        .fillEmail("Olesiatest@gmail.com").fillPassword("test123").fillBirthdayField("12/12/2000")
        .clickRequiredCheckbox()
        .clickSubmitButton().checkMyAccount();
    Assertions.assertThat(successNewAccount).as("The account is not success created").isTrue();
  }

  @Test(priority = 2)
  public void checkUserSignInvalidData() {
    MainPage mainPage = new MainPage();
    String redHiglighterFieldFirstName = mainPage.switchToIframe().getHeaderBlock()
        .clickSignInButton()
        .clickCreateNewAccount()
        .selectGender().fillFirstnameField("James8").fillLastnameField("Demchuk")
        .fillEmail("Olesiatest@gmail.com").fillPassword("test123").fillBirthdayField("12/12/2000")
        .clickRequiredCheckbox()
        .clickSubmitButton().getInvalidFirstName();
    Assertions.assertThat(redHiglighterFieldFirstName).as("The field is not highlighter in red")
        .isEqualTo("rgb(255, 76, 76)");
    boolean showErrorAllertFirstNAme = mainPage.errorInvalidFormatName();
    Assertions.assertThat(showErrorAllertFirstNAme)
        .as("Alert is not displayed under field first name")
        .isTrue();
  }
}
