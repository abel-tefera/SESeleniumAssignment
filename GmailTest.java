package com.company;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class GmailTest {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException {
        int total = 0;
        PrintWriter writer = new PrintWriter("gmailUnread.txt", "UTF-8");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abel\\Desktop\\SEE\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession";
        driver.get(url);
        // Enter email here
        driver.findElement(By.id("identifierId")).sendKeys("EnterYourOwnAccount@gmail.com", Keys.ENTER);
        Thread.sleep(3000);
        // Enter password here
        driver.findElement(By.name("password")).sendKeys("YourPassword", Keys.ENTER);
        Thread.sleep(4000);

        for (int j = 0; j < 15; j++) {
            List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
            for (int i = 0; i < unreademeil.size(); i++) {
                if (!unreademeil.get(i).getText().equals("")) {
                    total += 1;
                    writer.println("Unread email from: " + unreademeil.get(i).getText());
                }
            }
            int a = 0;
            while (a == 0) {
                try {
                    System.out.println("Trying next page");
                    driver.findElement(By.xpath("//*[@id=':k1']")).click();
                    a = 1;
                } catch (Exception e) {
                    System.out.println("Failed clicking next page");
                }
            }
            Thread.sleep(4000);
        }

        writer.println("Total unread emails: " + total);
        writer.close();
        driver.close();

    }

}
