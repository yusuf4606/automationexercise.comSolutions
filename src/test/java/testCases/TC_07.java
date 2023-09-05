package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class TC_07 extends TestBase {
    @Test
    public void test01() {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'

        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully

        bekle(2);
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Automation Exercise", actualTitle);

//        4. Click on 'Test Cases' button

        driver.findElement(By.xpath("(//i[@class='fa fa-list'])[1]")).click();
        bekle(2);

//        5. Verify user is navigated to test cases page successfully
        WebElement testCases = driver.findElement(By.xpath("(//*[.='Test Cases'])[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOf(testCases));

        Assert.assertTrue(testCases.isDisplayed());

    }
}
