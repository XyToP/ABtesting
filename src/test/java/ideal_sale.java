import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ideal_sale {
        @Test
        public void purchase() throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            WebDriver driver2 = new ChromeDriver();


            driver.manage().window().maximize();
            driver2.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            driver2.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            driver2.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
            driver2.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);


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
//purchase
            driver2.findElement(By.className("grid-link__title")).click();
            driver2.findElement(By.id("AddToCartText")).click();
//            Thread.sleep(5000);
            driver2.findElement(By.cssSelector("button#AddToCart.btn.btn--flipped")).click();
            driver2.findElement(By.cssSelector("input.btn.checkout")).click();
            driver2.findElement(By.id("checkout_email")).sendKeys("pp" + (int) Math.ceil(Math.random() * 1000) + "@talkable.com");

            driver2.findElement(By.id("checkout_shipping_address_last_name")).sendKeys("pp" + (int) Math.ceil(Math.random() * 1000) + "generated");
            driver2.findElement(By.id("checkout_shipping_address_address1")).sendKeys("pp" + (int) Math.ceil(Math.random() * 1000) + "generated");
            driver2.findElement(By.id("checkout_shipping_address_city")).sendKeys("pp" + (int) Math.ceil(Math.random() * 1000) + "generated");
            driver2.findElement(By.id("checkout_shipping_address_zip")).sendKeys("111"+(int) Math.ceil(Math.random() * 1000));

            driver2.findElement(By.cssSelector("button.step__footer__continue-btn.btn")).click();

            driver2.findElement(By.cssSelector("button.step__footer__continue-btn.btn")).click();

            driver2.findElement(By.cssSelector("button.step__footer__continue-btn.btn")).click();
            Thread.sleep(10000);


            driver.close();
            driver.quit();
            driver2.close();
            driver2.quit();

        }
    }
