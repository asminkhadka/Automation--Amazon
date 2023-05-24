package test;

import Action.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class testRun {

    static WebDriver driver = null;
    static String itemToBeSelected;
    static ExtentTest report = null;

    @BeforeTest
    public void setUpTest() {
        ExtentHtmlReporter.htmlReport();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test (priority = 1)
    public static void loginUser(){
        report = ExtentHtmlReporter.extent.createTest("Login Test ", "This is validation for Testing login: test case");
        driver.get("https://amazon.com");
        report.pass("Navigated To URL");
        login loginObj = new login(driver);
        loginObj.getLoginIn();
        loginObj.getEmailField("asminkhadka1234@gmail.com");
        loginObj.setContinueEmail();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginObj.setPasswordField("Alvinhood@4");
        loginObj.clickSignIn();
        if (driver.getTitle().equals("Amazon Sign-In")) {
            report.pass("login successful");
        } else {
            report.fail("login failed");
            report.addScreenCaptureFromPath("screenshot.png");
        }

    }

    @Test(priority = 2)
    public static void searchAndLocationChange() throws InterruptedException {
        dashboard dashboardObj = new dashboard(driver);
        driver.get("https://amazon.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dashboardObj.locationChange();
        dashboardObj.setZipcode("10005");
        driver.get("https://amazon.com");
        dashboardObj.AddTextInSearchBox("tv");
        dashboardObj.SearchButton(String.valueOf(Keys.RETURN));
    }


    @Test(priority = 3)
    public static void OpenItemTest() throws InterruptedException {
        openItem OpenItemObj = new openItem(driver);
        itemToBeSelected= OpenItemObj.OpenItem();
        Thread.sleep(3000);

    }
//
    @Test(priority = 4)
    public static void AddItemTest() throws InterruptedException {
        addList addListObj = new addList(driver);
        addListObj.AddItem();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
    }
//
    @Test(priority = 5)
    public static void CartPageOpenTest() {
        report = ExtentHtmlReporter.extent.createTest("Verify item name  ", "This is validation for item name");
        cartPage CartOpenObj = new cartPage(driver);
        String cartItemFirst = CartOpenObj.CartOpenFirstItem();
        System.out.printf(cartItemFirst);
        report.pass("Navigated To URL");
        try {
            Assert.assertEquals(itemToBeSelected, cartItemFirst);
            report.log(Status.PASS, "Validation passed: The item is the is same as the one searched previously ");
            report.pass("Validated");
        } catch (AssertionError e) {
            report.log(Status.FAIL, "Validation failed: The item isn't the is same as the one searched previously ");
            report.fail(e);

        }

    }

    @AfterTest
    public void tearDownTest() {
        driver.close();
        driver.quit();
        ExtentHtmlReporter.extent.flush();
    }
}
