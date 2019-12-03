package automtionPractice.pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterFormPage {
    public WebDriver driver;

    @FindBy(id = "id_gender2")
    WebElement radioTitle;

    @FindBy(id = "customer_firstname")
    WebElement txtFirstName;

    @FindBy(id = "customer_lastname")
    WebElement txtLastName;

    @FindBy(id = "passwd")
    WebElement txtPassword;

    @FindBy(id = "days")
    WebElement txtDayOfBirth;

    @FindBy(id = "months")
    WebElement txtMonthOfBirth;

    @FindBy(id = "years")
    WebElement txtYearOfBirth;

    @FindBy(id = "firstname")
    WebElement txtFirstNameConfirm;

    @FindBy(id = "lastname")
    WebElement txtLastNameConfirm;

    @FindBy(id = "address1")
    WebElement txtAddress;

    @FindBy(id = "city")
    WebElement txtCity;

    @FindBy(id = "id_state")
    WebElement txtState;

    @FindBy(id = "postcode")
    WebElement txtZipCode;

    @FindBy(id = "id_country")
    WebElement txtCountry;

    @FindBy(id = "phone_mobile")
    WebElement txtPhone;

    @FindBy(id = "address_alias")
    WebElement txtAlias;

    @FindBy(id = "submitAccount")
    WebElement btnRegister;

    public RegisterFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getContactFormPageTitle(){
        return driver.getTitle();
    }

    public void setRadioTitle() {
        radioTitle.click();
    }

    public void setTxtFirstName(String FirstName){
        txtFirstName.sendKeys(FirstName);
    }

    public void setTxtLastName(String LastName){
        txtLastName.sendKeys(LastName);
    }

    public void setTxtPassword(String Password){
        txtPassword.sendKeys(Password);
    }

    public void setTxtDay(String Day){
        new Select(txtDayOfBirth).selectByValue(Day);
    }

    public void setTxtMonth(String Month){
        new Select(txtMonthOfBirth).selectByValue(Month);
    }

    public void setTxtYear(String Year){
        new Select(txtYearOfBirth).selectByValue(Year);
    }

    public void confirmFirstName(String FirstName2){
        txtFirstNameConfirm.sendKeys(FirstName2);
    }

    public void confirmLastName(String LastName2){
        txtLastNameConfirm.sendKeys(LastName2);
    }

    public void setTxtAddress(String Address){
        txtAddress.sendKeys(Address);
    }

    public void setTxtCity(String City){
        txtCity.sendKeys(City);
    }

    public void setTxtState(String State){
        new Select(txtState).selectByValue(State);
    }

    public void setTxtZipCode(String ZipCode){
        txtZipCode.sendKeys(ZipCode);
    }

    public void setTxtCountry(String Country){
        new Select(txtCountry).selectByValue(Country);
    }

    public void setTxtPhone(String Phone){
        txtPhone.sendKeys(Phone);
    }

    public void clickRegisterButton(){
        btnRegister.click();
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

