package ch.pandadev.commands;

import ch.pandadev.utils.CoinAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage("§b§lWinter Area §8» §6Du musst diesen Command als Spieler ausführen!");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0){

            player.sendMessage("§b§lWinter Area §8» §7Your Coins: §6" + CoinAPI.getCoins(player));
            return true;

        }else if ((args.length == 1) & (player.isOp())){

            Player target = Bukkit.getPlayer(args[0]);

            if (target != null){

                player.sendMessage("§b§lWinter Area §8» §7Coins von §a" + target.getName() + "§7: §6" + CoinAPI.getCoins(target));
                return true;

            }
        }

        return false;
    }
}
