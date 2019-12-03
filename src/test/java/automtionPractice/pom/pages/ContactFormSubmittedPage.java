package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactFormSubmittedPage {
        public WebDriver driver;

        By btnHome = By.linkText("Home");

        public ContactFormSubmittedPage(WebDriver driver){
            this.driver = driver;
        }

        public String getContactFormSubmittedTitle(){
            return driver.getTitle();
        }

        public void clickHome(){
            driver.findElement(btnHome).click();
        }

        public void goBacktoHomePage(){
            this.clickHome();
        }
}
