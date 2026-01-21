package net.cdnbcn.lognore;

import java.io.File;

import net.cdnbcn.lognore.filter.FilterLevel;
import net.minecraftforge.common.config.Configuration;

public class Config {
    public static String maxFilteredLevel = "WARN";
    public static String[] messageFilters = {};
    public static String[] loggerFilters = {};

    public static FilterLevel filterLevel = FilterLevel.WARN;
    public static org.apache.logging.log4j.Level log4jLevel = org.apache.logging.log4j.Level.WARN;
    public static java.util.logging.Level javaLevel = java.util.logging.Level.WARNING;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        maxFilteredLevel = configuration.getString("maxFilteredLevel", Configuration.CATEGORY_GENERAL, maxFilteredLevel, "Max filtered log level, valid values are ERROR, WARN, INFO, DEBUG. For example, setting to WARN, would filter WARN, INFO, and DEBUG.");
        messageFilters = configuration.getStringList("messageFilters", Configuration.CATEGORY_GENERAL, messageFilters, "Messages to filter (substring)");
        loggerFilters = configuration.getStringList("loggerFilters", Configuration.CATEGORY_GENERAL, loggerFilters, "Log4j loggers to filter");

        filterLevel = getValueForLabel(maxFilteredLevel);
        log4jLevel = getLog4jLevelForFilterLevel(filterLevel);
        javaLevel = getJavaLevelForFilterLevel(filterLevel);

        if (configuration.hasChanged() || !configFile.exists()) {
            configuration.save();
        }
    }

    public static FilterLevel getValueForLabel(String label) {
        return switch (label) {
            case "WARN" -> FilterLevel.WARN;
            case "INFO" -> FilterLevel.INFO;
            case "DEBUG" -> FilterLevel.DEBUG;
            case "ERROR" -> FilterLevel.ERROR;
            default -> throw new StringIndexOutOfBoundsException("Invalid value for filterLevel: " + label);
        };
    }

    public static org.apache.logging.log4j.Level getLog4jLevelForFilterLevel(FilterLevel level) {
        return switch (level) {
            case WARN -> org.apache.logging.log4j.Level.WARN;
            case INFO -> org.apache.logging.log4j.Level.INFO;
            case DEBUG -> org.apache.logging.log4j.Level.DEBUG;
            case ERROR -> org.apache.logging.log4j.Level.ERROR;
        };
    }

    public static java.util.logging.Level getJavaLevelForFilterLevel(FilterLevel level) {
        return switch (level) {
            case WARN -> java.util.logging.Level.WARNING;
            case INFO -> java.util.logging.Level.INFO;
            case DEBUG -> java.util.logging.Level.FINE;
            case ERROR -> java.util.logging.Level.SEVERE;
        };
    }

}
