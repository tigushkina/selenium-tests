package pageobject_model.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class YahooHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://yahoo.com";
    private ExploreMoreSection exploreMoreSection;


    Object result = ((JavascriptExecutor) driver)
            .executeScript("return window.jQuery != null;");
    //    System.out.println("jQuery loaded? " + result);




    public YahooHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        Object result = ((JavascriptExecutor) driver)
                .executeScript("return window.jQuery != null;");
        System.out.println("jQuery loaded? " + result);
        return this;
    }



}
