import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkSelectionValues {

    @Test
    public void selectorTest(){



       // Scanner scanner = new Scanner(System.in);
        String value = "Audi";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement selector = driver.findElement(By.xpath("//select"));
        Select carsValues = new Select(selector);

        List<WebElement> cars = carsValues.getOptions();
        List<String> carsOptions = new ArrayList<>();

        for (WebElement test2: cars){
            carsOptions.add(test2.getText());
        }

        /*for( WebElement test1 : cars){
            System.out.println(test1.getText());
        }

         */

        System.out.println( comparision(value,carsOptions));

        driver.quit();


    }

    public String comparision(String value1, List values2) {

        for (Object option : values2){
            System.out.println(option);
        }


            if (values2.contains(value1)){
                return "Element " + value1 + " zawiera się w liście" ;
            }else {
                return "Element " + value1 + " nie zawiera się w liście";
            }
        }





}
