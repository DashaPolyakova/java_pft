package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() throws InterruptedException {
        //   wd.findElement(By.name("pass")).click();

       /* driver.findElement(By.name("db_name")).clear();
        driver.findElement(By.name("db_name")).sendKeys("DAsha molodec");
        Thread.sleep(4000);*/
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        submitGroupCreation();
        returnToGroupPage();
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
