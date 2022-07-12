import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CssFinding {

    @Test
    public void CssTests(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        Duration duration = Duration.ofSeconds(15);

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.manage().window().maximize();

        WebElement CssName = driver.findElement(By.cssSelector("#smileImage"));

        WebElement CssClass = driver.findElement(By.cssSelector(".topSecret"));

        WebElement CssTag = driver.findElement(By.cssSelector("button"));

        WebElement CssField = driver.findElement(By.cssSelector("[type='password']"));

        WebElement CssWithDirectParent = driver.findElement(By.cssSelector("tbody > tr"));    // symbol ">" oznacza bezpośredniego childa od parenta , bez tego symbolu pokazane zostaną wszystkie childy

        WebElement CssAfterSomething = driver.findElement(By.cssSelector("label + form")); /* symbol '+' pookazuje pierwszy obiekt spełniający typ po danym typie */

        WebElement AllCssAfterSomething = driver.findElement(By.cssSelector("label ~ form")); /* symbol '~' pokazuje wszystkie obiekty danego typu po danym typoie */

        WebElement CssFieldSearch = driver.findElement(By.cssSelector("[value = 'male']")); /* wyszukuje po wartości dla danego selektora*/

        WebElement CssFieldNarrowed = driver.findElement(By.cssSelector("input[value = 'female']")); /* wyszukuje po wartości dla danego selektora ZAWĘŻONA do typu selektora*/

        WebElement CssFieldLikeName = driver.findElement(By.cssSelector("[value*='ale']")); /*wyszukuje po kawałku nazwy*/
        WebElement CssFieldLikeNameStarte = driver.findElement(By.cssSelector("[value^='fe']")); /*wyszukuje po początku nazwy*/
        WebElement CssieldLikeNameEnd = driver.findElement(By.cssSelector("[value$='le']")); /*wyszkuje po końcu nazwy*/

        WebElement CssFirstChild = driver.findElement(By.cssSelector("li:first-child"));
        WebElement CssLastChidl = driver.findElement(By.cssSelector("li:last-child"));
        WebElement NumberedChild = driver.findElement(By.cssSelector("li:nth-child(2)"));


        // new WebDriverWait(driver,duration);

     //    driver.manage().timeouts().implicitlyWait(duration);

    //    driver.close();

    }
}
