package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewNote {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='Card_containerNew__adAai']")
    private WebElement createButton;

    @FindBy(id = "note-modal-title-new_empty")
    private WebElement noteTitleTextField;

    @FindBy(xpath = "//div[contains(text(),'Содержание')]")
    private WebElement addContentButton;

    @FindBy(id = "note-modal-content-new_empty")
    private WebElement noteContentTextField;

    @FindBy(id = "palette-btn-new_empty")
    private WebElement addColorButton;

    @FindBy(id = "palette-color-#fff475")
    private WebElement addNoteColorButton;

    @FindBy(id = "note-modal-save-btn-new_empty")
    private WebElement saveNewNoteButton;

    public void clickCreateButton(){
        createButton.click();
    }

    public void fillNoteTitleTextField(String TitleText){
        noteTitleTextField.sendKeys(TitleText);
    }

    public void clickAddContent(){
        addContentButton.click();
    }

    public void addNoteContent(String ContentText){
        noteContentTextField.sendKeys(ContentText);;
    }

    public void clickAddColor(){
        addColorButton.click();;
    }

    public void clickAddNoteColor(){
        addNoteColorButton.click();;
    }

    public void saveNewNote(){
        saveNewNoteButton.click();;
    }


    public CreateNewNote(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Boolean createButtonIsDisplayed() {
        if (createButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
    public Boolean saveButtonIsDisplayed() {
        if (saveNewNoteButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}

