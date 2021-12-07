package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    private WebElement addToCartFirstButton;

    @FindBy(css = "#homefeatured > li:nth-child(2) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    private WebElement addToCartSecondButton;

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    private WebElement cart;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span")
    private WebElement continueShoppingButton;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
    private WebElement proceedCheckoutButton;


    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line")
    private WebElement firstElement;

    @FindBy(css = "#homefeatured > li:nth-child(2)")
    private WebElement secondElement;


    public void addFirstElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(firstElement).build().perform();
        addToCartFirstButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();

        if(cart.getText().contains("1 Product"))
            System.out.println("Cart has been updated");
    }

    public void addSecondElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(secondElement).build().perform();
        addToCartSecondButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Constants.TIMEOUT_SECS);
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckoutButton));
        proceedCheckoutButton.click();
    }
}
