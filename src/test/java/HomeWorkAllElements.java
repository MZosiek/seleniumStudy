import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class HomeWorkAllElements {

    @Test
    public void AllElementTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.xpath("//h1"));
        actions.moveToElement(heading);

        WebElement firstButton = driver.findElement(By.xpath("//button[@id='clickOnMe']"));
        firstButton.click();
        driver.switchTo().alert().accept();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='fname']"));
        firstName.sendKeys("Marcin");
        firstName.sendKeys(Keys.ENTER);

        WebElement link = driver.findElement(By.xpath("//a[text()='IamWeirdLink']"));
        link.click();

        // cofa się o 1 stronę w historii
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.history.go(-1)");

        //tabela
        String tableValue = driver.findElement(By.xpath("//table//tr/th[@class='tableHeader']")).getText();
        System.out.println(tableValue);
        Assert.assertTrue(tableValue.equals("Month"),"First value as expected : Month");

        String tableValue2 = driver.findElement(By.xpath("(//table//tr/th[@class='tableHeader'])[2]")).getText();
        System.out.println(tableValue2);
        Assert.assertTrue(tableValue2.equals("Savings"),"First value as expected : Savings");

        String tableValue3 = driver.findElement(By.xpath("//table//tr/td")).getText();
        System.out.println(tableValue3);
        Assert.assertTrue(tableValue3.equals("January"),"First value as expected : January");

        String tableValue4 = driver.findElement(By.xpath("(//table//tr/td)[2]")).getText();
        System.out.println(tableValue4);
        Assert.assertTrue(tableValue4.equals("$100"),"First value as expected : $100");


        // lista rozwijana
        WebElement selector = driver.findElement(By.xpath("//select"));
        Select carOptions = new Select(selector);
        List<WebElement> cars = carOptions.getOptions();
        ArrayList<String> expectedOptions = new ArrayList<>(Arrays.asList("Volvo","Saab","Mercedes","Audi"));
        ArrayList<String> carsValues = new ArrayList<>();

        for (WebElement car: cars){
            carsValues.add(car.getText());
        }

       Assert.assertTrue(carsValues.equals(expectedOptions));

        //checkbox
        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(),'Potwierdzam')]"));
        checkbox.click();

        //radio
        WebElement radioButton = driver.findElement(By.xpath("//form/input[@type= 'radio' and @value = 'male']"));
        radioButton.click();
        WebElement radioButton2 = driver.findElement(By.xpath("//form/input[@type= 'radio' and @value = 'female']"));
        radioButton2.click();
        WebElement radioButton3 = driver.findElement(By.xpath("//form/input[@type= 'radio' and @value = 'other']"));
        radioButton3.click();

        //submit
        WebElement submitName = driver.findElement(By.xpath("//form/input[@type='text' and @name='username']"));
        submitName.clear();
        submitName.sendKeys("Marcin");
        WebElement submitSurname = driver.findElement(By.xpath("//input[@type='password' and @name='password']"));
        submitSurname.clear();
        submitSurname.sendKeys("Test");
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        submitButton.click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        //okna
        driver.findElement(By.xpath("//button[@id='newPage' and text()='Click me']")).click();
        String basicWindow = driver.getWindowHandle();
        Set<String> windows= driver.getWindowHandles();
       /* for(String handle : windows){
            System.out.println(handle);
        }*/
        for( String test : windows){
            if(!test.equals(basicWindow)){
                driver.switchTo().window(test);
            }
        }
        driver.close();
        driver.switchTo().window(basicWindow);

        WebElement hiddenElement = driver.findElement(By.xpath("//p[@class='topSecret']"));
        String texthidden= hiddenElement.getAttribute("textContent");
      //  System.out.println(texthidden);
        Assert.assertTrue(texthidden.equals("This paragraph should be hidden."));

        //lista

        List<WebElement> allValues = driver.findElements(By.xpath("//div[@id='container']/ul/li"));
        for (WebElement test : allValues){
            System.out.println(test.getText());
        }

        driver.quit();























    }
}
