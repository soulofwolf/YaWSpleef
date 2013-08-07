package us.iluthi.soulofw0lf.yawspleef.runnables;

import org.bukkit.scheduler.BukkitRunnable;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:33 PM
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
public class ArenaCheck {

    public static void checkArenas(){
        new BukkitRunnable(){
            @Override
            public void run(){
                for (String key : YaWSpleef.spleefArenas.keySet()){
                    if (key == null){
                        continue;
                    }
                    if (YaWSpleef.mapQueues.containsKey(key)){
                        Arena a = YaWSpleef.spleefArenas.get(key);
                        if (a.isCounting() || a.isRunning()){
                            continue;
                        }
                        if (YaWSpleef.mapQueues.get(key).size() >= a.getMinPlayers()){
                            Countdown.arenaCountdown(key);
                        }
                    }
                }
            }
        }.runTaskTimer(YaWSpleef.plugin, 20, 60);
    }
}
