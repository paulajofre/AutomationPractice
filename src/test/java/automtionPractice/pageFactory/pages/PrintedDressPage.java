package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintedDressPage {
    WebDriver driver;

    @FindBy(id = "quantity_wanted")
    WebElement txtQuantity;

    @FindBy(name = "Pink")
    WebElement selectColor;

    @FindBy(name = "Submit")
    WebElement btnAddToCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElement btnProceed;

    public PrintedDressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPrintedPageTitle(){
        return driver.getTitle();
    }

    public void setTxtQuantity(String Quantity){
        txtQuantity.clear();
        txtQuantity.sendKeys(Quantity);
    }

    public void setSelectColor(){
        selectColor.click();
    }

    public void setBtnAddToCart(){
        btnAddToCart.click();
    }

    public void setBtnProceed() throws InterruptedException {
        driver.switchTo().activeElement();
        Thread.sleep(2000);
        btnProceed.click();
    }

    public void addDressToCart(String Quantity) throws InterruptedException {
        this.setTxtQuantity(Quantity);
        this.setSelectColor();
        this.setBtnAddToCart();
        this.setBtnProceed();
    }

}
