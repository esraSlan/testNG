package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
    TestNG test ethodlarını isim sırasına göre calştırır
    eğer isim sırasına göre calışmamamsını isterseniz  o zaman methodlara oncelik(priority) taımlayabilir

    priority kucukten buyuğe doğru calışır
    eğer bir test methoduna proirity değere atanmaamısa priority=0 kabul edilir

     */

    @Test (priority = 5)
    public void test01() {
        driver.get("https://www.amazon.com");

    }

    @Test (priority = 2)
    public void test02() {

        driver.get("https://www.bestbuy.com");
    }

    @Test(groups = "grup1")
    public void test03() {

        driver.get("https://www.techproeducation.com");
    }
}
