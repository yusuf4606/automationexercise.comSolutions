package testCases;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_04 extends TestBase {

    @Test
    public void accountCreate() {
        // 1. Launch browser
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
// 3. Verify that home page is visible successfully
        bekle(2);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals("Automation Exercise", actualTitle);
// 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        bekle(2);
// 5. Verify 'New User Signup!' is visible  (//h2)[3]
        WebElement newUserSignUp = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUserSignUp.isDisplayed());
        bekle(2);

// 6. Enter name and email address
        Faker faker = new Faker();
        String eMail = faker.internet().emailAddress();
        String password = faker.internet().password();

        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        nameBox.sendKeys("Josef",
                Keys.TAB,eMail);
        System.out.println("eMail = " + eMail);

// 7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformation = driver.findElement(By.xpath("(//b)[1]"));
// 9. Fill details:  Name, Email, Password,


        WebElement title = driver.findElement(By.xpath("//input[@value='Mr']"));
        title.click();  // Title,
        WebElement passwordBox = driver.findElement(By.cssSelector("#password"));
        passwordBox.sendKeys(password,
                Keys.TAB, "15",     // Date of birth
                Keys.TAB, "June",
                Keys.TAB, "2001",
                Keys.TAB, Keys.SPACE,    // 10. Select checkbox 'Sign up for our newsletter!'
                Keys.TAB, Keys.SPACE);   // 11. Select checkbox 'Receive special offers from our partners!'
        System.out.println("password = " + password);
// 12. Fill details:
        WebElement firstNameBox = driver.findElement(By.cssSelector("#first_name"));

        String fakeAddress = faker.address().fullAddress();
        firstNameBox.sendKeys("Josef",  // First name,
                Keys.TAB, "Colnet",           // Last name,
                Keys.TAB, "Colnet GMBH",        // Company,
                Keys.TAB, fakeAddress,           //Address,
                Keys.TAB, fakeAddress + "a",          //  Address2,
                Keys.TAB, "United States",                   // Country,
                Keys.TAB, faker.address().state(),          // State,
                Keys.TAB, faker.address().city(),            //  City,
                Keys.TAB, faker.address().zipCode(),      //  Zipcode,
                Keys.TAB, faker.number().digits(11),   // Mobile Number
                Keys.ENTER                   // 13. Click 'Create Account button'
        );


// 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement aC = driver.findElement(By.xpath("//b"));
        Assert.assertEquals("ACCOUNT CREATED!", aC.getText());

    }

    @Test
    public void test01() {

        // 1. Launch browser
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        bekle(2);
        String actualUrl = driver.getTitle();
        Assert.assertEquals("Automation Exercise", actualUrl);
// 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();
        bekle(2);
     //   5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertEquals("Login to your account",loginToYourAccount.getText());

     //    and
        //   7.
        //eMail = kimberlee.boyer@gmail.com
        //password = 516jawo7q
        driver.findElement(By.xpath("(//input)[2]")).
                sendKeys("kimberlee.boyer@gmail.com",   // 6. Enter correct email address
                        Keys.TAB,
                        "516jawo7q",   // password
                        Keys.ENTER);   // Click 'login' button


     //   8. Verify that 'Logged in as username' is visible
        WebElement loggedInAsUserName = driver.findElement(By.xpath("//a[.=' Logged in as Josef']"));
        Assert.assertTrue(loggedInAsUserName.isDisplayed());
     //   9. Click 'Logout' button

        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();



      //  10. Verify that user is navigated to login page
        WebElement loginToYourAccount2 = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertEquals("Login to your account",loginToYourAccount2.getText());

    }
}
