
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenGogle {

    @Test
    public void OpenGooglePAge(){

        String path = "D:\\NAUKA AUTOMATÓW\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver" , path);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.pl/");
    }

    @Test
    public void OpenGoogleFirefox(){
        String path = "D:\\NAUKA AUTOMATÓW\\geckodriver-v0.31.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);

        WebDriver driverF = new FirefoxDriver();
        driverF.get("https://www.google.pl/");
    }
}
