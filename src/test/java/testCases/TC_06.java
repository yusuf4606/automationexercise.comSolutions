package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class TC_06 extends TestBase {
    @Test
    public void tst() {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully

        ilk3Step();

//        4. Click on 'Contact Us' button      "//a[@href='/contact_us']"
        bekle(2);
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

//        5. Verify 'GET IN TOUCH' is visible      "(//h2[@class='title text-center'])[2]" --> Get in Touch
        Assert.assertEquals("GET IN TOUCH",
                driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).getText());

//        6. Enter name ("(//input)[2]") , email, subject and message
        WebElement nameBox = driver.findElement(By.xpath("(//input)[2]"));
        nameBox.sendKeys("Josef",
                Keys.TAB, "kimberlee.boyer@gmail.com",
                Keys.TAB, "Test Case 3",
                Keys.TAB, "Hello World!");

//        7. Upload file    dosyaSecButton --> cssSelector = "input[name='upload_file']"
        WebElement dosyaSec = driver.findElement(By.cssSelector("input[name='upload_file']"));
        String dosyaYolu = "C:\\Users\\Sibi\\Desktop\\B171.txt";
        dosyaSec.sendKeys(dosyaYolu);

//        8. Click 'Submit' button    -- > cssSelector > "input[type='submit']"

        bekle(2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

//        9. Click OK button
        driver.switchTo().alert().accept();

//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        // cssSelector "div[class='status alert alert-success']"

        WebElement succesText = driver.findElement(By.cssSelector("div[class='status alert alert-success']"));
        Assert.assertEquals("Success! Your details have been submitted successfully.", succesText.getText());
        bekle(1);

//        11. Click 'Home' button and verify that landed to home page successfully
        // home --> i[@class='fa fa-angle-double-left']
        // (//a[@href='/'])[2]

        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();

        bekle(1);

        reklamKapat();


        WebElement homeColorOrange = driver.findElement(By.xpath("//a[@href='/' and @style='color: orange;']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(homeColorOrange));
        Assert.assertTrue(homeColorOrange.isEnabled());

//
    }
}
