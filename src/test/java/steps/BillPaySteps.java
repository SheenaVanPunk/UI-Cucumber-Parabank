package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.AccountPage;
import pageObjects.BillPayPage;
import pageObjects.IndexPage;
import utils.Injection;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BillPaySteps {
    Injection injection;
    BillPayPage bill;
    IndexPage index;
    AccountPage account;

    public BillPaySteps(Injection injection, Hooks hooks) {
        this.injection = injection;
        WebDriver driver = hooks.getDriver();
        index = new IndexPage(driver);
    }

    @Given("user is at Bill Pay page")
    public void userIsAtBillPayPage(){
        account = index.quickLogIn(injection.username, injection.password);
        injection.accountDetails = account.getAccountAndBalance();

    }

    @When("user enters valid payee information")
    public void  userEntersValidPayeeInformation(){
        bill = account.goToBillPay();
        var values = bill.enterPayeeDataAndSubmit(injection.accountDetails);
        injection.payeeName = values.get(0);
        injection.amount = values.get(1);
        injection.account = values.get(2);
    }

    @Then("user can successfully pay a bill")
    public void userCanSuccessfullyPayABill(){
        assertTrue(bill.getPaymentDetailsFromConfMessage().containsAll(
                List.of(injection.payeeName, injection.amount, injection.account)), "The expected values do not match actual pay bill details from the conf. message"
        );
    }

    @And("same amount will be deducted from chosen account")
    public void sameAmountWillBeDeductedFromChosenAccount(){
        account = bill.gotoAccountOverview();
        double actual = Double.parseDouble(account.getAccountAndBalance().get(1).replace("$",""));
        double expected = Double.parseDouble(injection.accountDetails.get(1).replace("$","")) - Double.parseDouble(injection.amount);
        assertEquals(actual, expected, "The expected amount does not match");

    }

}
