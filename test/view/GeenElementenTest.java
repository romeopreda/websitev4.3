package view;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeenElementenTest {
    private WebDriver driver;
    String url = "http://localhost:8080/website_war_exploded/";


    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "D:\\ToegepasteInformatica\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test_form_is_zichtbaar_wanneer_geen_dag_groepspier_aantluur_ingevuld_zijn(){
        driver.get(url + "DagenToevoegen.jsp");
        WebElement dagInput = driver.findElement(By.id("dag"));
        dagInput.clear();
        dagInput.sendKeys("");

        WebElement groepspierInput = driver.findElement(By.id("lGroepSpier"));
        groepspierInput.clear();
        groepspierInput.sendKeys("");

        WebElement AantalUurInput = driver.findElement(By.id("aantalUur"));
        AantalUurInput.clear();
        AantalUurInput.sendKeys("");

        driver.findElement(By.id("Verstuur")).click();

        assertEquals("DagenToevoegen", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "geen valide dag"));
        assertTrue(containsWebElementsWithText(lis,"geen valide groepspier"));
        assertTrue(containsWebElementsWithText(lis,"vul een geldige nummer in (boven 0)"));
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
