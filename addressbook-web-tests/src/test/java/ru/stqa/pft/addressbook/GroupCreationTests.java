package ru.stqa.pft.addressbook;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class GroupCreationTests {
    //   FirefoxDriver wd;
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/Users/fbi/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        //System.setProperty("gecko.driver","C:/Users/fbi/Downloads/geckodriver/geckodriver.exe");
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/group.php");
        login("admin", "secret");

    }

    private void login(String username, String password) {
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }


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

    private void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    private void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    private void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
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
