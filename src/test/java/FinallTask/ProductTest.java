package FinallTask;

import FinallProject.MainPage;
import blocks.ProductBlock.ProductValues;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

  @Test(priority = 1)
  public void checkPriceDrop() {
    MainPage mainPage = new MainPage();
    boolean isExistNewPrice = mainPage.switchToIframe().clickPricesDropProduct().getProductBlock()
        .isExistProductValue(ProductValues.Price);
    Assertions.assertThat(isExistNewPrice).as("The price is not correct").isTrue();

    boolean isExistDiscountPrice = mainPage.getProductBlock()
        .isExistProductValue(ProductValues.Discount);
    Assertions.assertThat(isExistDiscountPrice).as("The discount price is not correct").isTrue();

  }


}
