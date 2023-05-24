package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class openItem {
    WebDriver driver=null;

//    By itemSelect = By.xpath("(//span[@class='a-price-whole'])[2]");
    By itemSelect = By.xpath("(//div[contains(@class,'s-title-instructions-style')])[1]");

    public openItem(WebDriver driver){
        this.driver = driver;
    }

    public String OpenItem() {
        System.out.printf("This is from open item ");
        String itemToBeSelectedToCart = driver.findElement(itemSelect).getText().trim();
        System.out.printf(itemToBeSelectedToCart);
        driver.findElement(itemSelect).click();

        return  itemToBeSelectedToCart;
    }
}


