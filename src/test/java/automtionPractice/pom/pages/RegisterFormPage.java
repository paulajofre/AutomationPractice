package automtionPractice.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterFormPage {
    public WebDriver driver;

    By radioTitle = By.id("id_gender2");
    By txtFirstName = By.id("customer_firstname");
    By txtLastName = By.id("customer_lastname");
    By txtPassword = By.id("passwd");
    By txtDayOfBirth = By.id("days");
    By txtMonthOfBirth = By.id("months");
    By txtYearOfBirth = By.id("years");
    By txtFirstNameConfirm = By.id("firstname");
    By txtLastNameConfirm = By.id("lastname");
    By txtAddress = By.id("address1");
    By txtCity = By.id("city");
    By txtState = By.id("id_state");
    By txtZipCode = By.id("postcode");
    By txtCountry = By.id("id_country");
    By txtPhone = By.id("phone_mobile");
    By txtAlias = By.id("address_alias");
    By btnRegister = By.id("submitAccount");

    public RegisterFormPage(WebDriver driver){
        this.driver = driver;
    }

    public String getContactFormPageTitle(){
        return driver.getTitle();
    }

    public void setRadioTitle() {
        driver.findElement(radioTitle).click();
    }

    public void setTxtFirstName(String FirstName){
        driver.findElement(txtFirstName).sendKeys(FirstName);
    }

    public void setTxtLastName(String LastName){
        driver.findElement(txtLastName).sendKeys(LastName);
    }

    public void setTxtPassword(String Password){
        driver.findElement(txtPassword).sendKeys(Password);
    }

    public void setTxtDay(String Day){
        new Select(driver.findElement(txtDayOfBirth)).selectByValue(Day);
    }

    public void setTxtMonth(String Month){
        new Select(driver.findElement(txtMonthOfBirth)).selectByValue(Month);
    }

    public void setTxtYear(String Year){
        new Select(driver.findElement(txtYearOfBirth)).selectByValue(Year);
    }

    public void confirmFirstName(String FirstName2){
        driver.findElement(txtFirstNameConfirm).sendKeys(FirstName2);
    }

    public void confirmLastName(String LastName2){
        driver.findElement(txtLastNameConfirm).sendKeys(LastName2);
    }

    public void setTxtAddress(String Address){
        driver.findElement(txtAddress).sendKeys(Address);
    }

    public void setTxtCity(String City){
        driver.findElement(txtCity).sendKeys(City);
    }

    public void setTxtState(String State){
        new Select(driver.findElement(txtState)).selectByValue(State);
    }

    public void setTxtZipCode(String ZipCode){
        driver.findElement(txtZipCode).sendKeys(ZipCode);
    }

    public void setTxtCountry(String Country){
        new Select(driver.findElement(txtCountry)).selectByValue(Country);
    }

    public void setTxtPhone(String Phone){
        driver.findElement(txtPhone).sendKeys(Phone);
    }

    public void clickRegisterButton(){
        driver.findElement(btnRegister).click();
    }

    public void completeContactForm(String FirstName, String LastName, String Password, String Day, String Month, String Year, String FirstName2, String LastName2, String Address, String City, String State, String ZioCode, String Country, String Phone){
        this.setRadioTitle();
        this.setTxtFirstName(FirstName);
        this.setTxtLastName(LastName);
        this.setTxtPassword(Password);
        this.setTxtDay(Day);
        this.setTxtMonth(Month);
        this.setTxtYear(Year);
        this.confirmFirstName(FirstName2);
        this.confirmLastName(LastName2);
        this.setTxtAddress(Address);
        this.setTxtCity(City);
        this.setTxtState(State);
        this.setTxtZipCode(ZioCode);
        this.setTxtCountry(Country);
        this.setTxtPhone(Phone);
        this.clickRegisterButton();
    }

}

