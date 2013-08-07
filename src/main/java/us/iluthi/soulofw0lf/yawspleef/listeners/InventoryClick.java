package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;


/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:39 PM
 */
public class InventoryClick implements Listener{
    public InventoryClick(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
}
