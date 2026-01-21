# Lognore
### Ignore spammy console logs in 1.7.10

I made this cuz I couldn't find anything that could filter based on the logger name with a log level threshold.

Config is self-explanatory, located at config/lognore.cfg
Default config below.

# Configuration file
Note: Strings in the arrays should be unquoted
```cfg
general {
    # Log4j loggers to filter [default: ]
    S:loggerFilters <
    >

    # Max filtered log level, valid values are ERROR, WARN, INFO, DEBUG. For example, setting to WARN, would filter WARN, INFO, and DEBUG. [default: WARN]
    S:maxFilteredLevel=WARN

    # Messages to filter (substring) [default: ]
    S:messageFilters <
    >
}
```
