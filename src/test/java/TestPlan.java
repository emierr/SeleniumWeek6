import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestPlan {


    private static final WebDriver driver = new ChromeDriver();
    private static final String SEARCH_TERM = "ltu";
    private static final String RESULT_CONTAINS = "Luleå tekniska universitet";

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }


    //  In the @Test I am using Thread.sleep after each method call instead of
    //  Selenium wait commands because I want it to always halt for 1000ms to
    //  give me time to view the process

    @Test(testName = "Search google for searchterm")
    public static void searchGoogle() throws InterruptedException {
        driver.get(Utils.BASE_URL);
        GoogleSearch object = new GoogleSearch(driver);
        Thread.sleep(1000);
        object.acceptTerms();
        Thread.sleep(1000);
        object.enterSearchTerm(SEARCH_TERM);
        Thread.sleep(1000);
        object.clickSearch();
        Thread.sleep(1000);
        Assert.assertTrue(object.resultOKCheck(RESULT_CONTAINS));
    }


    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
