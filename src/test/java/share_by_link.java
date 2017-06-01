import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class share_by_link {
    @Test
    public void share_link(){

            WebDriver driver = new ChromeDriver();
            WebDriver driver2 = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 20);
            int i = 0;
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            DemoPage Advocate=new DemoPage(driver, wait);

            Advocate.getURL();
            Advocate.ClickOnFW();
            Advocate.TypeAdvocateName();
            Advocate.TypeAdvocateEmail();
            Advocate.ClickOnLoginButton();

//share page

//click link
            driver.findElement(By.cssSelector("a.button.is-block.is-link.js-open-link-popup.ac-share-via-link")).click();

//Claim page
            driver2.get(driver.findElement(By.cssSelector("div.js-share-by-link.js-copy.share-link")).getAttribute("data-clipboard-text"));

            driver2.findElement(By.cssSelector("a.button.is-block.is-large.ac-proceed-link")).click();
//referral
            driver2.get("http://learn.talkable.com/QA-Sergey/bart/pp.html");


//check iframe on page
// ---------------------------------------------------------------------------------
//           System.out.println("iframes: " + i + " iframe name " + FrameName);

/*
            if (FrameName.contains("talkable") == true) {
                    System.out.println("Pass");
            } else {
                    System.out.println("Fail");
            }
            ---------------------------------------------------------------------------------
**/
            String FrameName = driver2.findElements(By.tagName("iframe")).get(i).getAttribute("name");
            i++;
//            System.out.println("iframes: " + i + " iframe name " + FrameName);

                    try{
                            Assert.assertTrue(FrameName.contains("talkble"));
                            System.out.println("PASS");
                    }catch(AssertionError e){
                            System.out.println("FAIL");


                    }


            driver.close();
            driver.quit();
            driver2.close();
            driver2.quit();

        }
    }


