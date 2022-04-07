package ch.pandadev.tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistManager {

    public void setPlayerList(Player player){
        player.setPlayerListHeaderFooter("\n§7         §b§lWinter Area §8» §a" + player.getWorld().getName() + "        \n§6Welcome to Winter Area\n", "\n§7Support §8» §bdiscord.gg/28SntcpcHU\n\n§8「 §7made by §5PandaDEV\n§7and §bEinfach_Noan §8」\n");
    }

    public void setAllPlayerTeams(){
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeams);
    }

    public void setPlayerTeams(Player player){
        Scoreboard scoreboard = player.getScoreboard();

        Team players = scoreboard.getTeam("010players");

        if (players == null){
            players = scoreboard.registerNewTeam("010players");
        }

        Team operators = scoreboard.getTeam("001admins");

        if (operators == null){
            operators = scoreboard.registerNewTeam("001admins");
        }

        players.setPrefix("§7Spieler | ");
        players.setColor(ChatColor.GRAY);

        operators.setPrefix("§cAdmin §7| ");
        operators.setColor(ChatColor.RED);

        for (Player target : Bukkit.getOnlinePlayers()){
            if (target.isOp()){
                operators.addEntry(target.getName());
                continue;
            }

            players.addEntry(target.getName());
        }

    }

}
