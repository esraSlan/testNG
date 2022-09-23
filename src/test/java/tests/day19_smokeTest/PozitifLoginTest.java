package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {

    @Test
    public void positiveLoginTest() {

        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        BrcPage brcPage = new BrcPage();
      brcPage.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        //login butonuna tıklayın
        brcPage.ikinciLoginButtonu.click();
        // degerler,  girildiği   nde sayfa basarılı sekilde girildiğini test et
        Assert.assertEquals(brcPage.kullaniciAdi.getText(),ConfigReader.getProperty("brcValidUserName"));
        Driver.closeDriver();
    }
}