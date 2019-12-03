package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage {
    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[2]/a")
    WebElement btnEveningDresses;

    public DressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getDressesPageTitle(){
        return driver.getTitle();
    }

    public void setBtnEveningDresses(){
        btnEveningDresses.click();
    }

    public void GoToEveningDresses(){
        this.setBtnEveningDresses();
    }
}
