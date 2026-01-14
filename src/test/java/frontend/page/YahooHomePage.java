package frontend.page;

import org.openqa.selenium.*;

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
