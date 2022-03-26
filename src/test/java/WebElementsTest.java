import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class WebElements {
    @Test
    void test1 () {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//*[contains(text(),'Add Element')]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        String lastButton = driver.findElement(By.xpath("//*[@id=\"elements\"]/button[last()]")).getText();
        System.out.println(lastButton);
        List<WebElement> lastbuttonn = driver.findElements(By.cssSelector("[button^='added']"));
        System.out.println(lastbuttonn.get(lastbuttonn.size() - 1));
        System.out.println(driver.findElement(By.xpath("//button[contains(@class ,'manually')][last()][text()='Delete']")).getText());//        System.out.println(lastbuttonnn);
        driver.close();
    }
    @Test
        void test2 () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        driver.manage().window().maximize();
        System.out.println(driver.findElements(By.xpath("//td[text()='Apeirian9']/preceding::td[1]")));
        System.out.println(driver.findElements(By.xpath("//tr[td='Apeirian9'][2]/td/following-sibling::td[1]")));
    }
}


