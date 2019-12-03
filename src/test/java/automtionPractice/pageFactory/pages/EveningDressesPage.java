package automtionPractice.pageFactory.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EveningDressesPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    WebElement Image;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")
    WebElement btnMore;

    public EveningDressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEveningDressesPageTitle(){
        return driver.getTitle();
    }

    public void setBtnMore(){
        btnMore.click();
    }

    public void clickMoreBtn() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Actions actions = new Actions(driver);
        WebElement target = Image;
        actions.moveToElement(target).perform();
        Thread.sleep(1000);
        this.setBtnMore();
    }
}
