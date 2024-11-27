package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JobsPage;
import pages.LoginPage;
import java.time.Duration;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver/win64-131.0.6778.85/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.efinancialcareers.com/");
        homePage = new HomePage(driver);

    }
//    @Test
//    public void searchTest() {
//
////        JobsPage jobsPage_local = homePage.searchQaJobs();
//        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Job title, keyword or company']"));
//        searchBox.sendKeys("Qa");
//        searchBox.submit();
//    }
//
//    @Test
//    public void locateJobTest()
//    {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement applyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//                "//efc-job-card[.//div[contains(@class, 'company')][contains(text(), ' Deutsche Bank ')]][.//span[contains(text(), 'Permanent')]][.//span[contains(text(), 'days ago')]]//a[contains(text(), ' Apply now ')]"
//        )));
//        applyNowButton.click();
//    }

//    @Test
//    public void applyToJobTest()
//    {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        //Step 3
//        WebElement applyNowButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//                "//efc-job-details-page//efc-apply-button//a"
//        )));
//        applyNowButton2.click();
//    }
//
//    @Test
//    public void loginTest()
//    {
//        LoginPage loginPage = new LoginPage();
//        loginPage.findEmailInput("moattar.zeest@emumba.com");
//        loginPage.findContinueButton();
//        loginPage.findPasswordInput("123456Moattar");
//        loginPage.clickLoginButton();
//
//    }

    @Test
    public void testLocateApplyNowButtonForDeutscheBankJobs() {
        // Step 1: Search for QA jobs
        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Job title, keyword or company']"));
        searchBox.sendKeys("Qa");
        searchBox.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 2: Click the Apply Now button according to conditions
        WebElement applyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//efc-job-card[.//div[contains(@class, 'company')][contains(text(), ' Deutsche Bank ')]][.//span[contains(text(), 'Permanent')]][.//span[contains(text(), 'days ago')]]//a[contains(text(), ' Apply now ')]"
        )));
        applyNowButton.click();

        //Cancel the popup
        WebElement cancelThePopup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[contains(@class, 'notifications-wrapper')]//efc-icon//span"
        )));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cancelThePopup);
//        cancelThePopup.click();

        //Step 3
        WebElement applyNowButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//efc-job-details-page//efc-apply-button//a"
        )));
        applyNowButton2.click();

       // Step 4 - Email
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email']")));
        emailInput.sendKeys("moattar.zeest@emumba.com");

        //Continue button
        WebElement continueButton = driver.findElement(By.xpath("//div[@class='Button']/button"));
        continueButton.click();

        //Password
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));
        passwordInput.sendKeys("123456Moattar");

        //Login button
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='Button']/button"));
        loginButton.click();

        //First name
        WebElement firstnameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
        firstnameInput.sendKeys("Moattar");

        //Last name
        WebElement lastnameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
        lastnameInput.sendKeys("Zeest");

        WebElement uploadResumeButton;
        try {
            uploadResumeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//button[.//span[contains(text(), 'Upload Resume')]]"
            )));

            // Check if "Upload Resume" button is displayed
            if (uploadResumeButton.isDisplayed()) {
                // Click on "Upload Resume"
                uploadResumeButton.click();

                // Locate the file input element and upload the resume
                WebElement resumeInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
                String filePath = "C:\\Users\\Emumba\\Documents\\SeleniumPractice\\Locators and Selenium Assignment.docx";
                resumeInput.sendKeys(filePath);

                // Locate and click the "Upload" button
                WebElement clickUploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                        "//span[@data-e2e='upload' and contains(@class, 'fsp-button-upload')]"
                )));
                clickUploadButton.click();

                // Locate and click the "Apply" button
                WebElement clickApplyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//button[@data-gtm-trackable='submit-job-application' and contains(@class, 'btn-primary')]"
                )));
                clickApplyButton.click();
            }
        } catch (Exception e) {
            // If "Upload Resume" button is not found or displayed, click "Apply" directly
            WebElement clickApplyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//button[@data-gtm-trackable='submit-job-application' and contains(@class, 'btn-primary')]"
            )));
            clickApplyButton.click();
        }





    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
