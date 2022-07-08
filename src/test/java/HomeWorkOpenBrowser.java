import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class HomeWorkOpenBrowser {


    @Test
    public void OpeningTests(){

        OpenBrowser("chrome","https://kursy.testeroprogramowania.pl/");

        OpenBrowser("chrome" , "https://film.org.pl/");

    }

    public static void OpenBrowser(String browser, String address){

        String path = "D:\\NAUKA AUTOMATÓW\\chromedriver_win32\\chromedriver.exe";
       System.setProperty("webdriver.chrome.driver" , path);

     //   String path1 = "D:\\NAUKA AUTOMATÓW\\geckodriver-v0.31.0-win64\\geckodriver.exe";
     //   System.setProperty("webdriver.gecko.driver", path1);


      //  String path2 = "D:\\NAUKA AUTOMATÓW\\IEDriverServer_x64_4.0.0\\IEDriverServer.exe";
     //   System.setProperty("webdriver.ie.driver",path2);
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.pl/");


            if (browser.equals("chrome")){
                WebDriver driver = new ChromeDriver();
                driver.get(address);
            } else if ( browser.equals("firefox")){
                WebDriver driver = new FirefoxDriver();
                driver.get(address);
            } else if (browser.equals("internetexplorer")){
                WebDriver driver = new InternetExplorerDriver();
                driver.get(address);
            } else {
                throw new InvalidArgumentException("nieprawidłowa przeglądarka podana");
            }


    }

}
