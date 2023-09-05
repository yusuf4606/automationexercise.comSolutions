package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_13 extends TestBase {
    @Test
    public void test01() {
        //  1. Launch browser
        //  2. Navigate to url 'http://automationexercise.com'
        //  3. Verify that home page is visible successfully
        ilk3Step();

        //  4. Click 'View Product' for any product on home page
        bekle(2);
        WebElement viewProduct2 = driver.findElement(By.xpath("//*[@href='/product_details/2']"));
        viewProduct2.click();
        bekle(1);

        //  5. Verify product detail is opened
        reklamKapat();
        WebElement available = driver.findElement(By.xpath("//b[.='Availability:']"));
        WebElement condition = driver.findElement(By.xpath("//b[.='Condition:']"));
        WebElement brand = driver.findElement(By.xpath("//b[.='Brand:']"));
        Assert.assertTrue(available.isDisplayed());
        Assert.assertTrue(condition.isDisplayed());
        Assert.assertTrue(brand.isDisplayed());


        //  6. Increase quantity to 4
        WebElement quantityBox = driver.findElement(By.xpath("//input[@id='quantity']"));
        quantityBox.clear();
        quantityBox.sendKeys("4",
                Keys.TAB, Keys.ENTER); //   7. Click 'Add to cart' button


        //   8. Click 'View Cart' button    -- "(//u)[1]"
        driver.findElement(By.xpath("(//u)[1]")).click();
        bekle(1);
        //   9. Verify that product is displayed in cart page with exact quantity
        WebElement quantity = driver.findElement(By.xpath("//tbody/tr/td[4]"));

        Assert.assertEquals("4", quantity.getText());


    }
}
