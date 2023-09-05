package testCases;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TC_24 extends TestBase {
    @Test
    public void test01() {


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        ilk3Step();
        bekle(2);
        //4. Add products to cart
        WebElement addProduct1 = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));
        addProduct1.click();
        //5. Click 'Cart' button
        WebElement viewCart = driver.findElement(By.xpath("//a[@href='/view_cart']/u"));
        viewCart.click();
        //6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//a[@href='/view_cart' and @style='color: orange;']"));
        Assert.assertTrue(cartPage.isDisplayed());
        bekle(2);
        //7. Click Proceed To Checkout
        WebElement proceedToCheckout = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        proceedToCheckout.click();
        bekle(2);
        //8. Click 'Register / Login' button
        WebElement registerLoginButton = driver.findElement(By.xpath("(//u)[1]"));
        registerLoginButton.click();
        bekle(1);
        accountCreate();

        //9. Fill all details in Signup and create account
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        bekle(2);
        WebElement continueButton = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
        continueButton.click();
        bekle(2);
        reklamKapat();
        //11. Verify ' Logged in as username' at top
        loggedInAsUserJosef();

        //12.Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("//li/a[@href='/view_cart']"));
        cartButton.click();

        //13. Click 'Proceed To Checkout' button

        WebElement proceedToCheckout2 = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        proceedToCheckout2.click();
        bekle(2);

        //14. Verify Address Details and Review Your Order
        WebElement addressDetails = driver.findElement(By.xpath("//*[.='Address Details']"));
        WebElement reviewYourOrder = driver.findElement(By.xpath("//*[.='Review Your Order']"));
        Assert.assertTrue(addressDetails.isDisplayed());
        Assert.assertTrue(reviewYourOrder.isDisplayed());

        //15. Enter description in comment text area and click 'Place Order'
        WebElement comment = driver.findElement(By.xpath("//textarea[@name='message']"));
        comment.sendKeys("Automation Exercise TestCase 15 ", Keys.TAB, Keys.ENTER);
        bekle(2);
        try {
            reklamKapat();
        } catch (Exception e) {
            System.out.println("Reklam cikmadi");
        }
        bekle(1);

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOnCart = driver.findElement(By.cssSelector("input[class='form-control']"));
        nameOnCart.sendKeys("Josef",
                Keys.TAB, new Faker().number().digits(12),
                Keys.TAB, "311",
                Keys.TAB, "12",
                Keys.TAB, "2025", Keys.ENTER);  //    17. Click 'Pay and Confirm Order' button

        //18. Verify success message 'Your order has been placed successfully!'
        bekle(1);
        driver.navigate().back();
        List<WebElement> successfly = driver.findElements(By.xpath("//div[@id='success_message']"));
        Assert.assertTrue(successfly.size() > 0);
        bekle(1);
        driver.findElement(By.id("submit")).click();
        bekle(2);
        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        WebElement invoice = driver.findElement(By.xpath("//*[.='Download Invoice']"));
        invoice.click();
        bekle(2);
        //20. Click 'Continue' button
        WebElement continueButton2 = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton2.click();
        bekle(2);

        //21. Click 'Delete Account' button
        WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccount.click();
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeletedText = driver.findElement(By.xpath("//div/h2/b"));
        Assert.assertTrue(accountDeletedText.isDisplayed());
    }
}