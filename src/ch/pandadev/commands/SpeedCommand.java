package ch.pandadev.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§b§lWinter Area §8» §6Du musst diesen Command als Spieler ausführen!");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§b§lWinter Area §8» §cBitte benutze nur §6/speed [value]§c!");
            return false;
        }

        if (args.length < 1) {
            player.sendMessage("§b§lWinter Area §8» §cBitte benutze /speed <1 - 10>");
            return false;
        }

        Integer.parseInt(args[1]);

        float x = Integer.valueOf(args[1]) / 10;

        if (player.isFlying() == true) {
            player.setFlySpeed(x);
            return true;
        } else {
            player.setWalkSpeed(x);
            return true;
        }
    }
}

