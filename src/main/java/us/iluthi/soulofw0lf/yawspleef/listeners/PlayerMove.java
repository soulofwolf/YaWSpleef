package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.arenaevents.RemovePlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:38 PM
 */
public class PlayerMove implements Listener{
    public PlayerMove(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
    private List<String> checking = new ArrayList<>();
    @EventHandler
    public void playerMove(PlayerMoveEvent event){
        Player p = event.getPlayer();

        if (YaWSpleef.onStart.contains(p.getName())){
            if (checking.contains(p.getName())){
                return;
            }
            checking.add(p.getName());
            final Location loc = p.getLocation();
            final String name = p.getName();
            new BukkitRunnable(){
                @Override
                public void run(){
                    if ((int)Bukkit.getPlayer(name).getLocation().getX() != (int)loc.getX() || (int)Bukkit.getPlayer(name).getLocation().getZ() != (int)loc.getZ()){
                        Bukkit.getPlayer(name).teleport(loc);
                    }
                    checking.remove(name);
                }
            }.runTaskLater(YaWSpleef.plugin, 10);
            return;
        }
        if (!YaWSpleef.playerArenas.containsKey(p.getName())){
            return;
        }
        Arena a = YaWSpleef.spleefArenas.get(YaWSpleef.playerArenas.get(p.getName()));
        if (p.getLocation().getY() <= a.getArenaY() - 1){
            RemovePlayer.fellOut(a, p);
        }
    }
}
