package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.AccountDetailsPage;
import pageObjects.AccountPage;
import java.util.List;

import pageObjects.IndexPage;
import utils.Injection;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountOverviewSteps {
    Injection injection;
    AccountPage account;
    AccountDetailsPage details;
    IndexPage index;

    public AccountOverviewSteps(Injection injection, Hooks hooks){
        this.injection = injection;
        WebDriver driver = hooks.getDriver();
        account = new AccountPage(driver);
        index = new IndexPage(driver);
    }

    @Given("user is logged in")
    public void userIsLoggedIn(DataTable table) {
        List<String> credentials = table.asList();
        injection.username = credentials.get(0);
        injection.password = credentials.get(1);
        account = index.quickLogIn(injection.username, injection.password);
    }

    @Then("account number, balance and available amount are properly displayed")
    public void accountNumberBalanceAndAvailableAmountAreProperlyDisplayed() {
        assertTrue(account.isAccountTableContentProperlyDisplayed());
    }

    @Given("user has seen Account Number, Balance and Available sum")
    public void userHasSeenAccountNumberBalanceAndAvailableSum() {
        account = index.quickLogIn(injection.username, injection.password);
        injection.accountDetails = account.getAccountDetails();
    }

    @When("user is at Account Details screen")
    public void userIsAtAccountDetailsScreen() {
        details = account.goToAccountDetails();
    }

    @Then("values for all given parameters are matching")
    public void valuesForAllParametersAreMatching(DataTable table) {
        List<String> credentials = table.asList();
        injection.username = credentials.get(0);
        injection.password = credentials.get(1);
        assertEquals(details.getAccountDetails(), injection.accountDetails, "Account details do not match.");
    }

}
