package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends Page {


    public OverviewPage(WebDriver driver) {
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

    public void logOut() {
        logOutLink.click();
    }

}
