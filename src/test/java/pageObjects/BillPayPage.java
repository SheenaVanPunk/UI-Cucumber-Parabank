package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.User;
import java.util.List;

import java.util.Random;
import java.util.stream.Collectors;

public class BillPayPage extends Page{

    public BillPayPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "payee.name")
    private WebElement name;

    @FindBy(name = "payee.address.street")
    private WebElement address;

    @FindBy(name = "payee.address.city")
    private WebElement city;

    @FindBy(name = "payee.address.state")
    private WebElement state;

    @FindBy(name = "payee.address.zipCode")
    private WebElement zip;

    @FindBy(name = "payee.phoneNumber")
    private WebElement phone;

    @FindBy(name = "payee.accountNumber")
    private WebElement payeeAccountNumber;

    @FindBy(name = "verifyAccount")
    private WebElement verifyAccount;

    @FindBy(name = "amount")
    private WebElement amountField;

    @FindBy(css = "input[value='Send Payment']")
    private WebElement sendPayment;

    public List<String> enterPayeeDataAndSubmit(List<String> l) {
        if(driver.getTitle().contains("Bill Pay")){
            User user = new User();
            String fullName = user.getFirstName() + " " + user.getLastName();
            name.sendKeys(fullName);
            address.sendKeys(user.getAddress());
            city.sendKeys(user.getCity());
            state.sendKeys(user.getState());
            zip.sendKeys(user.getZip());
            phone.sendKeys(user.getPhone());
            payeeAccountNumber.sendKeys(user.getAccountNumber());
            verifyAccount.sendKeys(user.getAccountNumber());

            String amount = generateAmount(l.get(1));
            amountField.sendKeys(amount);

            String acct = l.get(0);
            selectAccountFromDropdown(acct);
            sendPayment.click();

            return List.of(fullName, amount, acct);
        }
        System.out.println("Not on a Bill Pay page.");
        return null;
    }

    @FindBy(css = "div[ng-show='showResult'] p")
    private WebElement message;

    public String getConfirmationMessage(){
        return message.getText().replace("\n", "");
    }

    @FindBy(id = "payeeName")
    private WebElement pName;
    @FindBy(id = "amount")
    private WebElement paidAmount;
    @FindBy(id = "fromAccountId")
    private WebElement fromAcct;
    public List<?> getPaymentDetailsFromConfMessage(){
        String[] p = paidAmount.getText().replace("$", "").split(".");
        var pAmount = p[0];
        return List.of(pName.getText(), paidAmount, fromAcct.getText());
    }

    @FindBy(name = "fromAccountId")
    private WebElement fromAccount;
    private void selectAccountFromDropdown(String s) {
        Select select = new Select(fromAccount);
        select.selectByValue(s);
    }

    private String generateAmount(String s){
        Random random = new Random();
        double i = Double.parseDouble(s);
        return String.valueOf(random.nextInt((int) i));
    }

    @FindBy(linkText = "Accounts Overview")
    private WebElement accountsOverviewLink;
    public AccountPage gotoAccountOverview() {
        accountsOverviewLink.click();
        return new AccountPage(driver);
    }
}
