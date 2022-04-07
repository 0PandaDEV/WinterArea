package ch.pandadev.listeners;

import ch.pandadev.Main;
import ch.pandadev.scoreboard.TestScoreboard;
import ch.pandadev.utils.FileConfig;
import ch.pandadev.utils.ItemBuilder;
import ch.pandadev.utils.LocationUtils;
import ch.pandadev.warp.WarpManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().getInventory().clear();
        Player player = event.getPlayer();
        FileConfig spawns = new FileConfig("locaions.yml");

        event.setJoinMessage("§a0 §8» §7" + player.getName() + " joined the Game");

        LocationUtils.teleport(player, LocationUtils.str2log(spawns.getString("spawn")));
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


        ItemStack i = new ItemStack(Material.COMPASS);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName("§b§lNavigator");
        i.setItemMeta(im);
        event.getPlayer().getInventory().setItem(4, i);
    }
    @EventHandler
    public void onInterract(PlayerInteractEvent e){
        HashMap<Integer, ItemStack> integerItemStackHashMap = new HashMap<>();

        integerItemStackHashMap.put(12, new ItemBuilder(Material.NETHER_STAR).setDisplayname("§b§lSpawn").setLocalizedName("spawn").build());
        integerItemStackHashMap.put(14, new ItemBuilder(Material.SNOW_BLOCK).setDisplayname("§b§lWinter Map").setLocalizedName("wm").build());
        if (e.getItem() != null){
            if (e.getItem().getItemMeta().getDisplayName().equals("§b§lNavigator")){
                Inventory i = Bukkit.createInventory(null, 3*9, "§b§lNavigator");
                for (Map.Entry<Integer, ItemStack> integerItemStackEntry : integerItemStackHashMap.entrySet()) {
                    i.setItem(integerItemStackEntry.getKey(), integerItemStackEntry.getValue());
                }
                e.getPlayer().openInventory(i);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if (e.getCurrentItem() == null){
            return;
        }
        if (e.getView().getTitle().equals("§b§lNavigator")){
            e.setCancelled(true);
            if (WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()) != null){
                e.getWhoClicked().teleport(WarpManager.getWarp(e.getCurrentItem().getItemMeta().getLocalizedName()));
            }
        }
    }
}