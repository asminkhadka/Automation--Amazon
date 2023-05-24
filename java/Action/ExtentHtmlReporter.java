package Action;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentHtmlReporter {
    public static ExtentReports extent;
    static ExtentSparkReporter spark;

    public static void htmlReport (){

        extent = new ExtentReports();
        spark = new ExtentSparkReporter("ExtentTest.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        extent.attachReporter(spark);
    }
}
