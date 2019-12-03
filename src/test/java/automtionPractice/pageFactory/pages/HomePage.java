package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    @FindBy(id = "contact-link")
    WebElement btnContactUs;

    @FindBy(linkText = "Sign in")
    WebElement btnSignIn;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]")
    WebElement btnDresses;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public void clickContactUs(){
        btnContactUs.click();
    }

    public void clickSignIn(){
        btnSignIn.click();
    }

    public void setBtnDresses(){
        btnDresses.click();
    }

    public void goToContactUs(){
        this.clickContactUs();
    }

    public void goToSignIn(){
        this.clickSignIn();
    }

    public void goToDresses() throws InterruptedException {
        this.setBtnDresses();

    }
}
