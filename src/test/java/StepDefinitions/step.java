package StepDefinitions;

import Base.base;
import Pom.Home_Page;
import Pom.VegPizza_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class step  {

 WebDriver driver;
 Home_Page home_page;
 VegPizza_Page vegPizza_page;

    @Given("user launch the {string} browser")
        public void userLaunchTheBrowser(String browser){
        base.initializeBrowser(browser);
        System.out.println("Step:Browser launching");
        home_page=new Home_Page(driver);
        vegPizza_page = new VegPizza_Page(driver);
    }
    @Then("user verifies the homepage")
    public void userIsOnTheHomepage() {
           home_page.getHomePageTitle();
    }
    @And("user click order online now")
    public void userClickOrderOnlineNow() throws InterruptedException {
        home_page.clickOrderOnlineBtn();
        Thread.sleep(5000);
    }
    @And("user click enter address and enter pincode and select first suggestion")
    public void userClickEnterAddressAndEnterPinCodeAsAndSelectFirstSuggestion() throws InterruptedException {
        home_page.enterYourDeliveryAddress();
        home_page.enterAreaLocation();
        Thread.sleep(5000);
        home_page.selectFirstSuggestion();
        Thread.sleep(5000);
        home_page.clickNotification();
        Thread.sleep(5000);
    }
    @And("user goes to veg pizza section and add {string} as quantity {int}")
    public void userGoesToVegPizzaSectionAndAddAsQuantity(String pizza1, int qty1) throws InterruptedException {
       vegPizza_page.clickPrimaveraPizzaCartBtn();
       Thread.sleep(5000);

    }
    @And("user want to add {int} {string} and {int} {string} pizzas to my cart")
    public void userWantToAddAndPizzasToMyCart(int qty2,String pizza2,int qty3,String pizza3) throws InterruptedException {
        vegPizza_page.clickMargheritaCartBtn();
        Thread.sleep(5000);
        vegPizza_page.clickCheckBox();
        Thread.sleep(5000);
        vegPizza_page.clickNoThanks();
        Thread.sleep(5000);
        vegPizza_page.clickPeppyPaneerCartBtn();
        Thread.sleep(5000);
        vegPizza_page.setPrimaveraIncreaseBtn();
        vegPizza_page.setMargheritaIncreaseBtn();
        Thread.sleep(5000);
        vegPizza_page.setPeppyPaneerIncreaseBtn();
        Thread.sleep(5000);
    }
    @And("user goes to beverages section and select {string} with quantity {int}")
    public void userGoesToBeveragesSectionAndSelectWithQuantity(String pepsi, int qty4) throws InterruptedException {
        vegPizza_page.clickPepsiCartBtn();
        Thread.sleep(5000);
        vegPizza_page.setPepsiIncreaseBtn();
        Thread.sleep(5000);
    }
    @Then("user verifies Cart Subtotal Value with Sum of Each Products and their quantities")
    public void userVerifiesCartSubtotalValueWithSumOfEachProductsAndTheirQuantities() throws InterruptedException {
        vegPizza_page.userVerifiesSubtotalValue();
        Thread.sleep(5000);
   }
    @And("user goes to the veg section in  removing {string} pizza with quantity {int}")
    public void userGoesToTheVegSectionInRemovingPizzaWithQuantity(String pizza2, int qty2) throws InterruptedException {
        vegPizza_page.setMarghertiaDecreaseBtn();
        Thread.sleep(5000);
    }
    @And("user goes to the beverages section and removing {string} with quantity {int}")
    public void userGoesToTheBeveragesSectionAndRemovingWithQuantity(String pepsi, int qty4) throws InterruptedException {
        vegPizza_page.setPepsiDecreaseBtn();
        Thread.sleep(5000);
    }
    @Then("user verifies Cart Subtotal Value with Sum of Each Product Value and quantity after removing products")
    public void userVerifiesCartSubtotalValueWithSumOfEachProductValueAndQuantityAfterRemovingProducts() throws InterruptedException {
        vegPizza_page.userVerifiesSubTotalValueAfterRemovingProduct();
        Thread.sleep(5000);
    }
    @And("user Get Sub Total Value & Click Check Out")
    public void userGetSubTotalValueClickCheckOut() throws InterruptedException {
        vegPizza_page.userClickCheckOutBtn();
        Thread.sleep(5000);
    }
    @Then("user verifies the Subtotal Checkout With Subtotal Place Order Price Details")
    public void userVerifiesTheSubtotalCheckoutWithSubtotalPlaceOrderPriceDetails() throws InterruptedException {
        double calculatedTotal = vegPizza_page.CalculatedSubTotal();
        double displayedTotal = vegPizza_page.displayedSubTotal();
        double delta=0.01;
        System.out.println("Checkout CalculatedSubtotal: " +calculatedTotal );
        Thread.sleep(5000);
        System.out.println("Checkout Displayed Subtotal: " + displayedTotal);
        Thread.sleep(5000);
        Assert.assertEquals(calculatedTotal,displayedTotal,delta);
        System.out.println("SubTotal verification Passed " + calculatedTotal);
    }

}
