package us.iluthi.soulofw0lf.yawspleef.utility;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/8/13
 * Time: 7:28 PM
 */
public class Board {
    public static void update(final Player p){
        new BukkitRunnable(){
            @Override
            public void run(){
                if (!YaWSpleef.playerBoards.containsKey(p.getName())){
                    Scoreboard board = YaWSpleef.manager.getNewScoreboard();
                    Objective obj = board.registerNewObjective("Coins", "dummy");
                    Team team = board.registerNewTeam(p.getName());
                    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                    obj.setDisplayName(Chat.color("&2Player Coins"));
                    Score score = obj.getScore(Bukkit.getOfflinePlayer(Chat.color("&eCoins:")));
                    score.setScore((int)YaWSpleef.econ.getBalance(p.getName()));
                    p.setScoreboard(board);
                    YaWSpleef.playerBoards.put(p.getName(), board);
                    } else {
                    Scoreboard board = YaWSpleef.playerBoards.get(p.getName());
                    Objective obj = board.getObjective(DisplaySlot.SIDEBAR);
                    Score score = obj.getScore(Bukkit.getOfflinePlayer(Chat.color("&eCoins:")));
                    score.setScore((int)YaWSpleef.econ.getBalance(p.getName()));
                    p.setScoreboard(board);
                }
            }
        }.runTaskLater(YaWSpleef.plugin, 5);
    }
}
