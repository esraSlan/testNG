package tests.day21_reusableMethods_HtmlReportss;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScreenShot_ReusableMethods {
    @Test
    public void test01() throws IOException {
        //amazon git  fotograf çek
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        ReusableMethods.getScreenshot("amazon");
        Driver.closeDriver();
    }
}
