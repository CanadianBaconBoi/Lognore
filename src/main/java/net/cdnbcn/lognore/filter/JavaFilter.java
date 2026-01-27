package net.cdnbcn.lognore.filter;

import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import net.cdnbcn.lognore.Config;

public class JavaFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord event) {
        if (event.getLevel()
            .intValue() <= Config.javaLevel.intValue()) {
            for (String s : Config.loggerFilters) {
                if (event.getLoggerName()
                    .equals(s)) {
                    return false;
                }
            }
            for (String s : Config.messageFilters) {
                if (event.getMessage()
                    .contains(s)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void applyFilter() {
        Logger.getLogger("")
            .setFilter(new JavaFilter());
    }

}
