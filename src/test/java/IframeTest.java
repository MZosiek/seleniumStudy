import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {

    @Test
    public void BasicActions2 () {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");

        // przejście na iframe'a z indeksem 0 , czyli pierwszego na stronie
        driver.switchTo().frame(0);
        driver.switchTo().defaultContent();

        //druga metoda to znalezienie elementu iframe i przełączenie się do niego
        WebElement searchedFrame = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(searchedFrame);


        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//h1")).getText());


    }
}
