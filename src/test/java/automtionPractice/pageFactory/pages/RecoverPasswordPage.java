package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverPasswordPage {
     WebDriver driver;

     @FindBy(id = "email")
     WebElement txtEmail;

     @FindBy(xpath = "//*[@id=\"form_forgotpassword\"]/fieldset/p/button")
     WebElement btnRetrievePassword;

    public RecoverPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getRecoverPasswordTitle(){
        return driver.getTitle();
    }

    public void setTxtEmail(String Email){
        txtEmail.sendKeys(Email);
    }

    public void clickRetrievePassword(){
        btnRetrievePassword.click();
    }

    public void retrievePassword(String Email){
        this.setTxtEmail(Email);
        this.clickRetrievePassword();
    }

}
