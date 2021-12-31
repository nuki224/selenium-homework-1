import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebElementsTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        //click on button 3 times
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
//        //print out the last "Delete" button
        String lastButton = driver.findElement(By.xpath("//*[@id=\"elements\"]/button[last()]")).getText();
        System.out.println(lastButton);
//        //Print out the last 'Delete' button with findElements
        List<WebElement> lastbuttonn = driver.findElements(By.cssSelector("[button^='added']"));
        System.out.println(lastbuttonn.get(lastbuttonn.size()-1));
        System.out.println(driver.findElement(By.xpath("//button[contains(@class ,'manually')][last()][text()='Delete']")).getText());//        System.out.println(lastbuttonnn);
        driver.close();
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        driver.manage().window().maximize();
        System.out.println(driver.findElements(By.xpath("//td[text()='Apeirian9']/preceding::td[1]")));
        System.out.println(driver.findElements(By.xpath("//tr[td='Apeirian9'][2]/td/following-sibling::td[1]")));
        }
    }

