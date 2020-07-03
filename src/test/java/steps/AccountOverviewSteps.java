package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.AccountDetailsPage;
import pageObjects.AccountPage;
import pageObjects.IndexPage;
import pageObjects.RegistrationPage;
import utils.Injection;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountOverviewSteps {
    Injection injection;
    AccountPage account;
    AccountDetailsPage details;

    public AccountOverviewSteps(Injection injection, Hooks hooks){
        this.injection = injection;
        WebDriver driver = hooks.getDriver();
        account = new AccountPage(driver);
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        account.quickLogIn(injection.username, injection.password);
    }

    @Then("account number, balance and available amount are properly displayed")
    public void accountNumberBalanceAndAvailableAmountAreProperlyDisplayed() {
        assertTrue(account.isAccountTableContentProperlyDisplayed());
    }

    @Given("user has seen Account Number, Balance and Available sum")
    public void userHasSeenAccountNumberBalanceAndAvailableSum() {
        account.quickLogIn(injection.username, injection.password);
        injection.accountDetails = account.getAccountDetails();
    }

    @When("user is at Account Details screen")
    public void userIsAtAccountDetailsScreen() {
        details = account.goToAccountDetails();
    }

    @Then("values for all given parameters are matching")
    public void valuesForAllParametersAreMatching() {
        var a = details.getAccountDetails();
        assertEquals(a, injection.accountDetails, "Account details do not match.");
    }

}
