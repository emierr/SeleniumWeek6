import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearch extends PageObject {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(id = "L2AGLb")
    private WebElement acceptTermsBtn;

    @FindBy(id = "search")
    private WebElement searchFieldContains;

    public GoogleSearch(WebDriver driver) {
        super(driver);
    }

    public void enterSearchTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void clickSearch() {
        searchBtn.click();
    }

    public void acceptTerms() {
        if (acceptTermsBtn.isDisplayed()) {
            acceptTermsBtn.click();
        }
    }

    public boolean resultOKCheck(String searchTerm) {
        return searchFieldContains.getText().contains(searchTerm);
    }

}
