import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FileUploadAndScreenshot {

    @Test
    public void uploadFileTest() throws IOException {



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        WebElement upload = driver.findElement(By.xpath("//input[@id='myFile']"));
        upload.sendKeys("C:\\Users\\mzofinski\\Downloads\\karta-mieszkania-12A.pdf");

        // randomowa nazwa pliku screenshot

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();



        String fileName = "screenshot" + dtf.format(now)+ ".png";


        // screenshot

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File newFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(newFile, new File("src/test/resources/" + fileName));
    }
}
