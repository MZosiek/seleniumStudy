import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomeWorkXpathFinding {
    @Test
    public  void CanyonXpath(){

        WebDriverManager.chromedriver().setup();

        Duration duration = Duration.ofSeconds(15);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.canyon.com/pl-pl/");
        driver.manage().window().maximize();

        WebElement cookieButton = driver.findElement(By.xpath("//div[@class ='cookiesModal__buttonWrapper']//button"));
        cookieButton.click();

        WebElement mountainBikes = driver.findElement(By.xpath("//div[@class='headerNav__list headerNav__list--level-1 js-navigationList js-navigationListFirstLevel']/div[3]/child::a//span[@class='headerNav__titleTextInner']"));
        mountainBikes.click();

        new WebDriverWait(driver,duration).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Canyon Trail Bikes']")));

        WebElement trailBikes = driver.findElement(By.xpath("//a[@class='button button--primary button--link contentHeroType2__button' and @title='Canyon Trail Bikes']"));
        trailBikes.click();

        new WebDriverWait(driver,duration).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='carousel__buttonWrapper carousel__buttonWrapper--next']/button[1]")));

        WebElement nextButton = driver.findElement(By.xpath("//div[@class='carousel__buttonWrapper carousel__buttonWrapper--next']/button[1]"));
        nextButton.click();

        new WebDriverWait(driver,duration).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/descendant::a[@href='/pl-pl/rowery-gorskie/trail-bikes/neuron/']/../../descendant::div[@class='paragraph carouselCaptions__links']/a[contains(text(),'Neuron AL')]")));

        WebElement neuronBikes = driver.findElement(By.xpath("//li/descendant::a[@href='/pl-pl/rowery-gorskie/trail-bikes/neuron/']/../../descendant::div[@class='paragraph carouselCaptions__links']/a[contains(text(),'Neuron AL')]"));
        neuronBikes.click();

        WebElement neuron6 = driver.findElement(By.xpath("//ul/li/descendant::div[@class='productTile__productName' and contains(text(),'Neuron 6 ')]"));

        Assert.assertTrue(neuron6.isDisplayed());



    }
}
