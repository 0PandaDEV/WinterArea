package ch.pandadev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§b§lWinter Area §8» §6Du musst diesen Command als Spieler ausführen!");
            return false;
        }

        Player player = (Player) sender;

        if (player.getHealth() >= 20){
            player.sendMessage("§b§lWinter Area §8» §7Du bist bereits Geheilt!");
            return true;
        }

        if (args.length != 0){
            player.sendMessage("§b§lWinter Area §8» §cBitte benutze nur §6/heal§c!");
            return true;
        }

        player.setHealth(20);
        player.setFoodLevel(20);
        player.sendMessage("§b§lWinter Area §8» §7Du wurdest geheilt");
        return true;
    }
}
