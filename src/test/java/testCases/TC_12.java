package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class TC_12 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        ilk3Step();
        //4. Click 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        bekle(2);
        //5. Hover over first product and click 'Add to cart'  -- //a[@data-product-id='1']
        reklamKapat();
        WebElement firstProductAdd = driver.findElement(By.xpath("//a[@data-product-id='1']"));
        firstProductAdd.click();

        //6. Click 'Continue Shopping' button   -- //button[@class='btn btn-success close-modal btn-block']
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        //7. Hover over second product and click 'Add to cart'  -- //a[@data-product-id='2']
        WebElement secondProductAdd = driver.findElement(By.xpath("//a[@data-product-id='2']"));
        secondProductAdd.click();

        //8. Click 'View Cart' button   -- (//a[@href='/view_cart'])[2]

        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

        //9. Verify both products are added to Cart
        WebElement firstProductName = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        WebElement secondProductName = driver.findElement(By.xpath("//a[@href='/product_details/2']"));

        List<WebElement> cartProducts = driver.findElements(By.xpath("//tbody/tr/td/h4/a"));
        Assert.assertEquals(cartProducts.get(0).getText(), firstProductName.getText());
        Assert.assertEquals(cartProducts.get(1).getText(), secondProductName.getText());

        //10. Verify their prices, quantity and total price

        WebElement firstPrice = driver.findElement(By.xpath("//table/tbody/tr[1]/td[position()=3]"));
        WebElement firstTotalPrice = driver.findElement(By.xpath("//table/tbody/tr[1]/td[position()=5]"));

        WebElement secondPrice = driver.findElement(By.xpath("//table/tbody/tr[2]/td[position()=3]"));
        WebElement secondTotalPrice = driver.findElement(By.xpath("//table/tbody/tr[2]/td[position()=5]"));

        WebElement firstQuantity = driver.findElement(By.xpath("//table/tbody/tr[1]/td[position()=4]"));
        WebElement secondQuantity = driver.findElement(By.xpath("//table/tbody/tr[2]/td[position()=4]"));

        Assert.assertEquals(firstPrice.getText(),firstTotalPrice.getText());
        Assert.assertEquals(secondPrice.getText(),secondTotalPrice.getText());

        Assert.assertEquals("1",firstQuantity.getText());
        Assert.assertEquals("1",secondQuantity.getText());
    }


}
