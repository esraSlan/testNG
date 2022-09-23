package tests.day21_reusableMethods_HtmlReportss;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {

    @Test
    public void positiveLoginTest() {
         extentTest=extentReports.createTest("Positif Login","Gecerli username ve şifre ile giriş yapabilmeli");
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        //      login butonuna bas
        BrcPage  brcPage=new BrcPage();

        brcPage.ilkLoginButonu.click();
        extentTest.info("login butonuna tıklandı");
        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");
        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli sifre yazildi");
        //login butonuna tıklayın
        brcPage.ikinciLoginButtonu.click();
        extentTest.info("login butonuna tıklandı");
        // degerler,  girildiği   nde sayfa basarılı sekilde girildiğini test et
        Assert.assertEquals(brcPage.kullaniciAdi.getText(),ConfigReader.getProperty("brcValidUserName"));
        extentTest.pass("kullanıcı başarılı sekilde giris yaptı");

        Driver.closeDriver();
    }
}
