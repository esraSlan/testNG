package tests.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SauceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

;

public class Q3_SoftAssert {

    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high with soft Assert
     *     T2 : Verify item prices are sorted from low to high with hard Assert
     */




    // Verify item prices are sorted from low to high with hard Assert


    @Test
    public void test01() {
        SauceDemoPage sdp = new SauceDemoPage();
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));

        sdp.kullaniciAdi.sendKeys(ConfigReader.getProperty("saucedemoKullaniciAdi"));
        sdp.sifre.sendKeys(ConfigReader.getProperty("saucedemoSifre"));

        sdp.loginTusu.click();

        Select option = new Select(sdp.siralamaTusu);
        option.selectByIndex(2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement>   kucuktenBuyuge=sdp.urunlerListesi;
        softAssert.assertEquals(kucuktenBuyuge.get(0).getText(),"$7.99","en dusuk ucret görülmedi");
        softAssert.assertEquals(kucuktenBuyuge.get(kucuktenBuyuge.size()-1).getText(),"$49.99","en yuksek değer görülmedi");

        softAssert.assertAll();


       option = new Select(sdp.siralamaTusu);
        option.selectByIndex(3);
        List<WebElement>   buyuktenKucuge=sdp.urunlerListesi;

        Assert.assertEquals("$49.99",buyuktenKucuge.get(0).getText());

      Driver.closeDriver();




    }
}
