package tests;

import base.BasePage;
import base.BaseTest;

import com.thoughtworks.gauge.Step;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class Steps extends BaseTest {

    BasePage basePage = new BasePage(appiumDriver);

    @Step("<wait> saniye bekle")
    public void waitForsecond(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
        logger.info(wait + " saniye bekledi");
    }

    @Step("<elementid> id'li elemente tıklanır")
    public void clickElementById(String elementid) {
        basePage.click(By.id(elementid));
        logger.info(elementid + " elementine tikladi");
    }

    @Step("<elementXpath> elementine xpath ile tıklanır")
    public void clickElementByXpath(String elementXpath){
        basePage.click(By.xpath(elementXpath));
        logger.info(elementXpath + " elementine tikladi");
    }

    @Step("<elementid> id'li elemente <text> değerini yaz")
    public void typeElement(String elementid, String text){
        basePage.type(By.id(elementid), text);
        logger.info(elementid + " elementine " + text + " degerini yazdi");
    }

    @Step("<elementid> id'li elementin sayfada olduğunu kontrol et")
    public void isOnPageId(String elementid){
        Assert.assertTrue(elementid + " elementi sayfada bulunamadi!", basePage.isDisplayed(By.id(elementid)));
        logger.info("Sayfada " + elementid + " elementi bulundu");
    }

    @Step("<elementxpath> xpath'li elementin sayfada olduğunu kontrol et")
    public void isOnPageXpath(String elementxpath){
        Assert.assertTrue(elementxpath + " elementi sayfada bulunamadi!", basePage.isDisplayed(By.xpath(elementxpath)));
        logger.info("Sayfada " + elementxpath + " elementi bulundu");
    }

    @Step("Sayfanın sonuna scroll edilir")
    public void scrollDown(){
        TouchAction scroll = new TouchAction(appiumDriver);

        PointOption point1 = new PointOption();
        PointOption point2 = new PointOption();

        Point from = new Point(524, 1585);
        Point to = new Point(536, 381);

        scroll.longPress(point1.point(from.x, from.y)).moveTo(point2.point(to.x, to.y)).release().perform();

        logger.info("Sayfanin sonuna scroll edildi");
    }
}
