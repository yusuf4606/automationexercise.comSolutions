package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC_11 extends TestBase {
    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        ilk3Step();

        //4. Click 'Cart' button   -- a[href='/view_cart']

        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

        //5. Scroll down to footer    -- //footer[@id='footer']
        WebElement footer = driver.findElement(By.xpath("//footer[@id='footer']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(footer);
        //6. Verify text 'SUBSCRIPTION'

        WebElement subscription = driver.findElement(By.xpath("//div[@class='single-widget']/h2"));
        Assert.assertEquals("SUBSCRIPTION", subscription.getText());


        //7. Enter email address in input and click arrow button     -- "#susbscribe_email"

        driver.findElement(By.cssSelector("#susbscribe_email")).sendKeys("absd@yopmail.com", Keys.ENTER);

        //8. Verify success message 'You have been successfully subscribed!' is visible

        WebElement successflySub = driver.findElement(By.xpath("//div[@class='alert-success alert']"));

        Assert.assertEquals("You have been successfully subscribed!", successflySub.getText());


    }
}
