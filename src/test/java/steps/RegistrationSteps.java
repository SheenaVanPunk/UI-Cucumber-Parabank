package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.IndexPage;
import pageObjects.RegistrationPage;
import utils.Injection;

import static org.testng.Assert.assertTrue;

public class RegistrationSteps {
    Injection testData;
    IndexPage index;
    RegistrationPage registration;


    public RegistrationSteps(Injection util, Hooks hooks) {
        this.testData = util;
        WebDriver driver = hooks.getDriver();
        index = new IndexPage(driver);
    }

    @Given("user wants to register an account")
    public void userWantsToRegisterAnAccount() {
        registration = index.goToRegistration();
    }


    @When("they enter valid data")
    public void theyEnterValidData() {
        var user = registration.register();

        testData.username = user.getUsername();
        testData.password = user.getPassword();
    }

    @Then("new account is created")
    public void newAccountIsCreated() {
        String actualMessage = registration.getRightPanelMessage();
        String expectedMessage = String.format("Welcome %s\nYour account was created successfully. You are now logged in.", testData.username);

        assertTrue(actualMessage.contains(expectedMessage), "The welcome message and username are displayed on the right panel.");
        System.out.println(String.format("%s\n%s", testData.username, testData.password));
    }

}
