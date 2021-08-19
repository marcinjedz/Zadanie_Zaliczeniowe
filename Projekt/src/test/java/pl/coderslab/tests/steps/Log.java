package pl.coderslab.tests.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static pl.coderslab.tests.CucumberHooks.driver;


public class Log {

    @Given("I'm on MyStore main page")
    public void openMyStore()
    {
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @When("I click sign in")
    public void clickSignIn()
    {
        driver.findElement(By.id("_desktop_user_info")).click();
    }

    @And("I enter email address (.*) on authentication page")
    public void enterMail(String email)
    {
        driver.findElement(By.className("form-control")).sendKeys(email);
    }

    @And("I enter password (.*) and click")
    public void enterPassword(String password)
    {
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }

    @And("I click Addresses and Create new address")
    public void enterForm()
    {
        driver.findElement(By.xpath("//*[@id=\"footer_account_list\"]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/a/span")).click();
    }

    @And("I enter alias (.*) address (.*) city (.*) into form")
    public void enterNewAddress(String alias, String address, String city)
    {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")).sendKeys(alias);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")).sendKeys(address);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")).sendKeys(city);
    }

    @And("I enter zip (.*) country (.*) phone (.*) into form")
    public void enterNewAddress2(String zip, String country, String phone)
    {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")).sendKeys(zip);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select")).sendKeys(country);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select")).click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")).sendKeys(phone);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    @And("I click Save")
    public void clickSave()
    {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
    }

    @Then("I can see success message with text (.*)")
    public void successMessageIsVisible(String expectedText)
    {
        String text = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li")).getText();
        assertEquals(expectedText, text);
    }
}