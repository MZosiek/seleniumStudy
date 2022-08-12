import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KlasaActions {

    @Test
    public void ActionsTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        Actions actions = new Actions(driver);

        WebElement doubleclick = driver.findElement(By.xpath("//button[@id='bottom']"));
        actions.contextClick(doubleclick).perform();

        actions.doubleClick(doubleclick).perform();

    }
}
