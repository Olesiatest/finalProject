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

    boolean checkProductPrice = mainPage.getProductBlock().isExistProductValue(ProductValues.Price);
    Assertions.assertThat(checkProductPrice).as("The Price popular product is not exist").isTrue();

    boolean isSumMoreZero = mainPage.getProductBlock().checkSumProduct();
    Assertions.assertThat(isSumMoreZero).as("The Price popular product is not exist").isTrue();

  }
}
