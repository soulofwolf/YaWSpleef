package us.iluthi.soulofw0lf.yawspleef.runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/8/13
 * Time: 11:08 AM
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
public class CDRun {
    public static void baseCD(final String s, final int timer){
        new BukkitRunnable(){
            @Override
            public void run(){
                YaWSpleef.CD.remove(s);
            }
        }.runTaskLater(YaWSpleef.plugin, timer);
    }
    public static void specialCD(final String s, final int timer){
        new BukkitRunnable(){
            float f = 1f/timer;
            int cD = timer + 1;
            Player p = Bukkit.getPlayer(s);
            @Override
            public void run(){
                if (cD == timer + 1){
                    p.setExp(0f);
                }
                if (cD <= 0){
                    YaWSpleef.specialShotCD.remove(s);
                    p.setExp(0f);
                    cancel();
                    return;
                }
                cD--;
                p.setExp(p.getExp() + f);
            }
        }.runTaskTimer(YaWSpleef.plugin, 1, 1);
    }
}
