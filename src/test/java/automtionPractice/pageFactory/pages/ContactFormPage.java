package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactFormPage {
    public WebDriver driver;

    @FindBy(id = "id_contact")
    WebElement subjectHeading;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "id_order")
    WebElement txtOrder;

    @FindBy(xpath = "//*[@id=\"fileUpload\"]")
    WebElement filePath;

    @FindBy(xpath = "//*[@id=\"message\"]")
    WebElement txtMessage;

    @FindBy(xpath = "//*[@id=\"submitMessage\"]/span")
    WebElement btnSubmit;


    public ContactFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getContactFormPageTitle(){
        return driver.getTitle();
    }

    public void setTxtEmail(String Email) {
        txtEmail.sendKeys(Email);
    }

    public void setSubjectHeading(String Subject){
        new Select(subjectHeading).selectByVisibleText(Subject);
    }

    public void setTxtOrder(String Order) {
        txtOrder.sendKeys(Order);
    }

    public void setFilePath(String Path) {
        filePath.sendKeys(Path);
    }

    public void setTxtMessage(String Message){
        txtMessage.sendKeys(Message);
    }

    public void clickSubmit(){
        btnSubmit.click();
    }

    public void sendMessage(String Email, String Subject, String Order, String Path, String Message){
        this.setTxtEmail(Email);
        this.setSubjectHeading(Subject);
        this.setTxtOrder(Order);
        this.setFilePath(Path);
        this.setTxtMessage(Message);
        this.clickSubmit();
    }
}
