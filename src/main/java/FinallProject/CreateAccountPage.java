package FinallProject;

import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage {

  private final By genderFemale = By.id("field-id_gender-2");
  private final By firstnameField = By.id("field-firstname");
  private final By lastnameField = By.id("field-lastname");
  private final By emailField = By.id("field-email");
  private final By passwordField = By.id("field-password");
  private final By birthdayField = By.id("field-birthday");
  private final By submitButton = By.xpath("//button[@type='submit']");
  private final By requiredCheckbox = By.xpath("//input[@name='customer_privacy']");


  public CreateAccountPage selectGender() {
    find(genderFemale).click();
    return this;
  }

  public CreateAccountPage fillFirstnameField(String firstName) {
    find(firstnameField).sendKeys(firstName);
    return this;
  }

  public CreateAccountPage fillLastnameField(String lastName) {
    find(lastnameField).sendKeys(lastName);
    return this;
  }

  public CreateAccountPage fillEmail(String email) {
    find(emailField).sendKeys(email);
    return this;
  }

  public CreateAccountPage fillPassword(String password) {
    find(passwordField).sendKeys(password);
    return this;
  }

  public CreateAccountPage fillBirthdayField(String birthday) {
    find(birthdayField).sendKeys(birthday);
    return this;
  }

  public CreateAccountPage clickRequiredCheckbox() {
    find(requiredCheckbox).click();
    return this;
  }

  public MainPage clickSubmitButton() {
    find(submitButton).click();
    return new MainPage();
  }

}
