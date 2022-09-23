package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {
    BrcPage brcPage;

    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object[][] kullaniciListesiArray = {{"firize@nehaber.com","54678"},
                {"murat@benbuisibilirim.com","65874"},
                {"ilyas@hollandadaselam.com","54648"}};
        return kullaniciListesiArray;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void dogruEmailYanlısSifre(String userEmail,String password) {


        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage = new BrcPage();
        brcPage.ilkLoginButonu.click();

        //test data user email:data providerdan alalım
        brcPage.emailTextBox.sendKeys(userEmail);
        //test data wrong password : data  providerdan alalım
        brcPage.passwordTextBox.sendKeys(password);
        //login butonuna tıklayın
        brcPage.ikinciLoginButtonu.click();
        // degerler,  girildiği   nde sayfa basarılı sekilde girilemediğini test et
        Assert.assertTrue(brcPage.ikinciLoginButtonu.isDisplayed());
        Driver.closeDriver();

    }
}
