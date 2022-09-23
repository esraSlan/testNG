package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    BrcPage brcPage;
    @Test
    public void dogruEmailYanlısSifre() {


        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage = new BrcPage();
        brcPage.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        //test data wrong password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        //login butonuna tıklayın
        brcPage.ikinciLoginButtonu.click();
        // degerler,  girildiği   nde sayfa basarılı sekilde girilemediğini test et
        Assert.assertTrue(brcPage.ikinciLoginButtonu.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void yanlisEmailDogruSifre() {
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna
      brcPage = new BrcPage();
        brcPage.ilkLoginButonu.click();

        //test data wrong user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //test data  password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        //login butonuna tıklayın
        brcPage.ikinciLoginButtonu.click();
        // degerler,  girildiği   nde sayfa basarılı sekilde girilemediğini test et
        Assert.assertTrue(brcPage.ikinciLoginButtonu.isDisplayed());
        Driver.closeDriver();



    }

    @Test
    public void yanlısEmailYanlısSifre() {
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna
        brcPage = new BrcPage();

        brcPage.ilkLoginButonu.click();

        //test data wrong user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        //test data wrong password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        //login butonuna tıklayın
        brcPage.ikinciLoginButtonu.click();

        // degerler,  girildiği   nde sayfa basarılı sekilde girilemediğini test et
        Assert.assertTrue(brcPage.ikinciLoginButtonu.isDisplayed());
        Driver.closeDriver();

    }
}
