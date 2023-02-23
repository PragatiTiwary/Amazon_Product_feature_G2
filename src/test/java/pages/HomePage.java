package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import static java.security.IdentityScope.scope;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }


    public WebElement getSearchResult() {
        return searchResult;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(xpath = "//span[@class ='a-color-state a-text-bold']")
    WebElement searchResult;


    public WebElement getAllCategory() {
        return allCategory;
    }
    public WebElement getSelectCategory() {
        return selectCategory;}

    @FindBy(xpath="//div[@class='nav-search-scope nav-sprite']")
    WebElement allCategory;
    @FindBy(xpath = "//select[@id=\"searchDropdownBox\"]")
    WebElement selectCategory;
    public WebElement getSelectAddress() {
        return selectAddress;
    }

    public WebElement getTypeAddress() {
        return typeAddress;
    }

    public WebElement getAddress() {
        return address;
    }
    @FindBy(id = "nav-global-location-popover-link")
    WebElement selectAddress;
    @FindBy(id = "GLUXZipUpdateInput")
    WebElement typeAddress;
    @FindBy(id = "glow-ingress-line2")
    WebElement address;


}

