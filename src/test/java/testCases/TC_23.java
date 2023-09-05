package testCases;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_23 extends TestBase {
    @Test
    public void test01() {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    ilk3Step();

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
                Keys.TAB,("i"+eMail));
        System.out.println("eMail = " + "i"+eMail);

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
// 10. Fill details:
        WebElement firstNameBox = driver.findElement(By.cssSelector("#first_name"));

        String adress = "Kolner strasse 55";
        firstNameBox.sendKeys("Josef",  // First name,
                Keys.TAB, "Colnet",           // Last name,
                Keys.TAB, "Colnet GMBH",        // Company,
                Keys.TAB,adress,           //Address,
                Keys.TAB, adress + "a",          //  Address2,
                Keys.TAB, "United States",                   // Country,
                Keys.TAB, faker.address().state(),          // State,
                Keys.TAB, faker.address().city(),            //  City,
                Keys.TAB, faker.address().zipCode(),      //  Zipcode,
                Keys.TAB, faker.number().digits(11),   // Mobile Number
                Keys.ENTER                   //  Click 'Create Account button'
        );


//11. Verify that 'ACCOUNT CREATED!' is visible
        WebElement aC = driver.findElement(By.xpath("//b"));
        Assert.assertEquals("ACCOUNT CREATED!", aC.getText());



        WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();
        bekle(1);
        reklamKapat();
        bekle(2);
    //12. Verify ' Logged in as username' at top
        loggedInAsUserJosef();
    //13. Add products to cart

        WebElement addProduct1 = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));
        addProduct1.click();
    //14. Click 'Cart' button1
        WebElement viewCart = driver.findElement(By.xpath("//a[@href='/view_cart']/u"));
        viewCart.click();
    //15. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//a[@href='/view_cart' and @style='color: orange;']"));
        Assert.assertTrue(cartPage.isDisplayed());
        bekle(2);
    //16. Click Proceed To Checkout
        WebElement proceedToCheckout = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        proceedToCheckout.click();
        bekle(2);
    //17. Verify that the delivery address is same address filled at the time registration of account
        WebElement deliveryAddress  = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[2]"));
        Assert.assertEquals(adress,deliveryAddress.getText());
        bekle(2);
    //18. Verify that the billing address is same address filled at the time registration of account  // (//li[@class='address_address1 address_address2'])[5]
        WebElement billingAddress  = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[5]"));
        Assert.assertEquals(adress,billingAddress.getText());
        bekle(2);
    //19. Click 'Delete Account' button

        WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccount.click();

    //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeletedText = driver.findElement(By.xpath("//div/h2/b"));
        Assert.assertTrue(accountDeletedText.isDisplayed());
}
}