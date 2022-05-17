package FinallTask;

import FinallProject.MainPage;
import FinallProject.ProductsPage.ProductSorting;
import org.testng.annotations.Test;

public class SortingTest extends BaseTest {

  @Test(priority = 1)
  public void checkSortProducts() {
    MainPage mainPage = new MainPage();
    mainPage.switchToIframe().clickAllProducts().clickSortingButton()
        .selectSorting(ProductSorting.sortingAZ);
  }
}
