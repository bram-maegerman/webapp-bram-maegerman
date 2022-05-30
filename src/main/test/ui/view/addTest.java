package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class addTest {

    WebDriver chromedriver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromedriver = new ChromeDriver();
        chromedriver.get("http://localhost:8080/project_war_exploded/Controller?command=voegToe");
    }

    public boolean elementInList(ArrayList<WebElement> list, String text){
        for(WebElement w: list){
            if(w.getText().equals(text)){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test_voeg_item_toe(){
        chromedriver.findElement(By.id("naam")).sendKeys("testNaam");
        chromedriver.findElement(By.id("prijs")).sendKeys("10");
        chromedriver.findElement(By.id("hvl")).sendKeys("1");
        chromedriver.findElement(By.id("submit")).click();
        assertEquals("Overzicht | Verlanglijst", chromedriver.getTitle());
        ArrayList<WebElement> list= (ArrayList<WebElement>) chromedriver.findElements(By.tagName("td"));
        assertTrue(elementInList(list, "testNaam"));
    }

    @Test
    public void test_voeg_item_toe_met_lege_naam(){
        chromedriver.findElement(By.id("naam")).sendKeys("  ");
        chromedriver.findElement(By.id("prijs")).sendKeys("10");
        chromedriver.findElement(By.id("hvl")).sendKeys("1");
        chromedriver.findElement(By.id("submit")).click();
        assertEquals("Voeg Toe | Verlanglijst", chromedriver.getTitle());
        ArrayList<WebElement> list= (ArrayList<WebElement>) chromedriver.findElements(By.tagName("li"));
        assertTrue(elementInList(list, "Naam mag niet enkel bestaan uit spaties."));
    }

    @Test
    public void test_voeg_item_toe_met_negatieve_prijs(){
        chromedriver.findElement(By.id("naam")).sendKeys("testNaam");
        chromedriver.findElement(By.id("prijs")).sendKeys("-2");
        chromedriver.findElement(By.id("hvl")).sendKeys("1");
        chromedriver.findElement(By.id("submit")).click();
        assertEquals("Voeg Toe | Verlanglijst", chromedriver.getTitle());
        ArrayList<WebElement> list= (ArrayList<WebElement>) chromedriver.findElements(By.tagName("li"));
        assertTrue(elementInList(list, "Prijs mag niet kleiner zijn dan 0."));
    }

    @Test
    public void test_voeg_item_toe_met_hoeveelheid_kleiner_dan_1(){
        chromedriver.findElement(By.id("naam")).sendKeys("testNaam");
        chromedriver.findElement(By.id("prijs")).sendKeys("10");
        chromedriver.findElement(By.id("hvl")).sendKeys("0");
        chromedriver.findElement(By.id("submit")).click();
        assertEquals("Voeg Toe | Verlanglijst", chromedriver.getTitle());
        ArrayList<WebElement> list= (ArrayList<WebElement>) chromedriver.findElements(By.tagName("li"));
        assertTrue(elementInList(list, "Hoeveelheid mag niet kleiner zijn dan 1."));
    }

    @After
    public void clean(){
        chromedriver.quit();
    }

}
