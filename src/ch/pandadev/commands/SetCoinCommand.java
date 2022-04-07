package ch.pandadev.commands;

import ch.pandadev.utils.CoinAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCoinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage("§b§lWinter Area §8» §6Du musst diesen Command als Spieler ausführen!");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 2){

            Player target = Bukkit.getPlayer(args[0]);

            if (target != null){

                int amount;

                try{
                    amount = Integer.parseInt(args[1]);
                }catch (NumberFormatException e){
                    player.sendMessage("§b§lWinter Area §8» §cDas ist eine ungültige Zahl");

                    return false;
                }

                CoinAPI.setCoins(target, amount);

                player.sendMessage("§b§lWinter Area §8» §7Coins von §a" + target.getName() + " §7wurden auf §6" + amount + "§7 gesetzt");

            }

        }

        return false;
    }
}
