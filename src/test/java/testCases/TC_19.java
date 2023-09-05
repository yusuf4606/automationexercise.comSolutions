package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TC_19 extends TestBase {
    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        bekle(1);
        //3. Click on 'Products' button
        WebElement productsButton = driver.findElement(By.xpath("//*[@href='/products']"));
        productsButton.click();
        bekle(1);
        try {
            reklamKapat();
        } catch (Exception e) {
            System.out.println("reklam cikmadi");
        }
        bekle(2);
        //4. Verify that Brands are visible on left side bar

        WebElement brands = driver.findElement(By.xpath("//div[@class='brands_products']/h2"));
        Assert.assertTrue(brands.isDisplayed());

        //5. Click on any brand name
        WebElement polo = driver.findElement(By.xpath("//a[@href='/brand_products/Polo']"));
        polo.click();
        bekle(2);
        //6. Verify that user is navigated to brand page and brand products are displayed
        WebElement brandPoloProducts = driver.findElement(By.xpath("//h2[@class='title text-center' and .='Brand - Polo Products']"));
        Assert.assertTrue(brandPoloProducts.isDisplayed());
        //7. On left side bar, click on any other brand link
        WebElement bibaBrands = driver.findElement(By.xpath("//*[@href='/brand_products/Biba']"));
        //8. Verify that user is navigated to that brand page and can see products
        WebElement bibaBrandProductsText = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(bibaBrandProductsText.isDisplayed());

        List<WebElement> brandBibaProducts = driver.findElements(By.xpath("//div[@class='product-image-wrapper']"));
        for (WebElement w: brandBibaProducts) {
            Assert.assertTrue(w.isDisplayed());
        }

    }
}