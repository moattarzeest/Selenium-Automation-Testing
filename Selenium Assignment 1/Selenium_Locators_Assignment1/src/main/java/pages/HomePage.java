package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public JobsPage searchQaJobs()
    {
        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Job title, keyword or company']"));
        searchBox.sendKeys("Qa");
        searchBox.submit();
        return new JobsPage(driver);
    }
}
