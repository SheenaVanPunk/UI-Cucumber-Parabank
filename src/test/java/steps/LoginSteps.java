package steps;

import org.openqa.selenium.WebDriver;
import pageObjects.IndexPage;
import pageObjects.OverviewPage;
import utils.Injections;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import java.util.List;
import static org.testng.Assert.*;

public class LoginSteps{

    private Injections testData;
    private IndexPage index;
    private OverviewPage overview;

    public LoginSteps(Injections util, Hooks hooks) {
        this.testData = util;
        WebDriver driver = hooks.getDriver();
        index = new IndexPage(driver);
    }

    @Given("user is on the index of the Parabank Application")
    public void userIsOnTheIndexOfTheParabankApplication() {
        index.openPage("http://parabank.parasoft.com/parabank/index.htm");
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials(DataTable table) {
        List<String> userDetails = table.asList();
        testData.userFullName = userDetails.get(2);

        overview = index.login(userDetails.get(0), userDetails.get(1));
    }

    @Then("they should be taken to the Overview page")
    public void they_should_be_taken_to_the_overview_page() {
        String actualUserFullName = overview.getUserFullName();
        assertTrue(actualUserFullName.contains(testData.userFullName), "Expected user full name is displayed.");
        assertTrue(overview.isRightPanelDisplayed(), "Right panel is displayed.");
        overview.logOut();
    }

    @Then("they should see appropriate error")
    public void theyShouldSeeAppropriateError() {
        String actualError = index.getRightPanelMessage();
        var errorText = "Error!\nThe username and password could not be verified.";

        assertTrue(actualError.contains(errorText), "The appropriate error is displayed.");
    }

    @When("user enters invalid {string} and {string}")
    public void userEntersInvalidUsernameAndPassword(String username, String password) {
        index.login(username, password);
    }


}
