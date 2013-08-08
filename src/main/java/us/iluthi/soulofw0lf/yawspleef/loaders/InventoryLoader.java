package us.iluthi.soulofw0lf.yawspleef.loaders;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:40 PM
 */
public class InventoryLoader {
    public static void gameInv(Player p){
        for (String key : YaWSpleef.weaponPerms.keySet()){
            if (p.hasPermission(key)){
                p.getInventory().addItem(YaWSpleef.weaponPerms.get(key));
            }
        }
    }
    public static Inventory shopInv(Player p){
        Inventory inv = Bukkit.createInventory(null, 45, Chat.color(YaWSpleef.localeSettings.get("Shop Name")));
        for (String key : YaWSpleef.weaponPerms.keySet()){
            if (!p.hasPermission(key)){
                inv.addItem(YaWSpleef.weaponPerms.get(key));
            }
        }
        return inv;
    }
}
