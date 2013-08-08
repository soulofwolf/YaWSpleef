package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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
public class PlayerDamage implements Listener {
    public PlayerDamage(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
    @EventHandler
    public void playerDamaged(EntityDamageByEntityEvent event){
        if (event.getEntity() instanceof Player){
            Player p = (Player)event.getEntity();
            if (YaWSpleef.playerArenas.containsKey(p.getName())){
                Arena a = YaWSpleef.spleefArenas.get(YaWSpleef.playerArenas.get(p.getName()));
                if (event.getDamager() instanceof Arrow){
                    event.setDamage(0);
                    Arrow arrow = (Arrow)event.getDamager();
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
