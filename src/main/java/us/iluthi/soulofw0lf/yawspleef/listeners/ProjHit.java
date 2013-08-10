package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.Gun;
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
                    World world = arrow.getWorld();
                    BlockIterator bi = new BlockIterator(world, arrow.getLocation().toVector(), arrow.getVelocity().normalize(), 0, 4);
                    Block b = null;

                    while(bi.hasNext())
                    {
                        b = bi.next();
                        if(b.getTypeId()!=0) //Grass/etc should be added probably since arrows doesn't collide with them
                        {
                            break;
                        }
                    }
                    if (b == null){
                        return;
                    }
                    event.getEntity().remove();
                    if (b.getType().equals(Material.TNT)){
                        a.getResetBlocks().add(b);
                        b.setType(Material.AIR);
                        ParticleEffect.fromId(22).play(loc, 15.0, 0f, 0f, 0f, 0.2f, 50);
                        loc.setY(loc.getY() + 1);
                        ParticleEffect.fromId(16).play(loc, 15.0, 0f, 0f, 0f, 0.2f, 50);
                        if (YaWSpleef.crossS.contains(shooter.getName())){
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
                                Block bl = key.getBlock();
                                if (bl == null || bl.getType().equals(Material.AIR)){
                                    return;
                                }
                                if (bl.getType().equals(Material.TNT)){
                                    a.getResetBlocks().add(bl);
                                    bl.setType(Material.AIR);
                                }
                            }
                            YaWSpleef.crossS.remove(shooter.getName());
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
                    if (YaWSpleef.playerShots.containsKey(p.getName())){
                        Gun g = YaWSpleef.guns.get(YaWSpleef.playerShots.get(p.getName()));
                        if (YaWSpleef.slowG.contains(p.getName())){
                            for (String key : a.getPlayers()){
                                if (Bukkit.getPlayer(key) != null){
                                    Player stun = Bukkit.getPlayer(key);
                                    if (stun.getLocation().distance(event.getEntity().getLocation()) <= g.getSlowGrenadeRange()){
                                        stun.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, g.getSlowGrenadeDuration() *20, g.getSlowGrenadeStrength(), true));
                                    }
                                }
                            }
                            YaWSpleef.slowG.remove(p.getName());
                        }
                    }
                }
            }
        }
        if (event.getEntity() instanceof Fireball){
            Fireball fb = (Fireball)event.getEntity();
            if (fb.getShooter() instanceof Player){
                Player p = (Player)fb.getShooter();
                if (YaWSpleef.playerArenas.containsKey(p.getName())){
                    Arena a = YaWSpleef.spleefArenas.get(YaWSpleef.playerArenas.get(p.getName()));
                    if (YaWSpleef.playerShots.containsKey(p.getName())){
                        Gun g = YaWSpleef.guns.get(YaWSpleef.playerShots.get(p.getName()));
                        if (YaWSpleef.blindG.contains(p.getName())){
                            for (String key : a.getPlayers()){
                                if (Bukkit.getPlayer(key) != null){
                                    Player stun = Bukkit.getPlayer(key);
                                    if (stun.getLocation().distance(event.getEntity().getLocation()) <= g.getBlindGrenadeRange()){
                                        stun.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, g.getBlindGrenadeDuration() *20, g.getBlindGrenadeStrength(), true));
                                    }
                                }
                            }
                            YaWSpleef.blindG.remove(p.getName());
                        }
                        if (YaWSpleef.speedG.contains(p.getName())){
                            for (String key : a.getPlayers()){
                                if (Bukkit.getPlayer(key) != null){
                                    Player stun = Bukkit.getPlayer(key);
                                    if (stun.getLocation().distance(event.getEntity().getLocation()) <= g.getSpeedGrenadeRange()){
                                        stun.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, g.getSpeedGrenadeDuration() *20, g.getSpeedGrenadeStrength(), true));
                                    }
                                }
                            }
                            YaWSpleef.speedG.remove(p.getName());
                        }
                    }
                }
            }
        }
    }
}
