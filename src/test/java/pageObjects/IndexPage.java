package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends Page{


    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    public RegistrationPage goToRegistration(){
        openIndexPage();
        registerLink.click();
        return new RegistrationPage(driver);
    }

    @FindBy(name="username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "input[value='Log In']")
    private WebElement submitButton;

    public AccountPage login(String usernameT, String passwordT){
        username.sendKeys(usernameT);
        password.sendKeys(passwordT);
        submitButton.click();
        return new AccountPage(driver);
    }

    public AccountPage quickLogIn(String username, String password){
        driver.get(String.format("http://parabank.parasoft.com/parabank/login.htm?username=%s&password=%s",
                username, password));
        waitForPageToLoad(5);
        return new AccountPage(driver);
    }



}
