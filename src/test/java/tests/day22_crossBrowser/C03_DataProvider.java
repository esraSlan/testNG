package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {
    @Test
    public void test01() {
        AmazonPage amazonPage = new AmazonPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        String expectedKelime="Nutella";
        String  actualKelime=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));

        Driver.closeDriver();
    }
    @DataProvider
    public static Object[][] AranacakKelimeler(){

        Object[][] arananKelimeArrayi={{"Nutella"},{"java"},{"Cigdem"},{"Netherlands"}};

        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    public void test02(String arananKelime) {
        AmazonPage amazonPage = new AmazonPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        amazonPage.aramaKutusu.sendKeys(arananKelime, Keys.ENTER);

        String expectedKelime=arananKelime;
        String  actualKelime=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));

        Driver.closeDriver();
    }
}
