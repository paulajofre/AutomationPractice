package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintedDressPage {
    WebDriver driver;

    By txtQuantity = By.id("quantity_wanted");
    By selectColor = By.name("Pink");
    By btnAddToCart = By.name("Submit");
    By btnProceed = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");

    public PrintedDressPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPrintedPageTitle(){
        return driver.getTitle();
    }

    public void setTxtQuantity(String Quantity){
        driver.findElement(txtQuantity).clear();
        driver.findElement(txtQuantity).sendKeys(Quantity);
    }

    public void setSelectColor(){
        driver.findElement(selectColor).click();
    }

    public void setBtnAddToCart(){
        driver.findElement(btnAddToCart).click();
    }

    public void setBtnProceed() throws InterruptedException {
        driver.switchTo().activeElement();
        Thread.sleep(2000);
        driver.findElement(btnProceed).click();
    }

    public void addDressToCart(String Quantity) throws InterruptedException {
        this.setTxtQuantity(Quantity);
        this.setSelectColor();
        this.setBtnAddToCart();
        this.setBtnProceed();
    }

}
