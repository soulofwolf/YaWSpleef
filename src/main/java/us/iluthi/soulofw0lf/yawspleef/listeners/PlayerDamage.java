package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.Gun;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/8/13
 * Time: 10:14 AM
 */
public class PlayerDamage implements Listener {
    public PlayerDamage(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
    @EventHandler (priority = EventPriority.HIGHEST)
    public void playerHit(EntityDamageEvent event){
        if (event.getEntity() instanceof Player){
            Player p = (Player)event.getEntity();
            if (YaWSpleef.playerArenas.containsKey(p.getName())){
                event.setDamage(0);
            }
        }
    }
    @EventHandler (priority = EventPriority.HIGHEST)
    public void playerDamaged(EntityDamageByEntityEvent event){
        if (event.getEntity() instanceof Player){
            Player p = (Player)event.getEntity();
            if (YaWSpleef.playerArenas.containsKey(p.getName())){
                event.setDamage(0);
                Arena a = YaWSpleef.spleefArenas.get(YaWSpleef.playerArenas.get(p.getName()));
                if (event.getDamager() instanceof Arrow){
                    Arrow arrow = (Arrow)event.getDamager();
                    ((CraftPlayer) p).getHandle().getDataWatcher().watch(9, (byte)0);
                    if (arrow.getShooter() instanceof Player){
                        Player shooter = (Player)arrow.getShooter();
                        if (YaWSpleef.playerShots.containsKey(shooter.getName())){
                            Gun g = YaWSpleef.guns.get(YaWSpleef.playerShots.get(shooter.getName()));
                            if (YaWSpleef.blindS.contains(shooter.getName())){
                                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, g.getBlindingShotDuration()*20, 1, true));
                                YaWSpleef.blindS.remove(shooter.getName());
                            }
                            if (YaWSpleef.slowS.contains(shooter.getName())){
                                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, g.getSlowDuration()*20, g.getSlowStr(), true));
                                YaWSpleef.slowS.remove(shooter.getName());
                            }
                            if (YaWSpleef.summonS.contains(shooter.getName())){
                                p.teleport(shooter.getLocation());
                                YaWSpleef.summonS.remove(shooter.getName());
                            }
                        }
                    }
                }
            }
        }
    }
}
