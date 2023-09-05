package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {

    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        //  driver.close();  // driver en son hangi sayfada ise o kapanir
        //   driver.quit(); // eger birden fazla sayfa acilmissa hepsini kapatir
    }

    //Hard Wait
    public void bekle(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    //Dropdown Select Index
    public void selectIndex(WebElement ddm, int idx){
        Select select = new Select(ddm);
        select.selectByIndex(idx);

    }

    public void selectVisibleText(WebElement ddm, String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);

    }

    public void selectValue(WebElement ddm, String value){
        Select select = new Select(ddm);
        select.selectByVisibleText(value);

    }



    // Window Handles

    public void window(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index-1].toString());
    }
    // iframe index ile
    public void frameIndex(int index){
        driver.switchTo().frame(index);
    }

   // automationExcercise.com
    public void ilk3Step(){
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        bekle(2);
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Automation Exercise", actualTitle);
    }

    // reklam kapat
    public void reklamKapat(){
        Actions actions = new Actions(driver);
        actions.click().perform();

        bekle(2);
    }

    // account create
    public void accountCreate() {

// 1. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        bekle(2);
// 2. Verify 'New User Signup!' is visible  (//h2)[3]
        WebElement newUserSignUp = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUserSignUp.isDisplayed());
        bekle(2);

// 3. Enter name and email address
        Faker faker = new Faker();
        String eMail = faker.internet().emailAddress();
        String password = faker.internet().password();

        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        nameBox.sendKeys("Josef",
                Keys.TAB,eMail);
        System.out.println("eMail = " + eMail);

// 4. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
// 5. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformation = driver.findElement(By.xpath("(//b)[1]"));
// 6. Fill details:  Name, Email, Password,


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
// 7. Fill details:
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
                Keys.ENTER                   //  Click 'Create Account button'
        );


// 8. Verify that 'ACCOUNT CREATED!' is visible
        WebElement aC = driver.findElement(By.xpath("//b"));
        Assert.assertEquals("ACCOUNT CREATED!", aC.getText());

    }
    // sayfayi asagiya indir
    public void pageDown(int k){
        Actions actions = new Actions(driver);

        for (int i = 1; i<=k; i++){
            actions.sendKeys(Keys.PAGE_DOWN);
        }
    }
    // sign up tikla
    public void signUPLoginclick(){
        WebElement signUpLogin = driver.findElement(By.xpath("//*[@href='/login']"));
        signUpLogin.click();
    }

    // 16. Verify that 'Logged in as username' is visible
    public void loggedInAsUserJosef (){
        WebElement loggedInAsUserName = driver.findElement(By.xpath("//a[.=' Logged in as Josef']"));
        Assert.assertTrue(loggedInAsUserName.isDisplayed());
    }

    // scroll moveTo element

    public void toElementScroll(WebElement w){
        new Actions(driver).moveToElement(w).perform();
    }
}

