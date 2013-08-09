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
 * <p/>
 * This file is part of the Rpg Suite Created by Soulofw0lf and Linksy.
 * <p/>
 * The Rpg Suite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * The Rpg Suite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with The Rpg Suite Plugin you have downloaded.  If not, see <http://www.gnu.org/licenses/>.
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
