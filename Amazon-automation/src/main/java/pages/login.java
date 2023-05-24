package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
    WebDriver driver;
    By log_in= By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    By email_field= By.xpath("//input[@id='ap_email']");
    By continue_email = By.xpath("//input[@id='continue']");
    By password_field = By.xpath("//input[@id='ap_password']");
    By sign_in = By. xpath("//input[@id='signInSubmit']");
    public login(WebDriver driver){
        this.driver= driver;
    }

    public void getLoginIn() {
        driver.findElement(log_in).click();
    }

    public void getEmailField(String text) {
        driver.findElement(email_field).sendKeys(text);

    }
    public void setContinueEmail(){
        driver.findElement(continue_email).click();
    }
    public void setPasswordField(String text){
        driver.findElement(password_field).sendKeys(text);
    }
    public void clickSignIn(){
        driver.findElement(sign_in).click();
    }

}
//input[@id='ap_email']