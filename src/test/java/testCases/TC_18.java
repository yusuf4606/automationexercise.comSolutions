package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_18 extends TestBase {
    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        bekle(1);

        //3. Verify that categories are visible on left side bar
        WebElement categories = driver.findElement(By.xpath("//div[@class='left-sidebar']/h2[.='Category']"));
        Assert.assertTrue(categories.isDisplayed());
        bekle(1);

        //4. Click on 'Women' category
        WebElement womenCategory = driver.findElement(By.xpath("//*[@href='#Women']"));
        womenCategory.click();
        bekle(1);
        //5. Click on any category link under 'Women' category, for example: Dress
        WebElement dress = driver.findElement(By.xpath("//*[@href='/category_products/1' and .='Dress ']"));
        dress.click();
        bekle(1);
        reklamKapat();
        bekle(1);

        //6. Verify that category page is displayed and confirm text 'Women - Dress Products'

        WebElement womenDressProductsText = driver.findElement(By.xpath("//h2[@class='title text-center' and .='Women - Dress Products']"));
        Assert.assertEquals("WOMEN - DRESS PRODUCTS", womenDressProductsText.getText());
        bekle(1);
        //7. On left side bar, click on any sub-category link of 'Men' category
        WebElement menCategory = driver.findElement(By.xpath("//*[@href='#Men']"));
        menCategory.click();
        bekle(2);
        WebElement jeansOfMen = driver.findElement(By.xpath("//a[@href='/category_products/6']"));
        jeansOfMen.click();
        bekle(1);
        //8. Verify that user is navigated to that category page
        WebElement menJeansProducts = driver.findElement(By.xpath("//h2[@class='title text-center' and .='Men - Jeans Products']"));
        Assert.assertEquals("text dogrulanamadi","MEN - JEANS PRODUCTS",menJeansProducts.getText());
    }
}