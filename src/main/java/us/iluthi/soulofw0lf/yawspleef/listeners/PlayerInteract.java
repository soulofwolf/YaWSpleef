package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.Gun;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.loaders.InventoryLoader;
import us.iluthi.soulofw0lf.yawspleef.runnables.CDRun;
import us.iluthi.soulofw0lf.yawspleef.runnables.RunShot;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;

import java.util.ArrayList;
import java.util.List;

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
        if (!YaWSpleef.playerQue.contains(p.getName()) && !YaWSpleef.playerArenas.containsKey(p.getName())){
            Block b = event.getClickedBlock();
            if (b == null || b.getType().equals(Material.AIR)){
                return;
            }
            if (b.getState() instanceof Sign){
                Sign sign = (Sign)b.getState();
                for (String key : YaWSpleef.spleefArenas.keySet()){
                    Arena a = YaWSpleef.spleefArenas.get(key);
                    if (sign.equals(a.getStartSign())){
                        YaWSpleef.playerQue.add(p.getName());
                        if (YaWSpleef.mapQueues.containsKey(a.getName())){
                            YaWSpleef.mapQueues.get(a.getName()).add(p.getName());
                        } else {
                            List<String> play = new ArrayList<>();
                            play.add(p.getName());
                            YaWSpleef.mapQueues.put(a.getName(), play);
                        }
                        a.getPlayers().add(p.getName());
                        p.teleport(a.getStartLocs().get(a.getPlayers().size() - 1));
                        p.setGameMode(GameMode.ADVENTURE);
                        YaWSpleef.playerInventory.put(p.getName(), p.getInventory().getContents());
                        p.getInventory().clear();
                        InventoryLoader.gameInv(p);
                    }
                }
            }

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
            if (YaWSpleef.playerShots.containsKey(p.getName())){
                YaWSpleef.playerShots.remove(p.getName());
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
                RunShot.multiShot(p.getName(), 2, 20);
            }
            if (g.isInvisShot()){
                if (g.getInvisShotCD() > cD){
                    cD = g.getInvisShotCD();
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (g.getInvisShotDuration() * 20), 1));
                p.launchProjectile(Arrow.class);
            }
            if (g.isRapidShot()){
                if (g.getRapidShotCd() > cD){
                    cD = g.getRapidShotCd();
                }
                RunShot.multiShot(p.getName(), g.getRapidShotShots(), (int)(g.getRapidShotTime() *20));
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
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (g.getSpeedBoostDuration() * 20), g.getSpeedBoostStrength()));
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
                RunShot.multiShot(p.getName(), 2, 20);
            }
            YaWSpleef.playerShots.put(p.getName(), g.getName());
            YaWSpleef.specialShotCD.add(p.getName());
            CDRun.specialCD(p.getName(), (int)(cD*20));
        }
    }
}
