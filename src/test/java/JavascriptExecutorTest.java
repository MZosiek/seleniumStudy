import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavascriptExecutorTest {

    @Test
    public void javaScriptExe(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");


        WebElement coursePage = driver.findElement(By.xpath("//a[text()='Podstawowa strona testowa']"));

        // klikanie przez JS
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",coursePage);

        //wprowadzanie danych przez JS
        WebElement textPlace = driver.findElement(By.xpath("//input[@id='fname']"));
        executor.executeScript("arguments[0].setAttribute('value','Marcin')",textPlace);

    }
}
