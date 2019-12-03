package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactFormPage {
    public WebDriver driver;

    By txtEmail = By.id("email");
    By subjectHeading = By.id("id_contact");
    By txtOrder = By.id("id_order");
    By filePath = By.xpath("//*[@id=\"fileUpload\"]");
    By txtMessage = By.xpath("//*[@id=\"message\"]");
    By btnSubmit = By.xpath("//*[@id=\"submitMessage\"]/span");

    public ContactFormPage(WebDriver driver){
        this.driver = driver;
    }

    public String getContactFormPageTitle(){
        return driver.getTitle();
    }

    public void setTxtEmail(String Email) {
        driver.findElement(txtEmail).sendKeys(Email);
    }

    public void setSubjectHeading(String Subject){
        new Select(driver.findElement(subjectHeading)).selectByVisibleText(Subject);
    }

    public void setTxtOrder(String Order) {
        driver.findElement(txtOrder).sendKeys(Order);
    }

    public void setFilePath(String Path) {
        driver.findElement(filePath).sendKeys(Path);
    }

    public void setTxtMessage(String Message){
        driver.findElement(txtMessage).sendKeys(Message);
    }

    public void clickSubmit(){
        driver.findElement(btnSubmit).click();
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
