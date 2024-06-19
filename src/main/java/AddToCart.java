
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.Assert;

public class AddToCart {

    private WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;

    public AddToCart(WebDriver driver) {
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;

    }
    public void clickButtonJS(WebElement button)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);

    }
    public void WaitFor(By ByElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));
    }

    private By htcitemButton = By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[3]");
    private By shoppingcartbutton = By.xpath("//div[@class='bar-notification-container']/div/p/a");
    private By placeordercontent = By.xpath("//div[@class='bar-notification-container']/div/p");

    public void addtocart() throws InterruptedException
    {

        WebElement htcitemelement = driver.findElement(htcitemButton);
        js.executeScript("arguments[0].scrollIntoView();", 	htcitemelement);
        Thread.sleep(1000);
//        WaitFor(htcitem);
        clickButtonJS(htcitemelement);

    }

    public void clickonaddtocartbutton()
    {

        WaitFor(placeordercontent);
        WebElement  element = driver.findElement(placeordercontent);
        Assert.assertEquals("The product has been added to your shopping cart", element.getText());

        element = driver.findElement(shoppingcartbutton);
        element.click();

    }
    //placeorderform
    private By checkoutbuton = By.xpath("//button[@class='button-1 checkout-button']");
    private By termsandconditioncheckbox = By.xpath("//div[@class='terms-of-service']/input");


    public void checkout()
    {
        WaitFor(checkoutbuton);
        WebElement element = driver.findElement(termsandconditioncheckbox);
        element.click();

        element = driver.findElement(checkoutbuton);
        element.click();
    }
    private By checkoutasguestButton = By.xpath("//button[@class='button-1 checkout-as-guest-button']");
    public void checkoutasguest()
    {
        WaitFor(checkoutasguestButton);
        WebElement element = driver.findElement(checkoutasguestButton);
        element.click();
    }

    private By firstnameTextBox = By.xpath("//input[@id='BillingNewAddress_FirstName']");
    private By lastnameTextBox = By.xpath("//input[@id='BillingNewAddress_LastName']");
    private By emailTextBox = By.xpath("//input[@id='BillingNewAddress_Email']");
    private By countryDropDownList= By.xpath("//div/select[@id='BillingNewAddress_CountryId']");
    private By cityTextBox = By.xpath("//input[@id='BillingNewAddress_City']");
    private By addressTextBox = By.xpath("//input[@id='BillingNewAddress_Address1']");
    private By zipcodeTextBox = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    private By phonenumberTextBox = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");

    private By continueButton = By.xpath("//button[@class='button-1 new-address-next-step-button']");


    public void Billingaddress(String firstname,String lastname,String email, String country , String city, String address, String zipcode, String phonenumber) throws InterruptedException {
        WaitFor(firstnameTextBox);
        WebElement element = driver.findElement(firstnameTextBox);
        element.click();

        driver.findElement(firstnameTextBox).sendKeys(firstname);
        driver.findElement(lastnameTextBox).sendKeys(lastname);
        driver.findElement(emailTextBox).sendKeys(email);

        Select list1value = new Select(driver.findElement(countryDropDownList));
        list1value.selectByVisibleText(country);

        driver.findElement(cityTextBox).sendKeys(city);
        driver.findElement(addressTextBox).sendKeys(address);
        driver.findElement(zipcodeTextBox).sendKeys(zipcode);
        driver.findElement(phonenumberTextBox).sendKeys(phonenumber);

        element = driver.findElement(continueButton);
        element.click();
    }
    private By continueshippingmethodButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    public void shippingmethod()
    {
        WaitFor(continueshippingmethodButton);

        WebElement element = driver.findElement(continueshippingmethodButton);
        element.click();
    }
    private By continuepaymentmethodButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    public void paymentmethod()
    {
        WaitFor(continuepaymentmethodButton);

        WebElement element = driver.findElement(continuepaymentmethodButton);
        element.click();
    }
    private By continuepaymentinfoButton = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    public void paymentinfo()
    {
        WaitFor(continuepaymentinfoButton);

        WebElement element = driver.findElement(continuepaymentinfoButton);
        element.click();
    }

    private By confirmorderButton = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
    public void confirmorder()
    {
        WaitFor(confirmorderButton);

        WebElement element = driver.findElement(confirmorderButton);
        element.click();
    }

}
