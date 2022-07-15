import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

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
        for( WebElement test1 : cars){
            System.out.println(test1.getText());
        }

        comparision(value,cars);


    }

    public void comparision(String value1, List values2) {

      /*  for(int i = 0; i< List.of(values2).size(); i++){
            if(value1.equals()){

            }


            */
        for (WebElement option: values2) {
            System.out.println(option.getText());
            }
        }


       // return "Nie znaleziono elementu " + value1 + " na liście";


}
