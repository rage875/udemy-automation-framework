package drivers.strategies;

public class DriverStrategyImplementer {
    public static DriverStrategy setStrategy(DriverStrategy.Driver strategy) {
        switch (strategy) {
            case Chrome:
                return new Chrome();
            case Firefox:
                return new Firefox();
            case PhantomJs:
                return new PhantomJs();
            default:
                System.out.println(String.format("[ERROR]: %s driver not supported", strategy));
                return null;
        }
    }
}
