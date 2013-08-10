package us.iluthi.soulofw0lf.yawspleef.utility;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/8/13
 * Time: 8:29 PM
 */
public class ItemUpdate {
    @SuppressWarnings("deprecation")
    public static void coin(ItemStack iS, Player p){
        if (p.getInventory().getItem(8) != null && !p.getInventory().getItem(8).getType().equals(Material.AIR)){
            p.getInventory().setItem(8, new ItemStack(Material.AIR));
            p.updateInventory();
        }
        ItemMeta iM = iS.getItemMeta();
        List<String> lore = new ArrayList<>();
        Integer i = (int) YaWSpleef.econ.getBalance(p.getName());
        for (String s : iM.getLore()){
            lore.add(Chat.color(s.replace("@i", i.toString())));
        }
        iM.setLore(lore);
        iS.setItemMeta(iM);
        p.getInventory().setItem(8, iS);
        p.updateInventory();
    }

}
