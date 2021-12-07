import drivers.DriverSingleton;
import drivers.strategies.DriverStrategy;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.FrameworkProperties;
import utils.Timeout;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.instantiate(DriverStrategy.Driver.valueOf(frameworkProperties.getProperty("automation.driver")));
        WebDriver driver = DriverSingleton.getDriver();

        driver.get("http://automationpractice.com");
        HomePage homePage = new HomePage();
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();

        Timeout.timeOutNotSafe(2000);

        DriverSingleton.closeInstance();
    }
}
