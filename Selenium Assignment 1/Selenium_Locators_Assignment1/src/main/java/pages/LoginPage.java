package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//    }

    public void findEmailInput(String email)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email']")));
        emailInput.sendKeys(email);

    }

    public void findContinueButton()
    {
        WebElement continueButton = driver.findElement(By.xpath("//div[@class='Button']/button"));
        continueButton.click();
    }

    public void findPasswordInput(String password)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));
        passwordInput.sendKeys("123456Moattar");

    }

    public void clickLoginButton()
    {
        //Login button
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='Button']/button"));
        loginButton.click();
    }



}
