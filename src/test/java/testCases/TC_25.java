package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class TC_25 extends TestBase {
    @Test
    public void test01() {


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        ilk3Step();
        bekle(2);
        //4. Scroll down page to bottom
        WebElement subscriptionButton = driver.findElement(By.cssSelector("#subscribe"));
        toElementScroll(subscriptionButton);

        //5. Verify 'SUBSCRIPTION' is visible
        WebElement subscription = driver.findElement(By.xpath("//div[@class='single-widget']/h2"));
        Assert.assertTrue(subscription.isDisplayed());
        //6. Click on arrow at bottom right side to move upward
        bekle(2);
        WebElement yukariOk = driver.findElement(By.xpath("//*[@id='scrollUp']"));
        yukariOk.click();


        //7. Verify that page is scrolled up
        WebElement header = driver.findElement(By.cssSelector("#header"));
        Assert.assertTrue(header.isEnabled());

        // and 'Full-Fledged practice website for Automation Engineers' // text is visible on screen
        WebElement fullFledgedPracticeWebsiteForAutomationEngineers = driver.findElement(By.xpath("(//div[@class='col-sm-6']/h2)[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(fullFledgedPracticeWebsiteForAutomationEngineers));
        Assert.assertTrue(fullFledgedPracticeWebsiteForAutomationEngineers.isDisplayed());

    }
}