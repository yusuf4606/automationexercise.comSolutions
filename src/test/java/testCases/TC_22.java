package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import java.time.Duration;

public class TC_22 extends TestBase {
    @Test
    public void test01()  {


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Scroll to bottom of page
        WebElement links = driver.findElement(By.xpath("(//i[@class='fa fa-angle-left'])[2]"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(links).perform();

        //4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement recommendedItems = driver.findElement(By.xpath("//*[.='recommended items']"));
        Assert.assertTrue(recommendedItems.isDisplayed());

        //5. Click on 'Add To Cart' on Recommended product
        bekle(2);
        WebElement menTshirt = driver.findElement(By.xpath("(//p[.='Men Tshirt'])[2]"));

        WebElement addToCartOnRecommended = driver.findElement(By.xpath("(//a[@data-product-id='2' and .='Add to cart'])[3]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(addToCartOnRecommended));
        String menTshirtText = driver.findElement(By.xpath("(//p[.='Men Tshirt'])[3]")).getText();
        System.out.println("menTshirtText = " + menTshirtText);
        addToCartOnRecommended.click();
        bekle(2);
        //6. Click on 'View Cart' button
        WebElement viewCart = driver.findElement(By.xpath("//a[@href='/view_cart']/u"));
        viewCart.click();
        bekle(1);
        //7. Verify that product is displayed in cart page
        WebElement cartProduct = driver.findElement(By.xpath("//tbody/tr/td[2]/h4/a"));
        System.out.println("cartProduct.getText() = " + cartProduct.getText());
        Assert.assertTrue(cartProduct.getText().equalsIgnoreCase(menTshirtText));
    }
}