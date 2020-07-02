package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "rightPanel")
    protected WebElement rightPanel;

    public void openPage(String s) {
        driver.get(s);
    }

    public String getRightPanelMessage(){
        return rightPanel.getText();
    }


}
