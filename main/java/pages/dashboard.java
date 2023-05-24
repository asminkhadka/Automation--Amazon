package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class dashboard {
    WebDriver driver = null;
    By textbox_search = By.xpath("//input[@id='twotabsearchtextbox']");
    By button_search = By.xpath("//input[@id='nav-search-submit-button']");
    By location_change = By.xpath("//a[@id='nav-global-location-popover-link']");
    By zipcode = By.xpath("//input[@id='GLUXZipUpdateInput']");
    By clickDone = By.xpath("//input[@id='GLUXConfirmClose']");
    By location_change_popup= By.xpath("//input[@data-action-type='SELECT_LOCATION']");
    public dashboard(WebDriver driver){
        this.driver = driver;
    }


    public void AddTextInSearchBox(String text) {
        driver.findElement(textbox_search).sendKeys(text);
    }

    public void SearchButton(String text) {
        driver.findElement(button_search).sendKeys(text);
        System.out.println("This is form search itme");
    }
    public void locationChange(){
        driver.findElement(location_change).click();
//        driver.findElement(location_change_popup).click();
    }
    public void setZipcode(String text){
        driver.findElement(zipcode).sendKeys(text);
        driver.findElement(zipcode).sendKeys(Keys.RETURN);
    }
    public void setClickDone(){
        driver.findElement(clickDone).sendKeys(Keys.RETURN);
    }

}