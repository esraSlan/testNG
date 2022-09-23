package tests.day21_reusableMethods_HtmlReportss;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();

       //  Click here butonuna basın
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String>  windoHandleSeti=Driver.getDriver().getWindowHandles();

        String ikinciSayfaWH="";
        for (String each:windoHandleSeti) {

            if (!each.equals(ilkSayfaWH)){
                ikinciSayfaWH=each;
            }

        }
        Driver.getDriver().switchTo().window(ikinciSayfaWH);

        System.out.println(Driver.getDriver().getTitle());

        //aclan yeni sayfanın titlenin "New Window" oldugunu test et

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);


    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();

        //  Click here butonuna basın
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        ReusableMethods.switchToWindow("New Window");

        //aclan yeni sayfanın titlenin "New Window" oldugunu test et

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        ReusableMethods.waitFor(5);
        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();

    }
}
