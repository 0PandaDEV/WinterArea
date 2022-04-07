package ch.pandadev.warp;

import ch.pandadev.Main;
import org.bukkit.Location;

public class WarpManager {

    public static Location getWarp(String name){
        return Main.getCfg().getConfiguration().getLocation(name);
    }

    public static void createWarp(String name, Location location){
        Main.getCfg().set(name, location);
        Main.getCfg().save();
    }
    public static void deleteWarp(String name){
        Main.getCfg().set(name, null);
        Main.getCfg().save();
    }
}
