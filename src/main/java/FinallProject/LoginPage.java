package FinallProject;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  private final By createNewAccount = By.xpath("//div[@class='no-account']/a");


  public CreateAccountPage clickCreateNewAccount() {
    find(createNewAccount).click();
    return new CreateAccountPage();
  }


}
