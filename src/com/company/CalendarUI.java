package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarUI {
    public void handleCalendarUi() {
        //Set System Property to Chrom .exe file to invoke the browser below
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        //Invoke the test in Chrome Driver = creating an object for my driver
        WebDriver driver = new ChromeDriver();

        //Implicit Wait Machine - When your code/test executes faster than your browser, test works with elements that are not there.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.path2usa.com/travel-companions");

        driver.findElement(By.xpath("//input[@id='travel_from']")).click();

        //! - negation in selenium
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch'] ")).getText().contains("April"))
        {
            //Returns a boolean issue
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }//while loop will keep executing until becomes false

       List <WebElement> dates = driver.findElements(By.className("day"));
       //Grab common attribute put into list and iterate
        int count = driver.findElements(By.className("day")).size();

       //For loop travel to each and every idem in the list
        for(int i = 0;i < count; i++){

            String text = driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase("23")){

                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }
    }
}
