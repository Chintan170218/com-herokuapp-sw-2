package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {


    //Declaring URL

    String baseUrl = "http://the-internet.herokuapp.com/login";

    //Setting up the browser before each individual test
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //Enter “tomsmith” username
        WebElement enterUsername = driver.findElement(By.id("username"));
        enterUsername.sendKeys("tomsmith");

        //Enter “SuperSecretPassword!” password
        WebElement enterPassword = driver.findElement(By.id("password"));
        enterPassword.sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        WebElement clickLoginBtn = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        clickLoginBtn.click();

        //Verify the text “Secure Area”
        //Declaring the text from the requirements
        String expectedMessage = "Secure Area";

        //Verifying the text from the requirements and getting the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Secure Area')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        // Validating actual vs expected message
        Assert.assertEquals("The text does not match the expected text", actualMessage, expectedMessage);

    }

    @Test
    public void verifyTheUsernameErrorMessage(){

        //Enter “tomsmith1” username
        WebElement enterUsername = driver.findElement(By.id("username"));
        enterUsername.sendKeys("tomsmith1");

        //Enter “SuperSecretPassword!” password
        WebElement enterPassword = driver.findElement(By.id("password"));
        enterPassword.sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        WebElement clickLoginBtn = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        clickLoginBtn.click();

        //Verify the error message “Your username is invalid!”
        //Declaring the text from the requirements
        String expectedMessage = "Your username is invalid!";

        //Verifying the text from the requirements and getting the text
        WebElement actualMessageElement = driver.findElement(By.id("flash"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        //Get the exact actual message as required
        String actualTextFinal=actualMessage.substring(0,25);

        // Validating actual vs expected message
        Assert.assertEquals("The text does not match the expected text", actualTextFinal, expectedMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage(){

        //Enter “tomsmith” username
        WebElement enterUsername = driver.findElement(By.id("username"));
        enterUsername.sendKeys("tomsmith");

        //Enter “SuperSecretPassword” password
        WebElement enterPassword = driver.findElement(By.id("password"));
        enterPassword.sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        WebElement clickLoginBtn = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        clickLoginBtn.click();

        //Verify the error message “Your password is invalid!”
        //Declaring the text from the requirements
        String expectedMessage = "Your password is invalid!";

        //Verifying the text from the requirements and getting the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//div[contains(text(),'Your password is invalid!')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        //Get the exact actual message as required
        String actualTextFinal=actualMessage.substring(0,25);

        // Validating actual vs expected message
        Assert.assertEquals("The text does not match the expected text", actualTextFinal, expectedMessage);

    }

    //Closing the browser after each individual test
    @After
    public void tearDown() {
        closeBrowser();
    }
}
