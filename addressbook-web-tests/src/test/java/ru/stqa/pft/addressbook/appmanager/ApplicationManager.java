package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by fbi on 20.08.2017.
 */
public class ApplicationManager {
    //   FirefoxDriver wd;
    public WebDriver driver = new ChromeDriver();

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        String browser = BrowserType.CHROME;
        if (browser == BrowserType.CHROME) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/fbi/Downloads/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser == BrowserType.IE) {
            driver = new InternetExplorerDriver();
        }

        //System.setProperty("gecko.driver","C:/Users/fbi/Downloads/geckodriver/geckodriver.exe");
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
