import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class share_by_link {
    @Test
    public void share_link() throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            WebDriver driver2 = new ChromeDriver();


            driver.manage().window().maximize();
            driver2.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            driver.get("https://void-sergey-hutornoy.myshopify.com/");
//click fw

            driver.switchTo().frame(0);

            driver.findElement(By.cssSelector("a.campaign-trigger-content.js-trigger-offer")).click();
            driver.switchTo().parentFrame();
//signup page
            driver.switchTo().frame(1);

            driver.findElement(By.id("affiliate_member_first_name")).sendKeys("Automation");
            driver.findElement(By.name("affiliate_member[email]")).sendKeys("ad" + (int) Math.ceil(Math.random() * 1000) + "@talkable.com");

            driver.findElement(By.name("commit")).click();

//share page

//sleep      Thread.sleep(5000);


//click link
            driver.findElement(By.cssSelector("a.button.is-block.is-link.js-open-link-popup.ac-share-via-link")).click();

//Claim page
            driver2.get(driver.findElement(By.cssSelector("div.js-share-by-link.js-copy.share-link")).getAttribute("data-clipboard-text"));

            driver2.findElement(By.cssSelector("a.button.is-block.is-large.ac-proceed-link")).click();
            Thread.sleep(1000);

            driver.close();
            driver.quit();
            driver2.close();
            driver2.quit();

        }
    }


