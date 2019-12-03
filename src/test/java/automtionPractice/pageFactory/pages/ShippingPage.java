package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
    WebDriver driver;

    @FindBy(id="cgv")
    WebElement checkboxAgree;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    WebElement btnProceedToCheckoutShipping;

    public ShippingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getShippingPageTitle(){
        return driver.getTitle();
    }

    public void setCheckboxAgree(){
        checkboxAgree.click();
    }

    public void setBtnProceedToCheckoutShipping(){
        btnProceedToCheckoutShipping.click();
    }

    public void ContinueShipping(){
        this.setCheckboxAgree();
        this.setBtnProceedToCheckoutShipping();
    }

}
