package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:38 PM
 */
public class PlayerMove implements Listener{
    public PlayerMove(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
    @EventHandler
    public void playerMove(PlayerMoveEvent event){
        Player p = event.getPlayer();
        if (!YaWSpleef.playerArenas.containsKey(p.getName())){
             return;
        }
        if (YaWSpleef.onStart.contains(p.getName())){
            event.setCancelled(true);
            return;
        }
    }
}
