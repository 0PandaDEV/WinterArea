package ch.pandadev;

import ch.pandadev.commands.*;
import ch.pandadev.listeners.InventoryListener;
import ch.pandadev.listeners.JoinListener;
import ch.pandadev.listeners.QuitListener;
import ch.pandadev.scoreboard.TestScoreboard;
import ch.pandadev.tablist.TablistManager;
import ch.pandadev.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;

    private TablistManager tablistManager;
    private static Config cfg;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        cfg = new Config("warps.yml", getDataFolder());
        Bukkit.getConsoleSender().sendMessage("§6Wurde geladen by PandaDΞV");
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);
        manager.registerEvents(new InventoryListener(), this);
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("speed").setExecutor(new SpeedCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("lobby").setExecutor(new SpawnCommand());
        getCommand("hub").setExecutor(new SpawnCommand());
        getCommand("warp").setExecutor(new WarpCommand());
		getCommand("gamemode").setExecutor(new GamemodeCommand());
		getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("setcoins").setExecutor(new SetCoinCommand());
        getCommand("coins").setExecutor(new CoinCommand());
        getCommand("world").setExecutor(new WorldCommand());


        tablistManager = new TablistManager();

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.isOp()){
                player.setGameMode(GameMode.CREATIVE);
            }else {
                player.setGameMode(GameMode.ADVENTURE);
            }
            new TestScoreboard(player);
            Main.getInstance().getTablistManager().setPlayerList(player);
            Main.getInstance().getTablistManager().setAllPlayerTeams();
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
                public void run() {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                }
            }, 0, 20);
        }

    }
    public static Main getInstance() {
        return instance;
    }

    public TablistManager getTablistManager(){
        return tablistManager;
    }

    public static Config getCfg() {
        return cfg;
    }
}
