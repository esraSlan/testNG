package tests.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebDriverUniversityPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q4_Alert_DependsOn  {

       /*
     // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
     // 2. CLICK ME of JavaScript Alert e tıklayın
     // 3. pop up text i alın
     // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
     // 5. pop up i kabul edin

     // Yine ayni class da baska test methodu olusturun
     // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
     // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
     // 3.  pop up text i alın
     // 4. Mesajın "Press a button!" olduğunu doğrulayın
     // 5. Açılır pencereyi kapat
     // 6. pop up i iptal edin,
     // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
     // 8. alert1'e göre dependsOnMethods kullanın
 */

    @Test
    public void test01() {

        WebDriverUniversityPage wdup=new WebDriverUniversityPage();

        SoftAssert softAssert = new SoftAssert();
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webdriverUniversiteUrl"));
        // 2. CLICK ME of JavaScript Alert e tıklayın
        wdup.javaScriptAlert.click();
        // 3.  pop up text i alın
        String actualJSAlertText=Driver.getDriver().switchTo().alert().getText();
        String expectedJSAlertText="I am an alert box!";
        // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
        softAssert.assertEquals(actualJSAlertText,expectedJSAlertText,"beklenen mesaj uymadı");
        // 5. pop up i kabul edin

        Driver.getDriver().switchTo().alert().accept();

        softAssert.assertAll();

    }

    @Test(dependsOnMethods = "test01",priority = 0)
    public void test02() {
        WebDriverUniversityPage wdup=new WebDriverUniversityPage();
        // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
        wdup.javaScriptConfirmBox.click();
        // 3.  pop up text i alın
        Driver.getDriver().switchTo().alert();
        String actualJSConfirmBoxText=Driver.getDriver().switchTo().alert().getText();
        // 4. Mesajın "Press a button!" olduğunu doğrulayın
        String expectedJSConfirmBoxText="Press a button!";
        Assert.assertEquals(expectedJSConfirmBoxText,actualJSConfirmBoxText,"mesaj uymadı");

        // 5. Açılır pencereyi kapat
        // 6. pop up i iptal edin,
        Driver.getDriver().switchTo().alert().dismiss();
        // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
        Assert.assertTrue(wdup.yaziElementi.isDisplayed());
        // 8. alert1'e göre dependsOnMethods kullanın
       Driver.closeDriver();


    }
}

