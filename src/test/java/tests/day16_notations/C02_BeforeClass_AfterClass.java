package tests.day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {

    //JUnitte BeforeClass ve AfterClass notasyouna sahip methodlar static olmak zorundaydı
    //TestNG zorunluluk tan bizi kurtarmıştır.
   /*
     TestNg bize daha fazla before ve after notasyonlari sunar
     diger before/after notasyonlari tanimlayacagimiz
     grup, test veya sut'den once ve sonra calisirlar
     ileride xml dosyalari ile birlikte bunu gorecegiz
     */




         @BeforeClass
         public void beforeClassMethod(){
             System.out.println("Before class");
         }
         @AfterClass
         public void afterClassMethod(){
             System.out.println("After Class");
         }
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");

    }

    @Test
    public void test02() {

        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void test03() {

        driver.get("https://www.techproeducation.com");
    }
}
