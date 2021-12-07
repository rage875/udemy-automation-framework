package drivers;

import drivers.strategies.DriverStrategy;
import drivers.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver = null;

    private DriverSingleton(DriverStrategy.Driver strategy) {
        createDriver(DriverStrategy.Driver.Chrome);
    }

    private void createDriver(DriverStrategy.Driver strategy) {
        DriverStrategy driverStrategy = DriverStrategyImplementer.setStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void instantiate(DriverStrategy.Driver strategy) {
        if(instance == null) {
            instance = new DriverSingleton(strategy);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeInstance() {
        instance = null;
        driver.quit();
        driver = null;
    }
}
