package ch.pandadev.listeners;

import ch.pandadev.utils.FileConfig;
import ch.pandadev.utils.LocationUtils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    FileConfig spawns = new FileConfig("locaions.yml");
    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        if (event.getCurrentItem() == null) return;
        if (event.getView().getTitle() == "§bMenu Test"){
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().hasLocalizedName()){
                switch (event.getCurrentItem().getItemMeta().getLocalizedName()){
                    case "survival":
                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        break;
                    case "creative":
                        player.setGameMode(GameMode.CREATIVE);
                        player.closeInventory();
                        break;
                    case "spawn":
                        LocationUtils.teleport(player, LocationUtils.str2log(spawns.getString("spawn")));
                        player.closeInventory();
                        break;
                }
            }
        }
    }
}
