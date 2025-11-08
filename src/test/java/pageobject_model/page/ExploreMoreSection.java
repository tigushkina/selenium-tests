package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ExploreMoreSection {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    public ExploreMoreSection(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public ExploreMoreSection waitForExploreSection() {
        WebElement exploreMoreSection = wait.until(d ->
                d.findElement(By.xpath("//section[@id='explore-hub']"))
        );
        new Actions(driver).scrollToElement(exploreMoreSection).perform();
        return this;
    }

    public int exploreItemsCount() {
        int exploreMoreItems = 0;

        return exploreMoreItems;
    }
}
