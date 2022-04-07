package ch.pandadev.commands;

import ch.pandadev.utils.FileConfig;
import ch.pandadev.utils.LocationUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            return true;
        }

        Player player = (Player) sender;
        FileConfig spawns = new FileConfig("locaions.yml");
        if (label.equalsIgnoreCase("setspawn")){
			if (args.length != 0){
            	player.sendMessage("§b§lWinter Area §8» §cBitte benutze nur §6/setspawn§c!");
           		return true;
        	}
            if (player.hasPermission("testplugin.setspawn")){
                spawns.set("spawn", LocationUtils.log2Str(player.getLocation()));
                spawns.saveConfig();
                player.sendMessage("§b§lWinter Area §8» §aSpawn wurde gesetzt.");
            }else {
                player.sendMessage("§b§lWinter Area §8» §cDir Fehlen die Permissions dazu");
            }
            return true;
        }

        if (spawns.contains("spawn")){
			if (args.length != 0){
            	player.sendMessage("§b§lWinter Area §8» §cBitte benutze nur §6/setspawn§c!");
            	return true;
        	}
            LocationUtils.teleport(player, LocationUtils.str2log(spawns.getString("spawn")));
            player.sendMessage("§b§lWinter Area §8» §7Du wurdest zum spawn teleportiert");
        }else {
            player.sendMessage("§b§lWinter Area §8» §cEs wurde noch kein Spawn gesetzt");
        }

        return true;
    }
}
