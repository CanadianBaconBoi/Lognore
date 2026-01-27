package net.cdnbcn.lognore;

import net.cdnbcn.lognore.filter.JavaFilter;
import net.cdnbcn.lognore.filter.Log4jFilter;
import net.cdnbcn.lognore.filter.SystemFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = net.cdnbcn.lognore.LognoreMod.MODID, version = Tags.VERSION, name = "Lognore", acceptedMinecraftVersions = "[1.7.10]", acceptableRemoteVersions = "*")
public class LognoreMod {

    public static final String MODID = "lognore";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        LOG.info("Filtering messages:");
        for (String message: Config.messageFilters) {
            LOG.info(message);
        }
        LOG.info("Filtering loggers:");
        for (String loggerName : Config.loggerFilters) {
            LOG.info(loggerName);
        }

        JavaFilter.applyFilter();
        Log4jFilter.applyFilter();
        SystemFilter.applyFilter();
    }
}
