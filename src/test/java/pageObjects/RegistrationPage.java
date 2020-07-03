package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.User;


public class RegistrationPage extends Page{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement address;

    @FindBy(id = "customer.address.city")
    private WebElement city;

    @FindBy(id = "customer.address.state")
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zip;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phone;

    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @FindBy(id = "customer.username")
    private WebElement username;

    @FindBy(id = "customer.password")
    private WebElement password;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassword;

    @FindBy(css = "input[value='Register']")
    private WebElement registerButton;

    public User register(){
        User user = new User();

        firstName.sendKeys(user.getFirstName());
        lastName.sendKeys(user.getLastName());
        address.sendKeys(user.getAddress());
        city.sendKeys(user.getCity());
        state.sendKeys(user.getState());
        zip.sendKeys(user.getZip());
        phone.sendKeys(user.getPhone());
        ssn.sendKeys(user.getSsn());
        username.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
        confirmPassword.sendKeys(user.getPassword());

        registerButton.click();
        return user;
    }

    //a workaround as long as Parabank throws 500 Server Error during login attempt
    //should be deleted after the error is resolved
    @FindBy(linkText = "Accounts Overview")
    private WebElement accountsO;
    public AccountPage goToAccountsOverview() {
        accountsO.click();
        return new AccountPage(driver);
    }
}
