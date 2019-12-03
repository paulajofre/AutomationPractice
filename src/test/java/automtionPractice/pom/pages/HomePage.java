package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;

    By btnContactUs = By.id("contact-link");
    By btnSignIn = By.linkText("Sign in");
    By btnDresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public void clickContactUs(){
        driver.findElement(btnContactUs).click();
    }

    public void clickSignIn(){
        driver.findElement(btnSignIn).click();
    }

    public void setBtnDresses(){
        driver.findElement(btnDresses).click();
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
