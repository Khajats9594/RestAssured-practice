package report;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return test.get();
    }

    static void setExtentTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    static void unload() {
        test.remove();
    }
}
