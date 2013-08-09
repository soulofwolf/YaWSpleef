package us.iluthi.soulofw0lf.yawspleef.loaders;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import us.iluthi.soulofw0lf.yawspleef.listeners.*;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:39 PM
 */
public class RegisterEvents {
    public static void regAll(Plugin plug){
        new InventoryClick(plug);
        new PlayerInteract(plug);
        new PlayerJoin(plug);
        new PlayerLeave(plug);
        new PlayerMove(plug);
        new ProjHit(plug);
        new Commands(plug);
    }
}
