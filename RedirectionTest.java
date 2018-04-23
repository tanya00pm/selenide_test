import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.JavascriptExecutor;


public class RedirectionTest {

    private WebDriver driver;
    private String url;

    @Before
    public void initGeckoDriver(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/TNesterova/Downloads/geckodriver-v0.19.1-win64/geckodriver.exe");
    }

    @Before
    public void init(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        url = "http://onetwotrip.com";
        driver.get(url);
        //driver.navigate().to("onetwotrip.com");

        /*
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("alert('Test Alert');");
        }*/

        if(driver.getCurrentUrl().contains(url.replace("http://", "www.")))
            System.out.println("Success");
        else
            System.out.println("Failure");
    }

    @After
    public void tearDown() { /*driver.quit();*/ }

}
