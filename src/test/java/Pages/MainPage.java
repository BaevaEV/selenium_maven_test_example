package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(id = "logout-btn")
    private WebElement logoutButton;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Boolean logoutButtonIsDisplayed() {
        if (logoutButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}


