package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import java.util.List;

public class ProductsPage extends BasePage {

    By productsLocator = By.id("com.ozdilek.ozdilekteyim:id/imageView");

    public ProductsPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void selectRandomProduct(){
        List<MobileElement> products = findAll(productsLocator);
        int randIdx = (int) (Math.random() * 3) + 1;
        products.get(randIdx).click();
    }
}
