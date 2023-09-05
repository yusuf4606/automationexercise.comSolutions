package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class TC_09 extends TestBase {
    @Test
    public void test() {
        //    1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//            3. Verify that home page is visible successfully
        ilk3Step();
//4. Click on 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        bekle(2);
//5. Verify user is navigated to ALL PRODUCTS page successfully

        reklamKapat();

        WebElement allProducts = driver.findElement(By.xpath("//h2[.='All Products']"));
        Assert.assertTrue(allProducts.isDisplayed());

//6. Enter product name in search input and click search button
        String textToSearch = "Jeans";
        driver.findElement(By.cssSelector("input[id='search_product']")).
                sendKeys(textToSearch,
                Keys.TAB,
                Keys.ENTER);
//7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement sP = driver.findElement(By.xpath("//h2[.='Searched Products']"));
        Assert.assertTrue(sP.isDisplayed());

//8. Verify all the products related to search are visible


        List<WebElement> products = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        int sizeOfProducts = products.size();
        System.out.println("sizeOfProducts = " + sizeOfProducts);

        if (sizeOfProducts == 0) {
            System.out.println(textToSearch + " doesn't exist in the Website");
        } else {
            for (WebElement w : products) {
                    Assert.assertTrue(w.getText() + " doesn't have " + textToSearch, w.getText().contains(textToSearch));
            }
        }


    }

}
