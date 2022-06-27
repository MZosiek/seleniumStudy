import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserOptionsHeadless {


    @Test
    public void BrowserOptions(){




        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);  // <- nie bedzie włączał przeglądarki UI przy testach
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); // <- zaakceptuje okienka jeżeli jakieś się pojawią w czsaie testów

        WebDriver driver = new ChromeDriver(options);

    }
}
