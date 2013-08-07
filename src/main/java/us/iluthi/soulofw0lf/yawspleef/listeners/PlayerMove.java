package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:38 PM
 */
public class PlayerMove implements Listener{
    public PlayerMove(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
}
