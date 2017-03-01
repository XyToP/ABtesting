import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class click_fw {
    @Test
    public void no_sigup() throws InterruptedException {
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
        driver.findElement(By.cssSelector("div.popup-close.is-solid.js-offer-close")).click();
        driver.close();
        driver.quit();
    }
}