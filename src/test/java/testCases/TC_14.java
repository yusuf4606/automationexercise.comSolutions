package testCases;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.stylesheets.LinkStyle;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class TC_14 extends TestBase {
    @Test
    public void test01() {
//    1. Launch browser
//    2. Navigate to url 'http://automationexercise.com'
//    3. Verify that home page is visible successfully

        ilk3Step();

//    4. Add products to cart

        WebElement firstProductAddToCart = driver.findElement(By.xpath("//a[@data-product-id='1']"));
        firstProductAddToCart.click();
//    5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();
//    6. Verify that cart page is displayed
        WebElement cartColorOrange = driver.findElement(By.xpath("//a[@href='/view_cart' and @style='color: orange;']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(cartColorOrange));
        Assert.assertTrue(cartColorOrange.isEnabled());
        bekle(1);

//    7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[.='Proceed To Checkout']")).click();
        bekle(1);
//    8. Click 'Register / Login' button

        driver.findElement(By.xpath("(//u)[1]")).click();

//    9. Fill all details in Signup and create account
        accountCreate();
        bekle(2);
//    10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        bekle(2);
        reklamKapat();
//    11. Verify ' Logged in as username' at top
        WebElement loggedInAsUserName = driver.findElement(By.xpath("//a[.=' Logged in as Josef']"));
        Assert.assertTrue(loggedInAsUserName.isDisplayed());
//    12.Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        bekle(2);
//    13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[.='Proceed To Checkout']")).click();
        bekle(1);
//    14. Verify Address Details and Review Your Order
        WebElement addressDetails = driver.findElement(By.xpath("(//h2)[1]"));
        WebElement reviewYourOrder = driver.findElement(By.xpath("(//h2)[2]"));

        Assert.assertTrue(addressDetails.isDisplayed());
        Assert.assertTrue(reviewYourOrder.isDisplayed());

//    15. Enter description in comment text area and click 'Place Order'
        WebElement textArea = driver.findElement(By.xpath("//textarea[@name='message']"));
        textArea.sendKeys("comment", Keys.TAB, Keys.ENTER);
        bekle(2);

//    16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOnCart = driver.findElement(By.cssSelector("input[class='form-control']"));
        nameOnCart.sendKeys("Josef",
                Keys.TAB, new Faker().number().digits(12),
                Keys.TAB, "311",
                Keys.TAB, "12",
                Keys.TAB, "2025", Keys.ENTER);  //    17. Click 'Pay and Confirm Order' button


//    18. Verify success message 'Your order has been placed successfully!'
        bekle(1);
        driver.navigate().back();
        List<WebElement> successfly = driver.findElements(By.xpath("//div[@id='success_message']"));
        Assert.assertTrue(successfly.size()>0);
        bekle(1);
        driver.findElement(By.id("submit")).click();
//    19. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        bekle(1);
//    20. Verify 'ACCOUNT DELETED!' and click 'Continue' button

        WebElement accountDeleted = driver.findElement(By.xpath("//b"));
        accountDeleted.click();
        bekle(2);
        Assert.assertTrue(accountDeleted.isDisplayed());

    }

    @Test
    public void name() {
        driver.get("https://automationexercise.com/payment");

        WebElement nameOnCart = driver.findElement(By.cssSelector("input[class='form-control']"));
        nameOnCart.sendKeys("Josef",
                Keys.TAB, new Faker().number().digits(12),
                Keys.TAB, "311",
                Keys.TAB, "12",
                Keys.TAB, "2025",Keys.TAB,Keys.ENTER);  //    17. Click 'Pay and Confirm Order' button

       bekle(1);

       driver.navigate().back();
       List<WebElement> successfly = driver.findElements(By.xpath("//div[@class='col-md-12 form-group hide' and @id='success_message']"));
       Assert.assertTrue(successfly.size()>0);
       bekle(2);
       driver.findElement(By.id("submit")).click();



    }
}
