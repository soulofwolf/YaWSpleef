package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.arenaevents.RemovePlayer;
import us.iluthi.soulofw0lf.yawspleef.utility.SignHandler;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:38 PM
 */
public class PlayerLeave implements Listener{
    public PlayerLeave(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);

    }
    @EventHandler
    public void playerLeave(PlayerQuitEvent event){
        Player p = event.getPlayer();
        if (YaWSpleef.playerArenas.containsKey(p.getName())){
            RemovePlayer.fellOut(YaWSpleef.spleefArenas.get(YaWSpleef.playerArenas.get(p.getName())), p);
        }
        for (String key : YaWSpleef.mapQueues.keySet()){
            if (YaWSpleef.mapQueues.get(key).contains(p.getName())){
                p.teleport(YaWSpleef.loc);
                p.getInventory().clear();
                if (YaWSpleef.playerInventory.containsKey(p.getName())){
                    p.getInventory().setContents(YaWSpleef.playerInventory.get(p.getName()));
                    YaWSpleef.playerInventory.remove(p.getName());
                }
                Arena a = YaWSpleef.spleefArenas.get(key);
                SignHandler.updateSigns(a);
                YaWSpleef.mapQueues.get(key).remove(p.getName());
            }
        }
        p.teleport(YaWSpleef.loc);
    }
    @EventHandler
    public void playerBoot(PlayerKickEvent event){
        Player p = event.getPlayer();
        if (YaWSpleef.playerArenas.containsKey(p.getName())){
            RemovePlayer.fellOut(YaWSpleef.spleefArenas.get(YaWSpleef.playerArenas.get(p.getName())), p);
        }
        for (String key : YaWSpleef.mapQueues.keySet()){
            if (YaWSpleef.mapQueues.get(key).contains(p.getName())){
                p.teleport(YaWSpleef.loc);
                p.getInventory().clear();
                if (YaWSpleef.playerInventory.containsKey(p.getName())){
                    p.getInventory().setContents(YaWSpleef.playerInventory.get(p.getName()));
                    YaWSpleef.playerInventory.remove(p.getName());
                }
                Arena a = YaWSpleef.spleefArenas.get(key);
                SignHandler.updateSigns(a);
                YaWSpleef.mapQueues.get(key).remove(p.getName());
            }
        }
        p.teleport(YaWSpleef.loc);
    }
}
