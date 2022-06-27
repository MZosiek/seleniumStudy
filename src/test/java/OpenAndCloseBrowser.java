import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenAndCloseBrowser {


    @Test

    public  void OpenCloseGoogle() {
        WebDriver driver = OpenBrowser("chrome");
        driver.get("https://kursy.testeroprogramowania.pl/");
        driver.close();  // < ta metoda zamyka tylko okno w ramach testu
        driver.quit(); // < ta metoda zamyka inne otwierające się okna  - zamyka wszystko w teście

    }





    public WebDriver OpenBrowser(String browser){
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "ie" :
                return new InternetExplorerDriver();

            default: throw new InvalidArgumentException("Nieprawidłowa przeglądarka");

        }



    }
}
