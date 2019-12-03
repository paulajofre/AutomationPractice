package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
     WebDriver driver;

     By txtEmail = By.id("email");
     By btnRetrievePassword = By.xpath("//*[@id=\"form_forgotpassword\"]/fieldset/p/button");

    public RecoverPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public String getRecoverPasswordTitle(){
        return driver.getTitle();
    }

    public void setTxtEmail(String Email){
        driver.findElement(txtEmail).sendKeys(Email);
    }

    public void clickRetrievePassword(){
        driver.findElement(btnRetrievePassword).click();
    }

    public void retrievePassword(String Email){
        this.setTxtEmail(Email);
        this.clickRetrievePassword();
    }

}
