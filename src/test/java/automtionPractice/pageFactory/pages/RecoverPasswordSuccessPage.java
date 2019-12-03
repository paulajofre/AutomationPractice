package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverPasswordSuccessPage {
    WebDriver driver;

    @FindBy(linkText = "Back to Login")
    WebElement btnBackToLogIn;

    public RecoverPasswordSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getRecoverPasswordSuccessTitle(){
        return driver.getTitle();
    }

    public void setBtnBackToLogIn(){
        btnBackToLogIn.click();
    }

    public void goBackToLogIn(){
        this.setBtnBackToLogIn();
    }

}
