import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class AutoComplete {
    public static void main (String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("Automation");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Put all the suggestions in the list
        List<WebElement> elements = driver.findElements(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > div:nth-child(2)"));
        System.out.println(elements.size());
        for (WebElement b: elements) {
            String element = b.getText();
            System.out.println(element);
        }
        WebElement element =  driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > div:nth-child(2"));
        element.click();
    }
}
