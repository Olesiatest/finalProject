package FinallTask;

import FinallProject.MainPage;
import blocks.ProductBlock.ProductValues;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PopularProductTest extends BaseTest {

  @Test(priority = 1)
  public void checkPopularProduct() {
    MainPage mainPage = new MainPage();

    int checkPopularProductSize = mainPage.switchToIframe().getProductBlock().checkProductSize();
    Assertions.assertThat(8).as("The count popular product is not correct. Count must be 8")
        .isEqualTo(checkPopularProductSize);

    boolean checkProductName = mainPage.getProductBlock().isExistProductValue(ProductValues.Name);
    Assertions.assertThat(checkProductName).as("The Name popular product is not exist").isTrue();
  }
 }
