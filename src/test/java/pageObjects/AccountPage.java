package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean quickLogIn(String username, String password){
        driver.get(String.format("http://parabank.parasoft.com/parabank/login.htm?username=%s&password=%s",
                                    username, password));
        return isUserLoggedIn();
    }

    public void logOut() {
        logOutLink.click();
    }

    @FindBy(tagName = "h1")
    private WebElement sectionTitle;

    @FindBy(id = "accountTable")
    private WebElement accountTable;

    @FindBy(tagName = "th")
    private List<WebElement> headers;

    @FindBy(tagName = "td")
    private List<WebElement> rowCells;

    public boolean isAccountTableContentProperlyDisplayed(){
        if(isUserLoggedIn()){
          return verifyTableTitleAndHeadersContent() && verifyTableCellsNotEmpty();
        }
        System.out.println("Account section is not displayed because the user is not logged in.");
        return false;
    }

    public boolean verifyTableCellsNotEmpty() {
        var cellIsEmpty = getTableCellContent(rowCells)
                .stream()
                .map(String::isEmpty)
                .collect(Collectors.toList());
        return cellIsEmpty.containsAll(new ArrayList<>(Collections.nCopies(cellIsEmpty.size(), false)));
    }

    public boolean verifyTableTitleAndHeadersContent(){
        List<String> content = new ArrayList<String>();
        content.add(sectionTitle.getText());
        for(String cellContent : getTableCellContent(headers)){
            content.add(cellContent);
        }
        return content.equals(List.of("Accounts Overview", "Account", "Balance*", "Available Amount"));
    }

    @FindBy(css = "a[href*='activity']")
    private WebElement accountNumber;

    public AccountDetailsPage goToAccountDetails() {
        accountNumber.click();
        if(!isUserLoggedIn()) {
            System.out.println("User login failed.");
            return null;
        }
        return new AccountDetailsPage(driver);
    }

    public List<String> getAccountDetails(){
        return getTableCellContent(rowCells).subList(0, 3);
    }

}
