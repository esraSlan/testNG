package tests.practice;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DHtmlGoodiesPage;
import utilities.Driver;
import utilities.TestBase;

public class Q5_DragAndDrop extends TestBase {
    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.


      @Test
      public void test01() {

            Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
            DHtmlGoodiesPage dhtmlGoodiesPage=new DHtmlGoodiesPage();

            Actions actions = new Actions(Driver.getDriver());
            actions.dragAndDrop(dhtmlGoodiesPage.Oslo,dhtmlGoodiesPage.Norway)
                    .dragAndDrop(dhtmlGoodiesPage.Stockholm,dhtmlGoodiesPage.Sweden)
                    .dragAndDrop(dhtmlGoodiesPage.washington,dhtmlGoodiesPage.UnitedStates)
                    .dragAndDrop(dhtmlGoodiesPage.Copenhagen, dhtmlGoodiesPage.Denmark)
                    .dragAndDrop(dhtmlGoodiesPage.Seoul,dhtmlGoodiesPage.southKorea)
                    .dragAndDrop(dhtmlGoodiesPage.Madrid,dhtmlGoodiesPage.Spain)
                    .dragAndDrop(dhtmlGoodiesPage.Roma, dhtmlGoodiesPage.Italy)
                    .perform();

            Driver.closeDriver();
      }
}