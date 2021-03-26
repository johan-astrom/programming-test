package com.johanastrom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Johan Åström 26/3 2021
 */

public class WebUtilities {

    public void printWebLinks(String url){
        if (!url.startsWith("http")){
            url = "http://" + url;
        }

        WebDriver driver = new ChromeDriver();
        try {
            driver.get(url);
        } catch (WebDriverException e){
            System.out.println("Invalid URL: " + e.getMessage());
            return;
        }
        List<WebElement> links = driver.findElements(By.tagName("a"));

        int linkNo = 1;
        System.out.println("\nLinks found in " + url + ":\n");
        for (WebElement link : links){
            System.out.println(linkNo + ": " + link.getAttribute("href"));
            linkNo++;
        }

    }

}
