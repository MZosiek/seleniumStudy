import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class ReminderOpenCloseRescale {

    @Test
    public void Open(){

       ChooseBrowser("firefox").get("https://film.org.pl/");

    }

    @Test
    public void Rescale() throws InterruptedException {
        WebDriver driver = ChooseBrowser("chrome");
        driver.get("https://film.org.pl/");
        Dimension dimension = new Dimension(1080,1920);
        driver.manage().window().setSize(dimension);
        driver.manage().window().maximize();
        //driver.wait(500);
       // driver.quit();
    }

    public WebDriver ChooseBrowser(String browser){

        switch (browser){
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return  new FirefoxDriver();
            case "IE":
                return  new InternetExplorerDriver();

        }
        return null;
    }
}
