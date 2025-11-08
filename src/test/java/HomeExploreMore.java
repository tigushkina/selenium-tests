import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class HomeExploreMore {
    private WebDriver driver;

    @Before
    public void setUp() {   // ChromeDriver setting up

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://yahoo.com");
        Object result = ((JavascriptExecutor) driver)
                .executeScript("return window.jQuery != null;");
        System.out.println("jQuery loaded? " + result);


        }
    @Test
    public void exploreMoreElementsTest(){

        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout for waiting for search results list was exceeded");


        List<WebElement> exploreMoreItems = wait.until(new Function<WebDriver, List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(By.xpath("//section[@id='explore-hub']"));
            }
        });
        WebElement exploreMoreSection = driver.findElement(By.xpath("//section[@id='explore-hub']"));
        new Actions(driver).scrollToElement(exploreMoreSection).perform();

        Assert.assertTrue("elements are not loaded in the Explore section", exploreMoreItems.size()>0);

        System.out.println("Found " + exploreMoreItems.size() + " elements");
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
