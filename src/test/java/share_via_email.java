import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by macbook on 2/24/17.
 */
public class share_via_email {

    @Test
    public void share_email() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
 //       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


        DemoPage Advocate=new DemoPage(driver, wait);

        Advocate.getURL();
        Advocate.ClickOnFW();
        Advocate.TypeAdvocateName();
        Advocate.TypeAdvocateEmail();
        Advocate.ClickOnLoginButton();

//share page  + (int) Math.ceil(Math.random() * 1000) + "
            driver.findElement(By.cssSelector("a.button.is-block.js-email-form-toggle.ac-share-via-email")).click();

            driver.findElement(By.id("email_recipient_list")).sendKeys("fr"+ (int) Math.ceil(Math.random() * 1000) + "@talkable.com");
//sleep      Thread.sleep(5000);
            driver.findElement(By.cssSelector("input.button.js-email-share-submit")).click();
// /7poBepKa

            Assert.assertEquals("Sent successfully", driver.findElement(By.cssSelector("div.js-response-notice.validation.is-success")).getText());

            driver.close();
            driver.quit();
        }
    }

