package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.Board;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;
import us.iluthi.soulofw0lf.yawspleef.utility.ItemUpdate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:38 PM
 */
public class PlayerJoin implements Listener{
    public PlayerJoin(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        Board.update(p);
        ItemUpdate.coin(YaWSpleef.shopItem, p);
    }
    @EventHandler
    public void playerDrop(PlayerDropItemEvent event){
        event.setCancelled(true);
    }
}
