import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceptions {
    public static void main (String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        WebElement datebutton = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
        datebutton.click();
        try {
            driver.switchTo().frame(10);
        } catch (NoSuchFrameException e) {
            System.out.println("No such frame");
            driver.switchTo().frame(datebutton);
        }
    }
}
