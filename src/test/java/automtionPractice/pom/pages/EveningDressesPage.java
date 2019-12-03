package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EveningDressesPage {
    WebDriver driver;

    By Image = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img");
    By btnMore = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span");

    public EveningDressesPage(WebDriver driver){
        this.driver = driver;
    }

    public String getEveningDressesPageTitle(){
        return driver.getTitle();
    }

    public void setBtnMore(){
        driver.findElement(btnMore).click();
    }

    public void clickMoreBtn() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(Image);
        actions.moveToElement(target).perform();
        Thread.sleep(1000);
        this.setBtnMore();
    }
}
