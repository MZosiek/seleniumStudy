
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;

public class OpenGogle {

    @Test
    public void OpenGooglePAge(){

        String path = "C:\\Users\\mzofinski\\Documents\\Nauka Testowania\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver" , path);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.pl/");
    }

    @Test
    public void OpenGoogleFirefox(){

        System.setProperty("webdriver.gecko.driver","C:\\Users\\mzofinski\\Documents\\Nauka Testowania\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.co.in/");

    }

    @Test
    public void OpenGoogleIe(){

        String path = "C:\\Users\\mzofinski\\Documents\\Nauka Testowania\\IEDriverServer_x64_4.2.0\\IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver",path);
        Dimension dimension = new Dimension(1920,1080);

        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.pl/");

        WebDriver driver = new InternetExplorerDriver(options);
        driver.manage().window().setSize(dimension);

    }
}
