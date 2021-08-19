package pl.coderslab.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.awaitility.Awaitility.await;

public class Task2 {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
        driver.findElement(By.id("_desktop_user_info")).click();
        driver.findElement(By.className("form-control")).sendKeys("cinek_jedz@o2.pl");
        driver.findElement(By.name("password")).sendKeys("Zadanie1");
        driver.findElement(By.id("submit-login")).click();

        driver.findElement(By.xpath("//*[@id=\"_desktop_logo\"]/a/img")).click();

        driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/article[1]/div/a/img")).click();
        driver.findElement(By.xpath("//*[@id=\"group_1\"]")).sendKeys("M");

        for (int i = 0; i < 7; i++) {
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();
            driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        }

        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-option-1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();

        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C://Users//Marcin//Desktop//Screenshot.png"));

    }

    public static boolean waitForElementVisibility(WebDriver driver, By selector) {
        try {
            driver.findElement(selector);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
            return false;
        }
        System.out.println("Element found");
        return true;
    }
}
