package net.cdnbcn.lognore.filter;

import net.cdnbcn.lognore.Config;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.Message;

public class Log4jFilter implements Filter {
    @Override
    public Filter.Result filter(LogEvent event) {
        if (event.getLevel().intLevel() >= Config.log4jLevel.intLevel()) {
            for (String s : Config.loggerFilters) {
                if (event.getLoggerName().equals(s)) {
                    return Filter.Result.DENY;
                }
            }
            for (String s : Config.messageFilters) {
                Message m = event.getMessage();
                if (m.toString().contains(s) || m.getFormattedMessage().contains(s)) {
                    return Filter.Result.DENY;
                }
            }
        }
        return null;
    }

    @Override
    public Result getOnMismatch() {
        return null;
    }

    @Override
    public Result getOnMatch() {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String msg, Object... params) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, Object msg, Throwable t) {
        return null;
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, Message msg, Throwable t) {
        return null;
    }

    public static void applyFilter() {
        ((Logger) LogManager.getRootLogger()).addFilter(new Log4jFilter());
    }
}
