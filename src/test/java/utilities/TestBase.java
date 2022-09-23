package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestBase {
    //abstract yapmamızın nedeni bu classtan obje uretilmesinin onune geçmektir
   protected WebDriver driver;

    @BeforeMethod(groups = "grup2")
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod(groups = "grup2")
    public void tearDown() throws InterruptedException {

        driver.quit();
    }
}
