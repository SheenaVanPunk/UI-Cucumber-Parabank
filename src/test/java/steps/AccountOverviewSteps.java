package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.AccountPage;
import pageObjects.IndexPage;
import pageObjects.RegistrationPage;
import utils.Injection;

import static org.testng.Assert.assertTrue;

public class AccountOverviewSteps {
    Injection injection;
    AccountPage account;
    IndexPage index; //should be removed as soon as quickLogIn() becomes available again TODO
    RegistrationPage registration;//should be removed as soon as quickLogIn() becomes available again TODO

    public AccountOverviewSteps(Injection injection, Hooks hooks){
        this.injection = injection;
        WebDriver driver = hooks.getDriver();
        account = new AccountPage(driver); //uncomment as soon as quickLogin() becomes available Todo
        index = new IndexPage(driver); //should be removed as soon as quickLogIn() becomes available again TODO
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        //"nena", "test"
        index.openIndexPage();
        registration = index.goToRegistration();
        registration.register();
        account = registration.goToAccountsOverview();
//        account.quickLogIn("dusa", "sadu");
//        account.quickLogIn(injection.username, injection.password);
    }

    @Then("they can see account number, balance and available amount")
    public void theyCanSeeAccountNumberBalanceAndAvailableAmount() {
        assertTrue(account.isAccountTableContentProperlyDisplayed());
    }


    @When("they want to see account details")
    public void theyWantToSeeAccountDetails() {
    }

    @Then("they see Account Number, Account Type, Balance, Available")
    public void theySeeAccountNumberAccountTypeBalanceAvailable() {
    }

    @Given("user is at Account Details screen")
    public void userIsAtAccountDetailsScreen() {
    }

    @When("they select Activity Period and Account Type")
    public void theySelectActivityPeriodAndAccountType() {
    }

    @Then("they can see their account activity for the chosen period and account")
    public void theyCanSeeTheirAccountActivityForTheChosenPeriodAndAccount() {
    }
}
