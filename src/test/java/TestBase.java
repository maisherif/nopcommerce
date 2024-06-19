
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    public static WebDriver driver;

    data.LoadProperties loadProperties;
    String url=loadProperties.envData.getProperty("URL");

    @BeforeClass
    @Parameters({"browser"})
    public void Startdriver(@Optional ("chrome") String browsername)
    {
        if (browsername.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
        }
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterClass
    public void Closedriver() {
        driver.close();
    }


}
