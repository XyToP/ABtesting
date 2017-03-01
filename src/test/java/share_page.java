import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class share_page {
    @Test
    public void sign_up() throws InterruptedException {
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

        driver.close();
        driver.quit();
    }
}



