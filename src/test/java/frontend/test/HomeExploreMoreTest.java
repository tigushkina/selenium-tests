package frontend.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import frontend.page.ExploreMoreSection;

public class HomeExploreMoreTest {
    private WebDriver driver;

    @Before
    public void setUp() {   // ChromeDriver setting up

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://yahoo.com");
//        Object result = ((JavascriptExecutor) driver)
//                .executeScript("return window.jQuery != null;");
//        System.out.println("jQuery loaded? " + result);


        }
    @Test
    public void exploreMoreElementsTest(){

        int expectedExploreMoreItemsNumber = new ExploreMoreSection(driver)
                .waitForExploreSection()
                .exploreItemsCount();

        Assert.assertTrue("elements are not loaded in the Explore section",expectedExploreMoreItemsNumber>0);

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
