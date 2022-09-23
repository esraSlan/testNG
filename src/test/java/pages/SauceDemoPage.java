package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SauceDemoPage {

    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high with soft Assert
     *     T2 : Verify item prices are sorted from low to high with hard Assert
     */

    public SauceDemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "user-name")
    public WebElement kullaniciAdi;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement sifre;

    @FindBy(id = "login-button")
    public WebElement loginTusu;

    @FindBy(className = "product_sort_container")
    public WebElement siralamaTusu;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> urunlerListesi;






}
