package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws InterruptedException {
        //   wd.findElement(By.name("pass")).click();

       /* driver.findElement(By.name("db_name")).clear();
        driver.findElement(By.name("db_name")).sendKeys("DAsha molodec");
        Thread.sleep(4000);*/
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

    //    public static boolean isAlertPresent(FirefoxDriver wd) {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
}
