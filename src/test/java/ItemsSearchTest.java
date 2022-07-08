import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class ItemsSearchTest {

    @Test
    public void SearchTest() {
        WebDriver driver = new ChromeDriver();

        ChromeOptions option = new ChromeOptions();
        option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");


        // szukanie za pomocą ID
        WebElement klik = driver.findElement(By.id("clickOnMe"));
     //   klik.click();
        //można też wpisać to inaczej
        /*
        By button = By.id("clickOnMe");
        driver.findElement(button);
        */

        // szukanie za pomocą name
        WebElement firstName = driver.findElement(By.name("fname"));
        // można też wpisać inaczej:
        /*
        By typeSpace  = By.name("fname");
        driver.findElement(typeSpace);
        */

        firstName.sendKeys("tekst");
        firstName.sendKeys(Keys.ENTER);


        // szukanie za pomocą nazwy klasy
        WebElement hiddenParagraph = driver.findElement(By.className("topSecret"));
        //można też inaczej:
        /*
        By hiddenPara = By.className("topSecret");
        driver.findElement(hiddenPara);
        */

        WebElement inputLocator = driver.findElement(By.tagName("input"));
        inputLocator.sendKeys("pierwszy input");

        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println(inputs.size());

        for (int i = 0; i<inputs.size();i++){
            System.out.println(inputs.get(i).getTagName());
        }

        // znajdowanie selektora po tekście linku
        WebElement linkText = driver.findElement(By.linkText("Visit W3Schools.com!")); //<- trzeba tu podać cały tekst linka

        // znajdowanie selektora po kawałku tekstu linka
        WebElement linktPartialTekst = driver.findElement(By.partialLinkText("Visit")); // <- wystarczy kawałek



    }
}
