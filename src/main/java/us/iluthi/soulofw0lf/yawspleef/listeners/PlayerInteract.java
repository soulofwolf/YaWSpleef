package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import us.iluthi.soulofw0lf.yawspleef.Gun;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.loaders.InventoryLoader;
import us.iluthi.soulofw0lf.yawspleef.runnables.CDRun;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:39 PM
 */
public class PlayerInteract implements Listener{
    public PlayerInteract(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if (YaWSpleef.onStart.contains(p.getName())){
            event.setCancelled(true);
            return;
        }
        ItemStack iS = p.getItemInHand();
        if (iS == null || iS.getType().equals(Material.AIR)){
            return;
        }
        ItemMeta iM = iS.getItemMeta();
        if (iM == null){
            return;
        }
        if (iM.getDisplayName() == null){
            return;
        }
        if (iM.getDisplayName().equals(Chat.color(YaWSpleef.localeSettings.get("Shop Item Name")))){
            p.openInventory(InventoryLoader.shopInv(p));
            return;
        }
        if (!YaWSpleef.playerArenas.containsKey(p.getName())){
            return;
        }
        String name = "";
        for (String key : YaWSpleef.guns.keySet()){
            if (Chat.color(key).equals(iM.getDisplayName())){
                name = key;
            }
        }
        if (name.isEmpty()){
            return;
        }
        Gun g = YaWSpleef.guns.get(name);
        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            if (YaWSpleef.CD.contains(p.getName())){
                return;
            }
            if (g.getProjectile().equalsIgnoreCase("Arrow")){
                p.launchProjectile(Arrow.class);
            }
            if (g.getProjectile().equalsIgnoreCase("Snowball")){
                p.launchProjectile(Snowball.class);
            }
            if (g.getProjectile().equalsIgnoreCase("Fireball")){
                p.launchProjectile(Fireball.class);
            }
            YaWSpleef.CD.add(p.getName());
            CDRun.baseCD(p.getName(), (int)(g.getCooldown()*20));
        }
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if (YaWSpleef.specialShotCD.contains(p.getName())){
                return;
            }
            double cD = 0;
            if (g.isBlindGrenade()){
                if (g.getBlindGrenadeCD() > cD){
                    cD = g.getBlindGrenadeCD();
                }
                YaWSpleef.blindG.add(p.getName());
                p.launchProjectile(Fireball.class);
            }
            if (g.isBlindingShot()){
                if (g.getBlindingShotCD() > cD){
                    cD = g.getBlindingShotCD();
                }
                YaWSpleef.blindS.add(p.getName());
                p.launchProjectile(Arrow.class);
            }
            if (g.isCrossShot()){
                if (g.getCrossCD() > cD){
                    cD = g.getCrossCD();
                }
                YaWSpleef.crossS.add(p.getName());
                p.launchProjectile(Arrow.class);
            }
            if (g.isDoubleShot()){
                if (g.getDoubleShotCD() > cD){
                    cD = g.getDoubleShotCD();
                }
                p.launchProjectile(Arrow.class);
                p.launchProjectile(Arrow.class);
            }
            if (g.isInvisShot()){
                if (g.getInvisShotCD() > cD){
                    cD = g.getInvisShotCD();
                }

                p.launchProjectile(Arrow.class);
            }
            if (g.isRapidShot()){
                if (g.getRapidShotCd() > cD){
                    cD = g.getRapidShotCd();
                }

            }
            if (g.isSlowGrenade()){
                if (g.getSlowGrenadeCD() > cD){
                    cD = g.getSlowGrenadeCD();
                }
                YaWSpleef.slowG.add(p.getName());
                p.launchProjectile(Snowball.class);
            }
            if (g.isSlowShot()){
                if (g.getSlowCD() > cD){
                    cD = g.getSlowCD();
                }

                YaWSpleef.slowS.add(p.getName());
                p.launchProjectile(Arrow.class);
            }
            if (g.isSpeedBoost()){
                if (g.getSpeedBoostCD() > cD){
                    cD = g.getSpeedBoostCD();
                }
                p.launchProjectile(Arrow.class);
            }
            if (g.isSpeedGrenade()){
                if (g.getSlowGrenadeCD() > cD){
                    cD = g.getSlowGrenadeCD();
                }
                YaWSpleef.speedG.add(p.getName());
                p.launchProjectile(Fireball.class);
            }
            if (g.isSummonShot()){
                if (g.getSummonshotCD() > cD){
                    cD = g.getSummonshotCD();
                }
                YaWSpleef.summonS.add(p.getName());
                p.launchProjectile(Snowball.class);
            }
            if (g.isTeleportShot()){
                if (g.getTeleportShotCD() > cD){
                    cD = g.getTeleportShotCD();
                }
                p.launchProjectile(EnderPearl.class);
            }
            if (g.isTripleShot()){
                if (g.getTeleportShotCD() > cD){
                    cD = g.getTeleportShotCD();
                }
                p.launchProjectile(Arrow.class);
                p.launchProjectile(Arrow.class);
                p.launchProjectile(Arrow.class);
            }

            YaWSpleef.specialShotCD.add(p.getName());
            CDRun.specialCD(p.getName(), (int)(cD*20));
        }
    }
}
