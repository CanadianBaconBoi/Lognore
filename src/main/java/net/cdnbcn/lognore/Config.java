package net.cdnbcn.lognore;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static String greeting = "Hello World";

    public static String[] messageFilters = {};
    public static String[] loggerFilters = {};

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        greeting = configuration.getString("greeting", Configuration.CATEGORY_GENERAL, greeting, "How shall I greet?");
        messageFilters = configuration.getStringList("messageFilters", Configuration.CATEGORY_GENERAL, messageFilters, "Messages to filter (substring)");
        loggerFilters = configuration.getStringList("loggerFilters", Configuration.CATEGORY_GENERAL, loggerFilters, "Log4j loggers to filter");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
