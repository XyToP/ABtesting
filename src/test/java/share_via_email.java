import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by macbook on 2/24/17.
 */
public class share_via_email {

    @Test
    public void share_email() throws InterruptedException {
            WebDriver driver = new ChromeDriver();


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


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
            driver.findElement(By.cssSelector("a.button.is-block.js-email-form-toggle.ac-share-via-email")).click();
            driver.findElement(By.id("email_recipient_list")).sendKeys("fr+" + (int) Math.ceil(Math.random() * 1000) + "@talkable.com");
//sleep      Thread.sleep(5000);
            driver.findElement(By.cssSelector("input.button.js-email-share-submit")).click();

//click link
            driver.findElement(By.cssSelector("a.button.is-block.is-link.js-open-link-popup.ac-share-via-link")).click();

            driver.close();
            driver.quit();
        }
    }

