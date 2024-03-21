package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static WebDriver browser;
    public static void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");

        browser = new ChromeDriver(chromeOptions);
//        Testuojamas tinklapis URL
        browser.get("http://localhost:8080/skaiciuotuvas");
    }
    public static void closeBrowser() {
        browser.quit();
    }
    public static void signUp(String username, String password) {
        browser.findElement(By.linkText("Sukurti naują paskyrą")).click();
        browser.findElement(By.id("username")).sendKeys(username);;
        browser.findElement(By.id("password")).sendKeys(password);;
        browser.findElement(By.id("passwordConfirm")).sendKeys(password);

        browser.findElement(By.className("btn")).click();
    }
    public static void logIn(String username, String password) {
        browser.findElement(By.name("username")).sendKeys(username);
        browser.findElement(By.name("password")).sendKeys(password);
        browser.findElement(By.className("btn")).click();
    }
    public static void main(String[] args) {
        setUp();
        signUp("Saulius1", "12345");
        logIn("Saulius1", "12345");

        closeBrowser();

        System.out.println("..");
    }
}