
import org.testng.annotations.Test;
import data.LoadProperties;

public class AddToCartTest extends TestBase {
    AddToCart addtocart;

    LoadProperties loadProperties;
    String firstname=loadProperties.envData.getProperty("firstname");
    String lastname=loadProperties.envData.getProperty("lastname");
    String email=loadProperties.envData.getProperty("email");
    String country=loadProperties.envData.getProperty("country");
    String city=loadProperties.envData.getProperty("city");
    String address=loadProperties.envData.getProperty("address");
    String zipcode=loadProperties.envData.getProperty("zipcode");
    String phonenumber=loadProperties.envData.getProperty("phonenumber");

    public AddToCartTest () {
        super();
    }
    @Test
    public void addtoCart() throws InterruptedException
    {
        addtocart = new AddToCart(driver);
        addtocart.addtocart();
        addtocart.clickonaddtocartbutton();
        addtocart.checkout();
        addtocart.checkoutasguest();
        addtocart.Billingaddress(firstname,lastname,email,country,city,address,zipcode,phonenumber);
        addtocart.shippingmethod();
        addtocart.paymentmethod();
        addtocart.paymentinfo();
        addtocart.confirmorder();
    }
}
