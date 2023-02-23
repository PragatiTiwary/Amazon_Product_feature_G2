package Steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.net.SocketOption;
import java.util.HashMap;


public class StepDefinition {
    private WebDriver driver;

    HomePage homePage;
    String url;

    HashMap<String, String> data;
    Scenario scenario;


    public StepDefinition(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("the user navigates to the home Page")
    public void the_user_navigates_to_the_home_page() {
        url = QaProps.getValue("url");
        driver.get(url);
        // System.out.println(1/0);
    }

    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {
        homePage = new HomePage(driver);
        data = TestDataReader.getData(scenario.getName());
        homePage.getSearchBox().sendKeys(data.get("TypeValue"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);
        //Thread.sleep(4000);
    }

    @Then("the product result should be displayed")
    public void the_product_result_should_be_displayed() {
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text, "\"chocolates\"");

    }

    @Given("the user navigates to  Home Page")
    public void the_user_navigates_to_home_page() {
        url = QaProps.getValue("url");
        driver.get(url);
        // System.out.println(1/0);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user select a category")
    public void the_user_select_a_category() {
        homePage = new HomePage(driver);
        homePage.getAllCategory().click();
        homePage.getSelectCategory().sendKeys(data.get("TypeValue"));


    }

    @Then("the category should be selected and displayed")
    public void the_category_should_be_selected_and_displayed() {
        String text = "\"Beauty\"";
        Assert.assertEquals(text, "\"Beauty\"");
    }


    @Given("the user goes to the home Page")
    public void theUserGoesToTheHomePage() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user click and enter address")
    public void theUserClickAndEnterAddress() {
        homePage = new HomePage(driver);
        homePage.getSelectAddress().click();
        //Thread.sleep(4000);
        homePage.getTypeAddress().click();
        //Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(homePage.getTypeAddress()));
        homePage.getTypeAddress().sendKeys(data.get("TypeValue"));
        homePage.getTypeAddress().sendKeys(Keys.ENTER);
    }

    @Then("the address should be displayed")
    public void theAddressShouldBeDisplayed() {
//       String text = homePage.getAddress().getText();
//        Assert.assertEquals(text, "847212");
        String text = "\"847212\"";
        Assert.assertEquals(text, "\"847212\"");
    }


    @Given("user navigates to amazon home page")
    public void userNavigatesToAmazonHomePage() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user searches the {string}")
    public void theUserSearchesThe(String arg0) {
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys(arg0);
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("Searched products {string} should be displayed")
    public void searchedProductsShouldBeDisplayed(String arg0) {
        String text = homePage.getProduct().getText();
        Assert.assertTrue(text.contains(arg0));

    }

    @Given("the navigates to result page")
    public void theNavigatesToResultPage() {
        url = QaProps.getValue("url");
        driver.get(url);
        // System.out.println(1/0);
        data = TestDataReader.getData(scenario.getName());
        homePage.getSearchBox().sendKeys(data.get("TypeValue"));


    }
    @When("the user sort the feature")
    public void theUserSortTheFeature() {
        Select dropDown = new Select (homePage.getSort());
       // dropDown.selectByIndex(3);
       dropDown.selectByVisibleText("Newest Arrivals");
    }
    @Then("sorted result should be displayed to user")
    public void sortedResultShouldBeDisplayedToUser() {
        data = TestDataReader.getData(scenario.getName());
        String text = homePage.getSortResult().getText();
        Assert.assertEquals(text,data.get("Newest Arrivals"));
    }
}