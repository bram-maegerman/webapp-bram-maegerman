package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class zoekTest {

    WebDriver chromedriver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromedriver = new ChromeDriver();
        chromedriver.get("http://localhost:8080/project_war_exploded/Controller?command=zoek");
    }

    @Test
    public void test_zoek_pagina(){
        chromedriver.get("http://localhost:8080/project_war_exploded/Controller?command=index");
        chromedriver.findElement(By.linkText("Zoek")).click();
        assertEquals("Zoek | Verlanglijst", chromedriver.getTitle());
    }

    @Test
    public void test_item_uit_lijst_zoeken_geeft_gevonden_pagina(){
        chromedriver.findElement(By.id("naam")).sendKeys("Bijbel");
        chromedriver.findElement(By.id("submit")).click();
        assertEquals("Gevonden", chromedriver.getTitle());
    }

    @Test
    public void test_item_uit_lijst_zoeken_geeft_niet_gevonden_pagina(){
        chromedriver.findElement(By.id("naam")).sendKeys("blabla");
        chromedriver.findElement(By.id("submit")).click();
        assertEquals("Niet gevonden", chromedriver.getTitle());
    }

    @After
    public void clean(){
        chromedriver.quit();
    }

}
