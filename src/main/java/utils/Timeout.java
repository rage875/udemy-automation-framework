package utils;

public class Timeout {
    public static void timeOutNotSafe(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
