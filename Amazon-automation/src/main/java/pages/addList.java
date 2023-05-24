package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class addList {
    WebDriver driver=null;
    By AddItem = By.xpath("//input[@id='add-to-cart-button']");

    public addList(WebDriver driver){
        this.driver = driver;
    }
    public void AddItem(){
        driver.findElement(AddItem).sendKeys(Keys.RETURN);
    }
}
