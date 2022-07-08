import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.time.LocalDate;

public class FirstTest {

    @Test
    public void FirstTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.pl/");

        Duration time = Duration.ofSeconds(3);

        new WebDriverWait(driver,time);

     //   new WebDriverWait(driver, time).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("L2AGLb")));

     //   driver.switchTo().frame(0);

        WebElement acceptButton = driver.findElement(By.id("L2AGLb"));
        acceptButton.click();

        driver.switchTo().defaultContent();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//a[@href='https://www.selenium.dev/']"));

        Assert.assertTrue(result.isDisplayed());






    }

  //  public  int compareDurations(Duration d) {
  //      int myMinutes = 1;
  //      Duration durationInMinutes = Duration.ofMinutes(myMinutes);
  //      return d.compareTo(durationInMinutes);
  //  }



}
