package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AccountDetailsPage extends Page{

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "accountId")
    private WebElement accountId;

    @FindBy(id = "balance")
    private WebElement balance;

    @FindBy(id="availableBalance")
    private WebElement available;

    @FindBy(css = "input[value='Go']")
    private WebElement goButton;
    public Iterable<?> getAccountDetails() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return List.of(accountId.getText(),
                        balance.getText(),
                        available.getText());
    }
}
