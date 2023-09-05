package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_21 extends TestBase {
    @Test
    public void test01() {


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button
        WebElement productsButton = driver.findElement(By.xpath("//a[@href='/products']"));
        productsButton.click();
        bekle(1);
        reklamKapat();
        bekle(1);
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsHead = driver.findElement(By.xpath("//h2[@class='title text-center' and .='All Products']"));
        Assert.assertTrue(allProductsHead.isDisplayed());

        //5. Click on 'View Product' button

        WebElement viewProduct2 = driver.findElement(By.xpath("//a[@href='/product_details/2']"));
        viewProduct2.click();
        bekle(2);
        //6. Verify 'Write Your Review' is visible
        WebElement writeYourReview = driver.findElement(By.xpath("//a[.='Write Your Review']"));
        Assert.assertTrue(writeYourReview.isDisplayed());


        //7. Enter name, email and review

        WebElement yourNameBox = driver.findElement(By.xpath("//*[@id='name']"));
        yourNameBox.sendKeys("Josef", Keys.TAB,"ghj@yopmail.com",Keys.TAB,"review",
                Keys.TAB,Keys.ENTER); //8. Click 'Submit' button

        //9. Verify success message 'Thank you for your review.'
        WebElement thankYouForYourReview = driver.findElement(By.xpath("//div[@class='alert-success alert']/span"));
        Assert.assertTrue(thankYouForYourReview.isDisplayed());

    }
}
