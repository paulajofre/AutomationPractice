package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class    SignInPage {
    public WebDriver driver;

    @FindBy(id = "email_create")
    WebElement txtEmailCreate;

    @FindBy(id = "SubmitCreate")
    WebElement btnCreateAccount;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "passwd")
    WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    WebElement btnSubmit;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    WebElement btnRecoverPassword;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSignInPageTitle(){
        return driver.getTitle();
    }

    public void setTxtEmailCreate(String EmailCreate){
        txtEmailCreate.sendKeys(EmailCreate);
    }

    public void clickCreateAccount(){
        btnCreateAccount.click();
    }

    public void setTxtEmail(String Email){
        txtEmail.sendKeys(Email);
    }

    public void setTxtPassword(String Password){
        txtPassword.sendKeys(Password);
    }

    public void clickSubmit(){
        btnSubmit.click();
    }

    public void clickRecoverPassword(){
        btnRecoverPassword.click();
    }

    public void logInUser(String Email, String Password){
        this.setTxtEmail(Email);
        this.setTxtPassword(Password);
        this.clickSubmit();
    }

    public void clickRecoverPass(){
        this.clickRecoverPassword();
    }

}
