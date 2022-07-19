import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.util.Set;

public class BasicActions2NewWindow {

    @Test
    public void BasicActions2 (){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        String basicWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//button[@id='newPage' and text()='Click me']")).click();
        Set<String> nextWindows = driver.getWindowHandles();
        for(String print : nextWindows){
            System.out.println(print);
        }

        for(String window : nextWindows){
            if(!window.equals(basicWindow)){
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")).click();
        WebElement searchWindow= driver.findElement(By.name("q"));
        searchWindow.sendKeys("Selenium");

        searchWindow.sendKeys(Keys.ENTER);

        driver.switchTo().window(basicWindow);



    }
}
