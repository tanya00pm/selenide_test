import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;

import org.apache.log4j.Logger;

public class FindEpamJobTest {
    private WebDriver driver;
    private String URL;

    public static final Logger logger =  Logger.getLogger(FindEpamJobTest.class);

    @Before
    public void initGeckoDriver(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/TNesterova/Downloads/geckodriver-v0.19.1-win64/geckodriver.exe");
    }

    @Before
    public void init(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("[Info_IT] The running test name is :: " /*+  testContext.getAllTestMethods()[testsCounter].getMethodName() */);
    }

    @Test
    public void test() {
        URL = "https://www.epam.com/careers";
        driver.get(URL);

        driver.findElement(By.xpath(".//*[@id='main']/div[1]/div[1]/section/div/div[4]/form/div/label/input")).sendKeys("Software Developer");

        //Select dropdown = new Select(driver.findElement(By.id("select-box-location-yu-container")));
        //Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='select-box-location-ya-container']")));
       // WebElement dropdown= driver.findElement(By.xpath(".//*[@id='select-box-location-ya-container']"));
        WebElement dropdown= driver.findElement(By.id("select-box-location-yu-container"));

        driver.findElement(By.className("job-search__submit")).click();
    }

}
