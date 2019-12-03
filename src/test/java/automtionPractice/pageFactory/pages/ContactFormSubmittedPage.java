package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFormSubmittedPage {
        public WebDriver driver;

        @FindBy(linkText = "Home")
        WebElement btnHome;

        public ContactFormSubmittedPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public String getContactFormSubmittedTitle(){
            return driver.getTitle();
        }

        public void clickHome(){
            btnHome.click();
        }

        public void goBacktoHomePage(){
            this.clickHome();
        }
}
