package net.cdnbcn.lognore.filter;

import net.cdnbcn.lognore.Config;

import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class JavaFilter implements Filter {

	@Override
	public boolean isLoggable(LogRecord event) {

        for (String s : Config.loggerFilters) {
            if (event.getLoggerName().equals(s)) {
                return false;
            }
        }
        for (String s : Config.messageFilters) {
            if (event.getMessage().contains(s)) {
                return false;
            }
        }
		return true;
	}

	public static void applyFilter() {
		Logger.getLogger("").setFilter(new JavaFilter());
	}

}
