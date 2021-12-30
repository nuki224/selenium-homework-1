import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exceptions {
    public static void main(String[] args) {
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
        WebElement date = driver.findElement(By.id("datepicker"));
        date.click();
        driver.findElement((By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]"))).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[last()]//td[@data-event='click'][last()]")).click();


        driver.get(" https://demoqa.com/alerts ");
        driver.manage().window().maximize();
        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, 4);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            System.out.println("Time out");
        }
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No Alert Presented");
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } try {
            datebutton.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale element reference");
        }
        driver.quit();
        }
    }


