package testCases;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TC_15 extends TestBase {
    @Test
    public void test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        ilk3Step();

        //4. Click 'Signup / Login' button
        //5. Fill all details in Signup and create account
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        accountCreate();    // step 4+5+6
        WebElement continueButton = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
        continueButton.click();
        bekle(2);
        reklamKapat();


        //7. Verify ' Logged in as username' at top
        loggedInAsUserJosef();



        //8. Add products to cart
        WebElement product1AddToCart = driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]"));
        product1AddToCart.click();

        //9. Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("//a[.='View Cart']"));
        cartButton.click();
        bekle(2);

        //10. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//a[@href='/view_cart' and @style='color: orange;']"));
        Assert.assertTrue(cartPage.isDisplayed());
        //11. Click Proceed To Checkout
        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[.='Proceed To Checkout']"));
        proceedToCheckout.click();
        bekle(1);

        //12. Verify Address Details and Review Your Order
        WebElement addressDetails = driver.findElement(By.xpath("//*[.='Address Details']"));
        WebElement reviewYourOrder = driver.findElement(By.xpath("//*[.='Review Your Order']"));
        Assert.assertTrue(addressDetails.isDisplayed());
        Assert.assertTrue(reviewYourOrder.isDisplayed());

        //13. Enter description in comment text area and click 'Place Order'

        WebElement comment = driver.findElement(By.xpath("//textarea[@name='message']"));
        comment.sendKeys("Automation Exercise TestCase 15 ", Keys.TAB,Keys.ENTER);

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOnCart = driver.findElement(By.cssSelector("input[class='form-control']"));
        nameOnCart.sendKeys("Josef",
                Keys.TAB, new Faker().number().digits(12),
                Keys.TAB, "311",
                Keys.TAB, "12",
                Keys.TAB, "2025", Keys.ENTER);  //    15. Click 'Pay and Confirm Order' button


        //16. Verify success message 'Your order has been placed successfully!'
        bekle(1);
        driver.navigate().back();
        List<WebElement> successfly = driver.findElements(By.xpath("//div[@id='success_message']"));
        Assert.assertTrue(successfly.size()>0);
        bekle(1);
        driver.findElement(By.id("submit")).click();
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        bekle(1);
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//h2/b[.='Account Deleted!']"));
        accountDeleted.click();
        bekle(2);
        Assert.assertTrue(accountDeleted.isDisplayed());
    }
}
