import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by macbook on 3/9/17.
 */
public class DemoPage {
    WebDriver driver;
    WebDriverWait wait;

    String url=("https://void-sergey-hutornoy.myshopify.com/");

    By fw = By.cssSelector("a.campaign-trigger-content.js-trigger-offer");
    By adname = By.id("affiliate_member_first_name");
    By ademail = By.name("affiliate_member[email]");
    By signupButton = By.name("commit");
    By frame = By.xpath("//*[@id=\"talkable-offer\"]/iframe");

    public DemoPage(WebDriver driver, WebDriverWait wait)
    {
        this.driver=driver;
        this.wait=wait;
    }

    public void getURL()
    {
        driver.get(url);
    }

    public void ClickOnFW()
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        driver.findElement(fw).click();
        driver.switchTo().parentFrame();
    }
    public void TypeAdvocateName()
    {
        driver.switchTo().frame(1);
        driver.findElement(adname).sendKeys("Automation");
    }
    public void TypeAdvocateEmail()
    {
        driver.findElement(ademail).sendKeys("ad" + (int) Math.ceil(Math.random() * 1000) + "@talkable.com");
    }
    public void ClickOnLoginButton()
    {
        driver.findElement(signupButton).click();
    }
}
