package drivers.strategies;

import org.openqa.selenium.WebDriver;

public interface DriverStrategy {
    enum Driver {
        Chrome,
        Firefox,
        PhantomJs
    };

    WebDriver setStrategy();
}
