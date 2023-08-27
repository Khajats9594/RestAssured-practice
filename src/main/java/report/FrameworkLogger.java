package report;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import enums.LogType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public class FrameworkLogger {
    private FrameworkLogger() {
    }

    private static final Consumer<String> PASS = (message) -> ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
    private static final Consumer<String> FAIL = (message) -> ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    private static final Consumer<String> SKIP = (message) -> ExtentManager.getExtentTest().skip(MarkupHelper.createLabel(message, ExtentColor.YELLOW));
    private static final Consumer<String> LOGJSON = (message) -> ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    private static final Consumer<String> INFO = (message) -> ExtentManager.getExtentTest().info(message);
    private static final Consumer<String> CONSOLE = (message) -> System.out.println("INFO---->" + message);
    private static final Consumer<String> EXTENTANDCONSOLE = PASS.andThen(CONSOLE);


    private static final Map<LogType, Consumer<String>> MAP = new EnumMap<>(LogType.class);


    static {
        MAP.put(LogType.PASS, PASS);
        MAP.put(LogType.FAIL, FAIL);
        MAP.put(LogType.SKIP, SKIP);
        MAP.put(LogType.LOGJSON, LOGJSON);
        MAP.put(LogType.INFO, INFO);
        MAP.put(LogType.CONSOLE, CONSOLE);
        MAP.put(LogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE);

    }

    public static void log(LogType status, String message) {
        MAP.getOrDefault(status, EXTENTANDCONSOLE).accept(message);
    }

}
