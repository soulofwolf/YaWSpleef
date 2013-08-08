package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.ParticleEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:38 PM
 */
public class ProjHit implements Listener{
    public ProjHit(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
    @EventHandler
    public void arrowHit(ProjectileHitEvent event){
        if (event.getEntity() instanceof Arrow){
            Arrow arrow = (Arrow)event.getEntity();
            if (arrow.getShooter() instanceof Player){
                Player shooter = (Player)arrow.getShooter();
                if (YaWSpleef.playerArenas.containsKey(shooter.getName())){
                    Arena a = YaWSpleef.spleefArenas.get(YaWSpleef.playerArenas.get(shooter.getName()));
                    Location loc = event.getEntity().getLocation();
                    Block b = loc.getBlock();
                    if (b == null || b.getType().equals(Material.AIR)){
                        return;
                    }
                    if (b.getType().equals(Material.TNT)){
                        a.getResetBlocks().add(b);
                        b.setType(Material.AIR);
                        ParticleEffect.fromId(22).play(loc, 15.0, 0f, 0f, 0f, 50, 50);
                    }
                    if (shooter.hasPermission(YaWSpleef.permissionSettings.get("Multi Blocks"))){
                        Location loc1 = b.getLocation();
                        Location loc2 = b.getLocation();
                        Location loc3 = b.getLocation();
                        Location loc4 = b.getLocation();
                        List<Location> locList = new ArrayList<>();
                        loc1.setX(loc1.getX()+1);
                        loc2.setX(loc2.getX()-1);
                        loc3.setZ(loc3.getZ() + 1);
                        loc4.setZ(loc4.getZ()-1);
                        locList.add(loc1);
                        locList.add(loc2);
                        locList.add(loc3);
                        locList.add(loc4);
                        for (Location key : locList){
                            Block bl = loc.getBlock();
                            if (bl == null || bl.getType().equals(Material.AIR)){
                                return;
                            }
                            if (bl.getType().equals(Material.TNT)){
                                a.getResetBlocks().add(bl);
                                bl.setType(Material.AIR);
                            }
                        }
                    }
                }
            }
        }
        if (event.getEntity() instanceof Snowball){
            Snowball snow = (Snowball)event.getEntity();
            if (snow.getShooter() instanceof Player){
                Player p = (Player)snow.getShooter();
                if (YaWSpleef.playerArenas.containsKey(p.getName())){
                    Arena a = YaWSpleef.spleefArenas.get(YaWSpleef.playerArenas.get(p.getName()));
                    for (String key : a.getPlayers()){
                        if (Bukkit.getPlayer(key) != null){
                            Player stun = Bukkit.getPlayer(key);
                            if (stun.getLocation().distance(event.getEntity().getLocation()) <= 5){
                                stun.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 2, true));
                            }
                        }
                    }
                }
            }
        }
    }
}
