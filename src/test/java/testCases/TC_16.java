package testCases;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TC_16 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        ilk3Step();
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        bekle(2);
        //5. Fill email, password and click 'Login' button
        WebElement loginEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        loginEmail.sendKeys("josh.barrows@gmail.com", Keys.TAB,"quxza1iqyu3e2",Keys.ENTER);

        //6. Verify 'Logged in as username' at top
        loggedInAsUserJosef();
        //7. Add products to cart
        WebElement product1AddToCart = driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]"));
        product1AddToCart.click();
        //8. Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("//a[.='View Cart']"));
        cartButton.click();
        bekle(2);
        //9. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//a[@href='/view_cart' and @style='color: orange;']"));
        Assert.assertTrue(cartPage.isDisplayed());
        //10. Click Proceed To Checkout
        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[.='Proceed To Checkout']"));
        proceedToCheckout.click();
        bekle(1);

        //11. Verify Address Details and Review Your Order
        WebElement addressDetails = driver.findElement(By.xpath("//*[.='Address Details']"));
        WebElement reviewYourOrder = driver.findElement(By.xpath("//*[.='Review Your Order']"));
        Assert.assertTrue(addressDetails.isDisplayed());
        Assert.assertTrue(reviewYourOrder.isDisplayed());

        //12. Enter description in comment text area and click 'Place Order'

        WebElement comment = driver.findElement(By.xpath("//textarea[@name='message']"));
        comment.sendKeys("Automation Exercise TestCase 15 ", Keys.TAB,Keys.ENTER);
        bekle(2);
        reklamKapat();
        bekle(1);

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOnCart = driver.findElement(By.cssSelector("input[class='form-control']"));
        nameOnCart.sendKeys("Josef",
                Keys.TAB, new Faker().number().digits(12),
                Keys.TAB, "311",
                Keys.TAB, "12",
                Keys.TAB, "2025", Keys.ENTER);  //    15. Click 'Pay and Confirm Order' button


        //14. Verify success message 'Your order has been placed successfully!'
        bekle(1);
        driver.navigate().back();
        List<WebElement> successfly = driver.findElements(By.xpath("//div[@id='success_message']"));
        Assert.assertTrue(successfly.size()>0);
        bekle(1);
        driver.findElement(By.id("submit")).click();
        //15. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        bekle(1);
        //16. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//h2/b[.='Account Deleted!']"));
        accountDeleted.click();
        bekle(2);
        Assert.assertTrue(accountDeleted.isDisplayed());

    }

    @Test
    public void test02() {
        driver.get("http://automationexercise.com");
        accountCreate();
    }
}
