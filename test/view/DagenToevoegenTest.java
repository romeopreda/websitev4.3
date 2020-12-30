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

public class DagenToevoegenTest {
    private WebDriver driver;
    String url = "http://localhost:8080/website_war_exploded/";


    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "D:\\ToegepasteInformatica\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test_dag_groepspier_aantaluur_goed_ingevuld_bij_tovoegen_van_een_dag_gaan_naar_overzicht(){
        driver.get(url + "DagenToevoegen.jsp");

        WebElement dagInput = driver.findElement(By.id("dag"));
        dagInput.clear();
        dagInput.sendKeys("Maandag");

        WebElement groepspierInput = driver.findElement(By.id("lGroepSpier"));
        groepspierInput.clear();
        groepspierInput.sendKeys("Rug");

        WebElement AantalUurInput = driver.findElement(By.id("aantalUur"));
        AantalUurInput.clear();
        AantalUurInput.sendKeys("1");

        driver.findElement(By.id("Verstuur")).click();

        assertEquals("Overzicht", driver.getTitle());
        ArrayList<WebElement> ths = (ArrayList<WebElement>) driver.findElements(By.tagName("th"));
        assertTrue(containsWebElementsWithText(ths,"Maandag"));

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
