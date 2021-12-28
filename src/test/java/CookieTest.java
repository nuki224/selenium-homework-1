import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieTest {
    public static void main (String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        driver.manage().window().maximize();
        //Sign in the system and save cookies
        driver.findElement(By.name("username")).sendKeys("user123");
        driver.findElement(By.name("password")).sendKeys("xyz123");
        driver.findElement(By.name("submit")).click();
        //Delete cookies with name "Selenium"
        driver.manage().deleteCookieNamed("Selenium");
        driver.close();
    }
}
