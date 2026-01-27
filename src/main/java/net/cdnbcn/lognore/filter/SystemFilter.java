package net.cdnbcn.lognore.filter;

import java.io.OutputStream;
import java.io.PrintStream;

import net.cdnbcn.lognore.Config;

public class SystemFilter extends PrintStream {

    public SystemFilter(OutputStream out) {
        super(out, true);
    }

    @Override
    public void println(String s) {
        if (!shouldFilter(s)) {
            super.println(s);
        }
    }

    private boolean shouldFilter(String s) {
        for (String filter : Config.messageFilters) {
            if (s.contains(filter)) {
                return true;
            }
        }
        return false;
    }

    public static void applyFilter() {
        System.setOut(new SystemFilter(System.out));
    }

}
