package search;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JobsPage;

import java.time.Duration;

public class SearchTest extends BaseTest {
    JobsPage jobsPage;
    private WebDriver driver;
    @Test
    public void searchTest() {

        JobsPage jobsPage_local = homePage.searchQaJobs();
    }

    @Test
    public void searchJobTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 2: Click the Apply Now button according to conditions
        WebElement applyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//efc-job-card[.//div[contains(@class, 'company')][contains(text(), ' Deutsche Bank ')]][.//span[contains(text(), 'Permanent')]][.//span[contains(text(), 'hours ago')]]//a[contains(text(), ' Apply now ')]"
        )));
        applyNowButton.click();

//        (jobsPage.findRequiredJob()).click();

    }

}
