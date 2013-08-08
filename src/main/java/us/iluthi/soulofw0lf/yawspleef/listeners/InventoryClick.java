package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import us.iluthi.soulofw0lf.yawspleef.Gun;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;


/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:39 PM
 */
public class InventoryClick implements Listener{
    public InventoryClick(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
    @SuppressWarnings("deprecation")
    @EventHandler
    public void shopInv(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        if (!inv.getName().equals(Chat.color(YaWSpleef.localeSettings.get("Shop Name")))){
             return;
        }
        ItemStack iS = event.getCurrentItem();
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
        if (!(event.getWhoClicked() instanceof Player)){return;}
        Player p = (Player)event.getWhoClicked();
        if (g.getWeaponCost() > YaWSpleef.econ.getBalance(p.getName())){
            return;
        }
        YaWSpleef.econ.withdrawPlayer(p.getName(), g.getWeaponCost());
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add " + g.getPermissionNeeded());
        inv.remove(iS);
        p.updateInventory();
    }
}
