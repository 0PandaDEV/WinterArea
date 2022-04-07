package ch.pandadev.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("§b§lWinter Area §8» §6Du musst diesen Command als Spieler ausführen!");
            return false;
        }

        Player player = (Player) sender;

		if (args.length == 1){
            if (args[0].equalsIgnoreCase("1")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("§b§lWinter Area §8» §7Du hast dich in den Spielmodus §aCreative §7gesetzt");
            }
            if (args[0].equalsIgnoreCase("0")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("§b§lWinter Area §8» §7Du hast dich in den Spielmodus §aSurvival §7gesetzt");
            }
            if (args[0].equalsIgnoreCase("2")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("§b§lWinter Area §8» §7Du hast dich in den Spielmodus §aAdventure §7gesetzt");
            }
            if (args[0].equalsIgnoreCase("3")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("§b§lWinter Area §8» §7Du hast dich in den Spielmodus §aSpectator §7gesetzt");
            }
		}else{
			player.sendMessage("§b§lWinter Area §8» §c/gamemode <0|1|2|3>");
		}
        return true;
    }
}