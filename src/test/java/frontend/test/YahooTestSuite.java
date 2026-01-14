package frontend.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class YahooTestSuite {
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
        //   new WebDriverWait(driver, Duration.ofSeconds(30)).until(CustomConditions.jQueryAJAXsCompleted());
    }

//    @Test
//    public void yahooTabTitleTest(){
//        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.titleContains("Yahoo"));
//
//        String title = driver.getTitle();
//
//        System.out.println("Page title has " + title);
//
//      assertTrue("Title of the Chrome tab does not contain 'Yahoo'", title.contains("Yahoo"));
//       // Assert.assertEquals("Yahoo", driver.getTitle());
//
//    }
    @Test
    public void yahooHeaderTest() {
        By headerSelector=By.xpath("//header[@id='module-uh']");
        WebElement header = driver.findElement(headerSelector);
      assertTrue("no header found", header.isDisplayed());
    }

    @Test
    public void yahooSearchTest(){
        By searchFieldSelector= By.id("uh-sbq");
        WebElement search_box = waitForElementLocatedBy(driver, searchFieldSelector);

        search_box.sendKeys("chicago");

        By searchButtonSelector = By.cssSelector("button[aria-label='Search the web']");
        List <WebElement> searchButton = driver.findElements(searchButtonSelector);
        searchButton.get(0).click();

        By resultsListSelector = By.xpath("//div[contains(@class, 'dd') ]"); //and contains (@class, 'Chicago')
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions
//                        .presenceOfAllElementsLocatedBy(resultsListSelector));



        List <WebElement> resultsList = waitForSearchResultsLocatedBy(driver, resultsListSelector);
                //driver.findElements(resultsListSelector);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("we have following amount results:" + resultsList.size());

    }

    private static List<WebElement> waitForSearchResultsLocatedBy(WebDriver driver, By resultsListSelector) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(resultsListSelector));
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(by));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
