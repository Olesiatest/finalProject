package FinallTask;

import FinallProject.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LanguageTest extends BaseTest {

  @Test(priority = 1)
  public void checkLanguage() {
    MainPage mainPage = new MainPage();
    int languageSize = mainPage.switchToIframe().getHeaderBlock().checkLanguageSize();
    Assertions.assertThat(44).as("The count language is not correct. Count must be 44")
        .isEqualTo(languageSize);
    boolean isExistUkraineLanguage = mainPage.getHeaderBlock().isExistLanguage("uk");
    Assertions.assertThat(isExistUkraineLanguage).as("It is not Ukraine Language").isTrue();


  }


}
