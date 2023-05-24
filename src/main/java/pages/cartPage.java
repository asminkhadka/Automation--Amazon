package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartPage {

    WebDriver driver=null;
    By cartOpen = By.xpath("//a[@id='nav-cart']");
    By firstItemName = By.xpath("(//div[contains(@class,'sc-list-item-content')])[1]//span[contains(@class,'-full')]");

    public cartPage(WebDriver driver){
        this.driver = driver;
    }
    public String CartOpenFirstItem() {

        driver.findElement(cartOpen).click();
        String firstItemNames =  driver.findElement(firstItemName).getText().trim();
        return firstItemNames;

    }
}
