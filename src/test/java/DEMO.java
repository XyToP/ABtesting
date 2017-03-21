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

public class DEMO {
    @Test
    public void Advocate_signUp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


        DemoPage Advocate=new DemoPage(driver, wait);

        Advocate.getURL();
        Advocate.ClickOnFW();
        Advocate.TypeAdvocateName();
        Advocate.TypeAdvocateEmail();
        Advocate.ClickOnLoginButton();


        driver.close();
        driver.quit();
    }

}
