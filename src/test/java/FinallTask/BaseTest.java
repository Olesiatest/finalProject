package FinallTask;

import FinallProject.BasePage;
import FinallProject.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  WebDriver driver;

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--disable-site-isolation-trials");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
    driver.get("https://demo.prestashop.com/");
    BasePage.setDriver(driver);
    MainPage mainPage = new MainPage();
    boolean isLoadingPage = mainPage.waitLoadingPage();
    Assertions.assertThat(isLoadingPage).as("Page is not loading").isTrue();
  }

  @AfterMethod
  public void closeDriver() {
    BasePage.getDriver().quit();
  }
}

