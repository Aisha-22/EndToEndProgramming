package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Scope {
    public static void getScopeLinksCount() throws InterruptedException {
        //Set System Property to Chrom .exe file to invoke the browser below
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        //Invoke the test in Chrome Driver = creating an object for my driver
        WebDriver driver = new ChromeDriver();

        //Implicit Wait Machine - When your code/test executes faster than your browser, test works with elements that are not there.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);

        //1. Give the count of the links on the page
        //2. Counter Footer Section - evey link will have a tag called 'a' - anchor

        //Get the count for links
        System.out.println(driver.findElements(By.tagName("a")).size());
        //Get the count of links present in the Footer Section
        //Global driver object scope is on the entire page - > so you need to minimize it.
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));//Concept of Limiting webdriver scope
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3. Links count for only first coulomb - In the footer section there are 4 coloumns
        //Creating another driver inside the main section
        WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumndriver.findElements(By.tagName("a")).size());

        //4. Click on each link from the coloumn - check if the pages are opening (By limiting you from hard code, repeating code over)
        for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {
            //There is a concept called Keys in Selenium - make this a variable string
            String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER); //This combination lets you know to click on any link so that it opens another tab
            coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);//This makes sure that this concept in clicking on ever link - keyboard event
            Thread.sleep(5000l);

        }//This For loop opens for all the tabes
            //Using Window Handles - set as a data type
            Set<String> abc = driver.getWindowHandles(); //Iterate to each link to get the title
            //Iterator - move from one tab to another tab (move to each and every window)
            Iterator<String> it = abc.iterator();

            //hasNext - if there are any windows present / not
            while (it.hasNext()){

                //iterator control will move to it base
                driver.switchTo().window(it.next());//Need to switch/move to index
                System.out.println(driver.getTitle());
            } //The While loop iterates in every tab to get the title

    }
}
