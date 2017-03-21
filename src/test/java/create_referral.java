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

public class create_referral {
    @Test
    public void new_referral() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get("https://admin.void.talkable.com/sites/demo-2-1/customer_service/create_referral");
 //login
        driver.findElement(By.id("email")).sendKeys("hutornoy+03@talkable.com");
        driver.findElement(By.id("password")).sendKeys("1qaz@WSX3edc");
        driver.findElement(By.cssSelector("input.base-btn.is-success.is-xl.ac-login-button")).click();
 //referral
        driver.findElement(By.xpath("//*[@id=\"build_referral_advocate_email\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"build_referral_advocate_email\"]")).sendKeys("java@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"new_build_referral\"]/div[1]/div[3]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"build_referral_friend_origin_subtotal\"]")).sendKeys("23");
        driver.findElement(By.cssSelector("input.base-btn.is-primary")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.table.table-striped.table-bordered")));
        driver.close();
        driver.quit();
    }
}
