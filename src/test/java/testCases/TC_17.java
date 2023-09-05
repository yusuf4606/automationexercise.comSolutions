package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_17 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        ilk3Step();
        //4. Add products to cart
        WebElement product1AddToCart = driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]"));
        product1AddToCart.click();
        //5. Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("//a[.='View Cart']"));
        cartButton.click();
        bekle(2);
        //6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//a[@href='/view_cart' and @style='color: orange;']"));
        Assert.assertTrue(cartPage.isDisplayed());
        //7. Click 'X' button corresponding to particular product
        WebElement xButton = driver.findElement(By.xpath("//*[@class='cart_quantity_delete']"));
        xButton.click();
        bekle(2);
        //8. Verify that product is removed from the cart
        WebElement cartIsEmptyText = driver.findElement(By.id("empty_cart"));
        Assert.assertTrue(cartIsEmptyText.isDisplayed());
    }
}
