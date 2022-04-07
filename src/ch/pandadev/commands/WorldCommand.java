package ch.pandadev.commands;

import ch.pandadev.Main;
import ch.pandadev.utils.WorldAPI;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class WorldCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage("§b§lWinter Area §8» §6Du musst diesen Command als Spieler ausführen!");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 1){
            FileConfiguration config = Main.getInstance().getConfig();

            config.set(args[1] + ".owner", player.getUniqueId().toString());
            Main.getInstance().saveConfig();
            WorldCreator wc = new WorldCreator(args[1]);
            wc.environment(World.Environment.NORMAL);
            wc.type(WorldType.NORMAL);
            wc.createWorld();

            player.sendMessage("§b§lWinter Area §8» §7World wurde unter dem namen §6" + args[1] + " §7erstellt!");
            Location loc = Bukkit.getWorld(args[1]).getSpawnLocation();
            player.teleport(loc);
        }

        return false;
    }
}
