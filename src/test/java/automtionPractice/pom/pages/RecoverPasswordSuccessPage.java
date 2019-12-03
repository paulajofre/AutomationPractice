package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordSuccessPage {
    WebDriver driver;

    By btnBackToLogIn = By.linkText("Back to Login");

    public RecoverPasswordSuccessPage(WebDriver driver){
        this.driver = driver;
    }

    public String getRecoverPasswordSuccessTitle(){
        return driver.getTitle();
    }

    public void setBtnBackToLogIn(){
        driver.findElement(btnBackToLogIn).click();
    }

    public void goBackToLogIn(){
        this.setBtnBackToLogIn();
    }

}
