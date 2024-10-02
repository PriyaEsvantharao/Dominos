package Pom;

import Base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home_Page {

    WebDriver driver;
    WebDriverWait wait;

    public Home_Page(WebDriver driver) {
        this.driver = base.driver;
    }
    public By orderOnlineBtn = By.xpath("//button[normalize-space()='ORDER ONLINE NOW']");
    public By enterYourDeliveryAddresss=By.cssSelector("[placeholder='Enter your delivery address']");
    public By notification = By.xpath("//button[@id='moe-dontallow_button']");
    public By enterAreaLoc = By.cssSelector("[placeholder='Enter Area / Locality']");
    public By firstSuggestion = By.xpath("//div[@class='sc-fBuWsC eMOfwp']//child::li[@data-label='location_[object Object]'][1]");

    public void clickOrderOnlineBtn()      { driver.findElement(orderOnlineBtn).click();}
    public void enterYourDeliveryAddress() { driver.findElement(enterYourDeliveryAddresss).click();}
    public void enterAreaLocation()        { driver.findElement(enterAreaLoc).sendKeys("600100");}
    public void selectFirstSuggestion()    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suggestion = wait.until(ExpectedConditions.presenceOfElementLocated(firstSuggestion));
        suggestion.click();
    }
    public String getHomePageTitle() {
        String title = driver.getTitle();
        System.out.println("HomePage Title "+title);
        return title;}
    public void clickNotification(){
    if(notification==null){
        System.out.println("No Check Box");
    }else driver.findElement(notification).click();
}


}
