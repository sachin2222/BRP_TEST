package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

    WebDriver driver;

    @FindBy(id = "ControlGroupLoginView_MemberLoginView2LoginView_TextBoxUserID")
    WebElement username;

    @FindBy(id = "ControlGroupLoginView_MemberLoginView2LoginView_PasswordFieldPassword")
    WebElement password;

    @FindBy(id = "ControlGroupLoginView_MemberLoginView2LoginView_ButtonLogIn")
    WebElement login;


    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getlogin() {
        return login;
    }

}
