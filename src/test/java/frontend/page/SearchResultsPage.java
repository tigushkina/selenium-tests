package frontend.page;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class SearchResultsPage {
    WebDriver driver;

    Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class)
            .withMessage("Timeout for waiting for search results list was exceeded");

}
