import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomeWorkKmf {

    @Test
    public void HomeWorkTest(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("https://www.canyon.com/pl-pl/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement acceptButton = driver.findElement(By.cssSelector("#js-data-privacy-save-button"));
        acceptButton.click();

        WebElement navigation = driver.findElement(By.cssSelector("#js-navigationDrawer > div.headerNav__listWrapper.headerNav__listWrapper--level-1 > div > div:nth-child(3) > a > span.headerNav__titleText.headerNav__titleText--level-1 > span"));
        navigation.click();

        WebElement navigation2 = driver.findElement(By.cssSelector("#app > main > header > div > div.sectionHeader__body > ul > li > a"));
        navigation2.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement showMoreBikes = driver.findElement(By.cssSelector("#section-product-grid > div > div.productGrid__footer.grid-footer.js-grid-footer > div > button"));
        showMoreBikes.click();



      //  WebElement result = driver.findElement(By.cssSelector("#section-product-grid > div > div.productGrid__wrapper.xlt-searchresults > ul > li:nth-child(48) > div > div.productTile__productSummary > div.productTile__productSummaryLeft > div.productTile__productName"));

        WebElement result = driver.findElement(By.cssSelector("#app > main > div:nth-child(6) > div > div > div:nth-child(1) > div > div > div > div.contentHeroType2__header > h2"));

        Assert.assertTrue(result.isDisplayed());

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //driver.close();



    }
}
