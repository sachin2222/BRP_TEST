package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageObjects {

    @FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle")
    WebElement Title;

    @FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName")
    WebElement First_Name;

    @FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxLastName")
    WebElement Last_Name;

    @FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINTLMOBILENUMBER")
    WebElement Phone_Number;

    @FindBy(id = "CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldAgentPassword")
    WebElement Password;

    @FindBy(id = "CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldPasswordConfirm")
    WebElement Confirm_Password;


    @FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINPUTDOB")
    WebElement Calender;



    @FindBy(xpath = "//tbody[@class='datepickerYears']/tr/td")
    List<WebElement> years;

    @FindBy(xpath = "//tbody[@class='datepickerMonths']/tr/td")
    List<WebElement> months;

    @FindBy(xpath = "//tbody[@class='datepickerDays']/tr/td")
    List<WebElement> dates;



    @FindBy(id = "CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail")
    WebElement Email;

    @FindBy(id = "chkSpiceClubTnC")
    WebElement checkbox;

    @FindBy(id = "CONTROLGROUPREGISTERVIEW_ButtonSubmit")
    WebElement Submit;


    public WebDriver driver;

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public WebElement getEmail() {
        return Email;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public WebElement getSubmit() {
        return Submit;
    }

    public WebElement getTitle() {
        return Title;
    }

    public WebElement getFirst_Name() {
        return First_Name;
    }

    public WebElement getLast_Name() {
        return Last_Name;
    }

    public WebElement getPhone_Number() {
        return Phone_Number;
    }

    public WebElement getPassword() {
        return Password;
    }

    public WebElement getConfirm_Password() {
        return Confirm_Password;
    }

    public WebElement getCalender() {
        return Calender;
    }

    public List<WebElement> getYears() {
        return years;
    }

    public List<WebElement> getMonths() {
        return months;
    }

    public List<WebElement> getDays() {
        return dates;
    }


}
