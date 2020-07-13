package pageObjects;

import org.apache.commons.math3.analysis.function.Exp;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "rightPanel")
    protected WebElement rightPanel;

    public void openIndexPage() {
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    public String getRightPanelMessage() {
        return rightPanel.getText();
    }

    protected List<String> getTableCellContent(List<WebElement> elements) {
        return elements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isUserLoggedIn() {
        return rightPanel.getText().contains("Accounts Overview");
    }

    public List<String> explicitlyWaitToFetchData(List<String> accountData) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(dataToBePickedUp(accountData));
        return accountData;
    }

    public void waitForPageToLoad(long l) {
        driver.manage().timeouts().pageLoadTimeout(l, TimeUnit.SECONDS);
    }

    private ExpectedCondition<Boolean> dataToBePickedUp(List<String> data) { //Todo 1 or 2 parameters
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                List<String> accDetails = new ArrayList<String>(data); //Todo
                return accDetails.size() == 2;
            }
        };
    }


}
