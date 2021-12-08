package tests;

import base.BaseTest;
import com.thoughtworks.gauge.Step;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Step("Rasgele bir ürün seçilir")
    public void selectRandomProduct(){
        ProductsPage productsPage = new ProductsPage(appiumDriver);
        productsPage.selectRandomProduct();
        logger.info("Rasgele bir urun secildi");
    }

}
