package us.iluthi.soulofw0lf.yawspleef.runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/8/13
 * Time: 11:08 AM
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
