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

public class linkTest {

    WebDriver chromedriver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromedriver = new ChromeDriver();
        chromedriver.get("http://localhost:8080/project_war_exploded/Controller?command=voegToe");
    }

    @Test
    public void test_index_pagina(){
        chromedriver.get("http://localhost:8080/project_war_exploded/Controller?command=index");
        chromedriver.findElement(By.linkText("Home")).click();
        assertEquals("Home | Verlanglijst", chromedriver.getTitle());
    }

    @Test
    public void test_voegToe_pagina(){
        chromedriver.get("http://localhost:8080/project_war_exploded/Controller?command=index");
        chromedriver.findElement(By.linkText("Toevoegen")).click();
        assertEquals("Voeg Toe | Verlanglijst", chromedriver.getTitle());
    }

    @Test
    public void test_zoek_pagina(){
        chromedriver.get("http://localhost:8080/project_war_exploded/Controller?command=index");
        chromedriver.findElement(By.linkText("Zoek")).click();
        assertEquals("Zoek | Verlanglijst", chromedriver.getTitle());
    }

    @Test
    public void test_overzicht_pagina(){
        chromedriver.get("http://localhost:8080/project_war_exploded/Controller?command=index");
        chromedriver.findElement(By.linkText("0verzicht")).click();
        assertEquals("Overzicht | Verlanglijst", chromedriver.getTitle());
    }

    @After
    public void clean(){
        chromedriver.quit();
    }

}
