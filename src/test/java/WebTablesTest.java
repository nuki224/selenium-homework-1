import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesTest {
    public static void main (String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("http://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();
        System.out.println("Honda's price is: " + driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr[4]/td[3]")).getText());

    }
}
