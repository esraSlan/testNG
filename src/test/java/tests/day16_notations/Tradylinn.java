package tests.day16_notations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.Driver;

public class Tradylinn {

    @Test
    public void test(){
        Driver.getDriver().get("https://tradylinn.com/");
        Driver.getDriver().findElement(By.linkText("Giriş Yap")).click();
        Driver.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("tradylinn2022@hotmail.com");
           Driver.getDriver().findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys("TRADYlinn2022.");
        Driver.getDriver().findElement(By.xpath("//button[text()='Giriş Yap']")).click();

    }
}
