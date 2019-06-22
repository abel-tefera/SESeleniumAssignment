package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class PortalTest {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("GradeReport.txt", "UTF-8");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abel\\Desktop\\SEE\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String appUrl = "http://portal.aait.edu.et";

        driver.get(appUrl);

        WebElement atr = driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));

        atr.sendKeys("ATR/0209/09");
        password.sendKeys("2080");

        driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/nav/div[3]/ul/li[4]/a")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"m2\"]/ul/li[1]/a")).click();
        Thread.sleep(1000);
        WebElement table = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/table"));

        writer.println(table.getText());
        Thread.sleep(10000);
        writer.close();
        driver.quit();
    }
}
