package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class TC_08 extends TestBase {
    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        ilk3Step();


//4. Click on 'Products' button    -- "//*[@href='/products']"
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        bekle(2);

//5. Verify user is navigated to ALL PRODUCTS page successfully    "//h2[.='All Products']"


        reklamKapat();
        WebElement allProducts = driver.findElement(By.xpath("//h2[.='All Products']"));
        Assert.assertTrue(allProducts.isDisplayed());
//6. The products list is visible   //ul[@class='nav nav-pills nav-justified']
        List<WebElement> pruducts = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        pruducts.forEach(t -> System.out.println(t.getText()));

//7. Click on 'View Product' of first product

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();
        bekle(2);
//8. User is landed to product detail page
// //b[.='Availability:'] //b[.='Condition:']  //b[.='Brand:']

//9. Verify that detail is visible: product name "//h2[.='Blue Top']",
// category,  "//p[.='Category: Women > Tops']"
// price,  "//span[.='Rs. 500']"
// availability, condition, brand
        WebElement available = driver.findElement(By.xpath("//b[.='Availability:']"));
        WebElement condition = driver.findElement(By.xpath("//b[.='Condition:']"));
        WebElement brand = driver.findElement(By.xpath("//b[.='Brand:']"));
        WebElement name = driver.findElement(By.xpath("//h2[.='Blue Top']"));
        WebElement category = driver.findElement(By.xpath("//p[.='Category: Women > Tops']"));
        WebElement price = driver.findElement(By.xpath("//span[.='Rs. 500']"));

        Assert.assertTrue(available.isDisplayed());
        Assert.assertTrue(condition.isDisplayed());
        Assert.assertTrue(brand.isDisplayed());
        Assert.assertTrue(name.isDisplayed());
        Assert.assertTrue(category.isDisplayed());
        Assert.assertTrue(price.isDisplayed());

    }
}