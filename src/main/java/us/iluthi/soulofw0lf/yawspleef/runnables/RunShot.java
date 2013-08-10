package us.iluthi.soulofw0lf.yawspleef.runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.scheduler.BukkitRunnable;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/8/13
 * Time: 12:50 PM
 */
public class RunShot {
    public static void multiShot(final String s, final int shots, final int timer){
        new BukkitRunnable(){
            int cD = timer +1;
            int shot = timer/shots;
            Player p = Bukkit.getPlayer(s);
            @Override
            public void run(){
                if (shot == 0){
                    Projectile fire = p.launchProjectile(Arrow.class);
                    fire.setVelocity(fire.getVelocity().multiply(4));
                    shot = timer/shots;
                }
                if (cD <= 0){
                    cancel();
                    return;
                }

                shot--;
                cD--;
            }
        }.runTaskTimer(YaWSpleef.plugin, 1, 1);
    }
}
