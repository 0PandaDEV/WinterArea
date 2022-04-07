package ch.pandadev.utils;

import ch.pandadev.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class WorldAPI {

    public static void addWorld(String world, Player player){

        FileConfiguration config = Main.getInstance().getConfig();

        config.set(world + ".owner", player.getUniqueId().toString());
        Main.getInstance().saveConfig();
        WorldCreator wc = new WorldCreator(world);

        wc.environment(World.Environment.NORMAL);
        wc.type(WorldType.NORMAL);

        wc.createWorld();

    }

    public static void removeWorld(String world, Player player){

        FileConfiguration config = Main.getInstance().getConfig();

        String owner = config.getString(world + ".owner", player.getUniqueId().toString());


        if(owner.equals(player.getUniqueId().toString())){
            config.set(world + ".owner", player.getUniqueId().toString());
            Main.getInstance().saveConfig();
        }

    }

}