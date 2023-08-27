package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.util.Objects;

public class ExtentReport {
    private ExtentReport() {
    }
    private static ExtentReports extent;
    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
            spark.viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
            extent.attachReporter(spark);
            spark.config().setDocumentTitle("RestAssured");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName("UserApplicationApi");
            extent.setSystemInfo("Operating System", "Macos");
            extent.setSystemInfo("java version", "java 18");

        }

    }
    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
    }

    public static void createTest(String testcase) {
        ExtentTest extentTest = extent.createTest(testcase);
        ExtentManager.setExtentTest(extentTest);
    }


    public static void addAuthors(String authors) {
        ExtentManager.getExtentTest().assignAuthor(authors);
    }

    public static void addCategories(String categories) {
        ExtentManager.getExtentTest().assignCategory(categories);
    }
}
