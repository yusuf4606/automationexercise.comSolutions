package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TC_20 extends TestBase {
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
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsHead = driver.findElement(By.xpath("//h2[@class='title text-center' and .='All Products']"));
        Assert.assertTrue(allProductsHead.isDisplayed());

        //5. Enter product name in search input and click search button
        String searchText = "Jeans";
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search_product']"));
        searchBox.sendKeys(searchText, Keys.TAB, Keys.ENTER);

        //6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts = driver.findElement(By.xpath("//*[.='Searched Products']"));
        Assert.assertTrue(searchedProducts.isDisplayed());

        //7. Verify all the products related to search are visible
        List<WebElement> jeans = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        for (WebElement jean : jeans) {
            Assert.assertTrue(jean.getText().contains(searchText));
        }
        //8. Add those products to cart
        WebElement product1 = driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[.='Soft Stretch Jeans']"));
        WebElement product2 = driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[.='Regular Fit Straight Jeans']"));
        WebElement product3 = driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[.='Grunt Blue Slim Fit Jeans']"));
        String product1Name = "Soft Stretch Jeans";
        String product2Name = "Regular Fit Straight Jeans";
        String product3Name = "Grunt Blue Slim Fit Jeans";
bekle(1);
        List<WebElement> allProductsAddCart =
                driver.findElements(By.xpath("//div[@class='productinfo text-center']/a[@class='btn btn-default add-to-cart']"));

        WebElement continueShopping = driver.findElement(By.xpath("//*[.='Continue Shopping']"));
        int count = 1;
        for (WebElement product : allProductsAddCart) {
            product.click();
            bekle(1);
            if (count < 3) {
                continueShopping.click();
            }
            count++;
        }
        bekle(1);


        //9. Click 'Cart' button and verify that products are visible in cart
        WebElement viewCart = driver.findElement(By.xpath("//a[@href='/view_cart']/u"));
        viewCart.click();
        bekle(1);

        WebElement cartProduct1 = driver.findElement(By.xpath("//a[@href='/product_details/33']"));
        WebElement cartProduct2 = driver.findElement(By.xpath("//a[@href='/product_details/35']"));
        WebElement cartProduct3 = driver.findElement(By.xpath("//a[@href='/product_details/37']"));
        bekle(1);

        Assert.assertTrue(cartProduct1.getText().equalsIgnoreCase(product1Name));
        Assert.assertTrue(cartProduct2.getText().equalsIgnoreCase(product2Name));
        Assert.assertTrue(cartProduct3.getText().equalsIgnoreCase(product3Name));


        //10. Click 'Signup / Login' button and submit login details

        WebElement signUpLogin = driver.findElement(By.xpath("//a[@href='/login']/i"));
        signUpLogin.click();
        bekle(1);

        WebElement emailLogin = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailLogin.sendKeys("steffanie.marvin@hotmail.com", Keys.TAB, "7nhbslp42rhv", Keys.ENTER);

        //11. Again, go to Cart page

        WebElement cartPage = driver.findElement(By.xpath("//a[@href='/view_cart']/i"));
        cartPage.click();
        bekle(1);

        //12. Verify that those products are visible in cart after login as well

        WebElement loginCartProduct1 = driver.findElement(By.xpath("//a[@href='/product_details/33']"));
        WebElement loginCartProduct2 = driver.findElement(By.xpath("//a[@href='/product_details/35']"));
        WebElement loginCartProduct3 = driver.findElement(By.xpath("//a[@href='/product_details/37']"));
        bekle(1);

        Assert.assertTrue(loginCartProduct1.getText().equalsIgnoreCase(product1Name));
        Assert.assertTrue(loginCartProduct2.getText().equalsIgnoreCase(product2Name));
        Assert.assertTrue(loginCartProduct3.getText().equalsIgnoreCase(product3Name));
    }
}