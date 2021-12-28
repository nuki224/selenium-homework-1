import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebElementsTest {
    public static void main (String [] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        //click on button 3 times
        for (int i = 0; i < 3; i++){
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        //print out the last "Delete" button
        String lastButton = driver.findElement(By.xpath("//*[@id=\"elements\"]/button[3]")).getText();
        System.out.println(lastButton);
        //Print out the last 'Delete' button with findElements()
        List<WebElement> elements = driver.findElements(By.cssSelector("#elements > button:nth-child(3)"));
        for(WebElement element : elements) {
            System.out.println(element.getText());
        }
        System.out.println(driver.findElement(By.xpath("//button[contains(@class ,'manually')][last()][text()='Delete']")).getText());
    }
}
