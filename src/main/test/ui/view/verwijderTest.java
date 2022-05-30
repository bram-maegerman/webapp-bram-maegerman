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

public class verwijderTest {

    WebDriver chromedriver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromedriver = new ChromeDriver();
        chromedriver.get("http://localhost:8080/project_war_exploded/Controller?command=overzicht");
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
    public void test_verwijder_pagina(){
        chromedriver.findElement(By.id("verwijder")).click();
        assertEquals("Verwijder Bevestiging", chromedriver.getTitle());
    }

    @Test
    public void test_item_wordt_verwijdert_uit_lijst(){
        chromedriver.findElement(By.id("verwijder")).click();
        chromedriver.findElement(By.id("ja")).click();
        ArrayList<WebElement> list= (ArrayList<WebElement>) chromedriver.findElements(By.tagName("td"));
        assertFalse(elementInList(list, "Intel Processor"));
    }

    @After
    public void clean(){
        chromedriver.quit();
    }

}
