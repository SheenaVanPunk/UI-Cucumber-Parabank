package steps;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pageObjects.IndexPage;
import pageObjects.AccountPage;
import utils.Injection;
import io.cucumber.java.en.*;
import java.util.List;

import static org.testng.Assert.*;

public class LoginSteps{

    private Injection injection;
    private IndexPage index;
    private AccountPage overview;

    public LoginSteps(Injection injection, Hooks hooks) {
        this.injection = injection;
        WebDriver driver = hooks.getDriver();
        index = new IndexPage(driver);
    }

    @Given("user is on the index of the Parabank Application")
    public void userIsOnTheIndexOfTheParabankApplication() {
        index.openIndexPage();
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials(DataTable table) {
        List<String> credentials = table.asList();
        overview = index.login(credentials.get(0), credentials.get(1));
    }

    @Then("they should be taken to the Overview page")
    public void they_should_be_taken_to_the_overview_page() {
        String actualUserFullName = overview.getUserFullName();
        assertTrue(actualUserFullName.contains(injection.userFullName), "Expected user full name is displayed.");
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
