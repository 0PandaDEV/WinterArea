package ch.pandadev.utils;

import ch.pandadev.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CoinAPI {

    public static int getCoins(Player player){

        FileConfiguration config = Main.getInstance().getConfig();

        int coins = config.getInt("Coins." + player.getName());

        return coins;
    }

    public static void addCoins(Player player, int amount){

        FileConfiguration config = Main.getInstance().getConfig();
        int coins = config.getInt("Coins." + player.getName());

        coins += amount;

        config.set("Coins." + player.getName(), coins);
        Main.getInstance().saveConfig();

    }

    public static void removeCoins(Player player, int amount){

        FileConfiguration config = Main.getInstance().getConfig();
        int coins = config.getInt("Coins." + player.getName());

        coins -= amount;

        config.set("Coins." + player.getName(), coins);
        Main.getInstance().saveConfig();

    }

    public static void setCoins(Player player, int amount){

        FileConfiguration config = Main.getInstance().getConfig();
        int coins = config.getInt("Coins." + player.getName());

        coins = amount;

        config.set("Coins." + player.getName(), coins);
        Main.getInstance().saveConfig();

    }



}
