package frontend.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import frontend.base.BaseTest;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SearchInputTests extends BaseTest {
    @Test
    public void searchInputIsVisibleOnPageLoadTest() {
        driver.get("https://yahoo.com");

        By searchFieldSelector= By.id("uh-sbq");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldSelector));

        assertTrue("Search bar is not visible on page load", searchBox.isDisplayed());
    }


}
