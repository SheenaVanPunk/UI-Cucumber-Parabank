package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "rightPanel")
    protected WebElement rightPanel;

    public void openIndexPage() {
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    public String getRightPanelMessage(){
        return rightPanel.getText();
    }

    protected List<String> getTableCellContent(List<WebElement> elements){
        return elements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isUserLoggedIn(){
        return rightPanel.getText().contains("Accounts Overview");
    }


}
