package pageObjects;

import io.cucumber.datatable.DataTable;
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

    public void register(User user){
        user = new User();

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
    }

}
