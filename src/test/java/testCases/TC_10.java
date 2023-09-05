package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC_10 extends TestBase {
    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        ilk3Step();
        //4. Scroll down to footer
        pageDown(50);

        bekle(2);
        //5. Verify text 'SUBSCRIPTION' --  //div[@class='single-widget']/h2

        WebElement subscription = driver.findElement(By.xpath("//div[@class='single-widget']/h2"));
        Assert.assertEquals("SUBSCRIPTION", subscription.getText());

        //6. Enter email address in input and click arrow button     -- "#susbscribe_email"

        driver.findElement(By.cssSelector("#susbscribe_email")).sendKeys("absd@yopmail.com",Keys.ENTER);

        //7. Verify success message 'You have been successfully subscribed!' is visible  -- "//div[@class='alert-success alert']

        WebElement successflySub = driver.findElement(By.xpath("//div[@class='alert-success alert']"));

        Assert.assertEquals("You have been successfully subscribed!", successflySub.getText());
    }
}