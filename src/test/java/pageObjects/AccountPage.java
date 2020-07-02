package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page {


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "smallText")
    private WebElement userFullName;

    public String getUserFullName() {
        return userFullName.getText();
    }

    public boolean isRightPanelDisplayed() {
        return rightPanel.isDisplayed();
    }

    @FindBy(linkText = "Log Out")
    private WebElement logOutLink;

    public void quickLogIn(String username, String password){
        driver.get(String.format("http://parabank.parasoft.com/parabank/login.htm?username=%s&password=%s",
                                    username, password));
    }

    public void logOut() {
        logOutLink.click();
    }

    //http://parabank.parasoft.com/parabank/login.htm?username=nena&password=test
    //http://parabank.parasoft.com/parabank/login.htm?username={injections.username}&password={injections.password}

}
