package Pom;

import Base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class VegPizza_Page {

    WebDriver driver;

    public VegPizza_Page(WebDriver driver) {
        this.driver = base.driver;
    }

    public By primaveraGourmetPizza = By.xpath("//div[@data-label='Veg Pizza']//div[@data-label='Primavera Gourmet-Pizza']//span[contains(text(),'ADD TO CART')]");
    public By margherita = By.xpath("//div[@data-label='Veg Pizza']//div[@data-label='Margherita']//span[contains(text(),'ADD TO CART')]");
    public By peppyPaneer = By.xpath("//div[@data-label='Veg Pizza']//div[@data-label='Peppy Paneer']//button[@data-label='addTocart']");
    public By checkBox = By.xpath("//input[@data-label='checkbox']");
    public By thanks = By.xpath("//span[normalize-space()='NO THANKS']");
    public By primveraIncreaseBtn = By.xpath("(//div[@class='crt-itms']//div[@class='crt-bdy']//div[@class='crt-cnt-descrptn']//following::div[@data-label='increase'])[1]");
    public By marghertiaIncreaseBtn = By.xpath("(//div[@class='crt-itms']//div[@class='crt-bdy']//div[@class='crt-cnt-descrptn']//following::div[@data-label='increase'])[2]");
    public By peppyPaneerIncreaseBtn = By.xpath("(//div[@class='crt-itms']//div[@class='crt-bdy']//div[@class='crt-cnt-descrptn']//following::div[@data-label='increase'])[3]");
    public By pepsi = By.xpath("//div[@data-label='Beverages']//descendant::span[text()='Pepsi 475ml']//following::button[@data-label='addTocart'][1]");
    public By PepsiIncreaseBtn = By.xpath("(//div[@class='crt-itms']//div[@class='crt-bdy']//div[@class='crt-cnt-descrptn']//following::div[@data-label='increase'])[4]");
    public By marghertiaDecreaseBtn = By.xpath("(//div[@class='crt-itms']//div[@class='crt-bdy']//div[@class='crt-cnt-descrptn']//following::div[@data-label='decrease'])[2]");
    public By PepsiDecreaseBtn = By.xpath("(//div[@class='crt-itms']//div[@class='crt-bdy']//div[@class='crt-cnt-descrptn']//following::div[@data-label='decrease'])[4]");
    public By checkOutBtn = By.xpath("//button[@data-label='miniCartCheckout']");

    public void clickPrimaveraPizzaCartBtn() {  driver.findElement(primaveraGourmetPizza).click(); }
    public void clickMargheritaCartBtn()     {  driver.findElement(margherita).click(); }
    public void clickPeppyPaneerCartBtn()    {  driver.findElement(peppyPaneer).click(); }
    public void clickPepsiCartBtn()          {  driver.findElement(pepsi).click(); }
    public void setPrimaveraIncreaseBtn()    {  driver.findElement(primveraIncreaseBtn).click(); }
    public void setMargheritaIncreaseBtn()   {  driver.findElement(marghertiaIncreaseBtn).click(); }
    public void setPeppyPaneerIncreaseBtn()  {  driver.findElement(peppyPaneerIncreaseBtn).click(); }
    public void setPepsiIncreaseBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 1; i <= 11; i++) {
            WebElement pepsiInc = wait.until(ExpectedConditions.elementToBeClickable(PepsiIncreaseBtn));
            pepsiInc.click();
        }
    }
    public void clickCheckBox() {
        WebElement checkBoxElement = driver.findElement(checkBox);
        if (checkBoxElement.isDisplayed()) {
            if (checkBoxElement.isEnabled()) {
                checkBoxElement.click();
            }
        } else {
            System.out.println("No CheckBox");
        }
    }
    public void clickNoThanks() {
        WebElement thanksElement = driver.findElement(thanks);
        if (thanksElement.isDisplayed()) {
            if (thanksElement.isEnabled()) {
                thanksElement.click();
            }
        } else {
            System.out.println("No Thanks");
        }
    }
    public double userVerifiesSubtotalValue() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='crt-itms']//following::span[@class='rupee']"));
         double CalculatedTotal = 0;

        for (WebElement row : rows) {
            String priceText = row.getText();
            Double price = Double.parseDouble(priceText);//pdt price
            System.out.println(price);
            CalculatedTotal += price ;//price*qty===>add the total
            System.out.println("Calculated total : " + CalculatedTotal);
            System.out.println("==============================");
        }

        return CalculatedTotal;
    }
    public void setMarghertiaDecreaseBtn() {
        driver.findElement(marghertiaDecreaseBtn).click();
    }
    public void setPepsiDecreaseBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 1; i < 7; i++) {
            WebElement pepsiDecrease = wait.until(ExpectedConditions.elementToBeClickable(PepsiDecreaseBtn));
            pepsiDecrease.click();
        }
    }
    public double userVerifiesSubTotalValueAfterRemovingProduct() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='crt-itms']//following::span[@class='rupee']"));
        double calculatedTotal = 0;
        for (WebElement row : rows) {
            String priceText = row.getText();
            Double price = Double.parseDouble(priceText);
            System.out.println(price);
            calculatedTotal += price;
            System.out.println("Price After Removing Pdt : " + calculatedTotal);
            System.out.println("==================================");
        }
        return calculatedTotal;
    }
    public void userClickCheckOutBtn(){  driver.findElement(checkOutBtn).click();  }
    public double CalculatedSubTotal() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='price']"));
        double calculatedTotal = 0;
        for (WebElement row : rows) {
            String priceText = row.getText();
            Double price = Double.parseDouble(priceText);
            calculatedTotal += price;
            System.out.println(" After checkout: " + calculatedTotal);
        }
        return calculatedTotal;
    }
    public double displayedSubTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actualSubTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='txt--wrpr'] span:nth-child(2) span:nth-child(1)")));

        String actualSubTotaltext = actualSubTotal.getText();
        return Double.parseDouble(actualSubTotaltext);
    }
    }



