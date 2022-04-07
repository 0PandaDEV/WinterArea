package ch.pandadev.scoreboard;

import ch.pandadev.utils.CoinAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import ch.pandadev.Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestScoreboard extends ScoreboardBuilder {

    private int time;
    private int online;
    private int world;
    private int coins;

    public TestScoreboard(Player player) {
        super(player, "    §b§lWinter Area      ");

        run();
        setScore("§b" + player.getWorld().getName(), 1);
    }

    @Override
    public void createScoreboard() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        setScore("§6", 9);
        setScore("§6Coins:", 8);
        setScore("§b" + CoinAPI.getCoins(player), 7);
        setScore("§6", 6);
        setScore("§6Time:", 5);
        setScore("§b" + format.format(now), 4);
        setScore("§6", 3);
        setScore("§6Server:", 2);
        setScore("§6", 1);
        setScore("§b" + Bukkit.getOnlinePlayers().size() + "§8/§720", 0);
    }

    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Date now = new Date();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

                switch (time) {
                    case 0:
                        setScore("§b" + format.format(now), 4);
                        break;
                    case 1:
                        setScore("§b" + format.format(now), 4);
                        break;
                }

                switch (online) {
                    case 0:
                        setScore("§b" + Bukkit.getOnlinePlayers().size() + "§8/§720", 0);
                        break;
                    case 1:
                        setScore("§b" + Bukkit.getOnlinePlayers().size() + "§8/§720", 0);
                        break;
                }

                switch (world) {
                    case 0:
                        setScore("§b" + player.getWorld().getName(), 1);
                        break;
                    case 1:
                        setScore("§b" + player.getWorld().getName(), 1);
                        break;
                }

                switch (coins) {
                    case 0:
                        setScore("§b" + CoinAPI.getCoins(player), 7);
                        break;
                    case 1:
                        setScore("§b" + CoinAPI.getCoins(player), 7);
                        break;
                }

                time++;
                online++;
                world++;
                coins++;

                if(time >= 1) {
                    time = 0;
                }

                if(online >= 1) {
                    online = 0;
                }

                if(world >= 1) {
                    world = 0;
                }

                if(coins >= 1) {
                    coins = 0;
                }

            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }
}
