import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathFinding {

    @Test
    public void Xpaths(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement pushMeButton = driver.findElement(By.xpath("/html/body/button[@id='clickOnMe']")); //możesz skrócić xpath do "//button[@id=clickOnMe']"

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='fname']"));

        WebElement hiddenClass = driver.findElement(By.xpath("//p[@class='topSecret']"));

        WebElement link = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));

        WebElement linkContains = driver.findElement(By.xpath("//a[contains(text(),'Visit')]"));

        WebElement all = driver.findElement(By.xpath("//*")); //< gwiazdka oznacza wszystko

        WebElement elementNumber = driver.findElement(By.xpath("(//li)[2]")); // < znajduje któryś element z kolei ( kolejność w kodzie strony )

        WebElement elementLastNumber = driver.findElement(By.xpath("(//div)[last()]"));  // < znajduje ostatni element z kolei

        WebElement elementWithTag = driver.findElement(By.xpath("//*[@name]"));  // < znajduje wszystkie elementy z atrybutem name

        WebElement elementWithoutTag = driver.findElement(By.xpath("//*[@name!='fname']"));  // < elementy nie zawierające danego tekstu

        WebElement elementContains = driver.findElement(By.xpath("//*[contains(@name,'f')]"));  // < znajduje elementy gdzie name zawiera 'f'

        WebElement elementStartsWith = driver.findElement(By.xpath("//*[starts-with(@name,'fn')]")); // < znajduje elementy które zaczynają się na 'fn'

        /* ends-with działa na xpath 2.0 - wiec jest szansa że to nie bedzie działać - ale jak chcesz znaleźć element kończący się na coś to mozna przez substring*/

        WebElement elementEndsWith = driver.findElement(By.xpath("//*[substring(@name, string-length(@name)-string-length('name')+1)='name']"));
    }
}
