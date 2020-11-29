package view;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IncorecteDagZoeken {
    private WebDriver driver;
    String url = "http://localhost:8080/website_war_exploded/";


    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "D:\\ToegepasteInformatica\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test_dag_niet_goed_ingevuld_bij_zoeken(){
        driver.get(url + "zoeken.jsp");

        WebElement dagInput = driver.findElement(By.id("dag"));
        dagInput.clear();
        dagInput.sendKeys("");

        driver.findElement(By.id("Indienen")).click();

        assertEquals("Zoek Dag",driver.getTitle());
        ArrayList<WebElement> ps = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(ps,"[De dag is niet juist]"));
        assertEquals("",driver.findElement(By.id("dag")).getAttribute("value"));

    }

    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++){
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }
}
