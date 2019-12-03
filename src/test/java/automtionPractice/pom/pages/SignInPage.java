package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class    SignInPage {
    public WebDriver driver;

    By txtEmailCreate = By.id("email_create");
    By btnCreateAccount = By.id("SubmitCreate");
    By txtEmail = By.id("email");
    By txtPassword = By.id("passwd");
    By btnSubmit = By.id("SubmitLogin");
    By btnRecoverPassword = By.xpath("//*[@id=\"login_form\"]/div/p[1]/a");

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSignInPageTitle(){
        return driver.getTitle();
    }

    public void setTxtEmailCreate(String EmailCreate){
        driver.findElement(txtEmailCreate).sendKeys(EmailCreate);
    }

    public void clickCreateAccount(){
        driver.findElement(btnCreateAccount).click();
    }

    public void setTxtEmail(String Email){
        driver.findElement(txtEmail).sendKeys(Email);
    }

    public void setTxtPassword(String Password){
        driver.findElement(txtPassword).sendKeys(Password);
    }

    public void clickSubmit(){
        driver.findElement(btnSubmit).click();
    }

    public void clickRecoverPassword(){
        driver.findElement(btnRecoverPassword).click();
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
