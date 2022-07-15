import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActions {

    @Test
    public void Actions(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

      /*  ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);*/

        //click
        WebElement coursePage = driver.findElement(By.xpath("//a[text()='Podstawowa strona testowa']"));
        coursePage.click();
        //inna forma zapisu
        driver.findElement(By.id("clickOnMe")).click();
        driver.switchTo().alert().accept();

        //wprowadzanie danych do pola oraz czyszczenie zawartości
        WebElement textPlace = driver.findElement(By.xpath("//input[@id='fname']"));
        textPlace.sendKeys("Marcin");

        WebElement clearAndText = driver.findElement(By.xpath("//input[@name='username']"));
        clearAndText.clear();  //<czyszczenie
        clearAndText.sendKeys("Mój Text");

        //wprowadzanie przycisków z klawiatury
        clearAndText.sendKeys(Keys.ENTER);

        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        //zaznaczanie checkboxa
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        //zaznaczanie radio buttona
        driver.findElement(By.xpath("//form/input[@type='radio' and @value='female']")).click();
        driver.findElement(By.xpath("//form/input[@type='radio' and @value='male']")).click();

        // wybieranie wartości z picklist
        WebElement picklist = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(picklist);
        cars.selectByVisibleText("Audi"); // < wybór po wartości
        cars.selectByIndex(1);  // < wybór po kolejności
        cars.selectByValue("saab"); //< wybór po value pola

        List<WebElement> carlist = cars.getOptions();

        for (WebElement option : carlist ) {
            System.out.println(option.getText());
        }
    }
}
