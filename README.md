# Lognore
### Ignore spammy console logs in 1.7.10

[![build](https://github.com/CanadianBaconBoi/Lognore/actions/workflows/build-and-test.yml/badge.svg?branch=master)](https://github.com/CanadianBaconBoi/Lognore/actions/workflows/build-and-test.yml)
![Mod loader: Forge](https://img.shields.io/badge/Mod%20Loader-Forge-1976d2?logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAYCAYAAACbU/80AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAALySURBVEhLtZZPaBNBFMbzz42NtoII0aCiRQURVGIFEak3URFEEHqUCkVsPZSKoHjQiwjiQb1UFOlBUXoS0XjowYte1JutF6kKUtYIUQpN1k3zz9+bndos3TabNPng4817b+Z7Mzs7sxtoFKVSaV25XO6BD4vF4nodbi4QD+nmfxDbWqlUnsFfUIHYNZ12gUluI32R/Ed4Uof9g0EGPKVdBUS7nLIumMTbdT7BmLNwjHjOSSuklIAfMLhDN6V9Hx7XrvhrEJtyNOdBfBjzBP5RATcKcDSbzQa1zNJA7A7slTYrGmTwd/Z5tUoCcq+V7NL4DVP07Udjh23b/ooLGHSMwVPY/UJRw97V6QDuJYl54Af9RuBpijb2YqbT6RCr3YTIIQTHEEpiTVEndlj6ENuDW5RYNcj3KZHlAqGD8CrsolgHthv9HPYz+2hIH/y3qqobD5RAM0CxPgTfY3drfx/+NPaG9s+oklUgNm6a5oKj2zAQvI6uje0Xn/Yu2hNsUbJQKBj4k1JYI0/uOfGVavBykM/nIxSRfb7taKvVjUrOsqw425CQNrFeUu+wA7BTYvXC82jkcrlEKBTqjkajbcFg0JIQBfIcpQ+xWEy9AyBMcbEV+vzFrtAUTZXQmKsxrfu54DkBisXpLIVKTkT1s3kqVyKRiGyHraLzhTx1qtAGL6D5yHFrgAmcU8+d/YdWFUuwUQxpeRc8Z05neZPvwQEVqB+zcAKdT9ivLEhOz5hhGF9U1i8YdBS+QOgnnIW1ICfmFnfHzkwmU2tb/APRtbCTI/ZYF/KCfPmO6CGtAadgC0Xki+eFYd2tteDxtlMs7dR04bzuUhcauTblsxx1mi5s17Y14PYLs/q9rDTlLHgBLN6TIfps0EOaB4Tl0zwO/dwDM3CES0tuxZrwdVQQvIm57HgKb4i9ZGLfaK8Kh8MHsD0wLkkgN+RGbj7TcReH3wkkMfIzQrMyyXfilUpUgUe/mfgJmrLyGSb3lInNXdmLIBD4Bw72x5r0eQ99AAAAAElFTkSuQmCC)
[![Curseforge](https://cf.way2muchnoise.eu/1439411.svg)](https://www.curseforge.com/minecraft/mc-mods/lognore)

[Curseforge Page](https://www.curseforge.com/minecraft/mc-mods/lognore)

I made this cuz I couldn't find anything that could filter based on the logger name with a log level threshold.

Config is more or less self-explanatory, further config examples can be found on the CurseForge page.
Config file is located at config/lognore.cfg
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
