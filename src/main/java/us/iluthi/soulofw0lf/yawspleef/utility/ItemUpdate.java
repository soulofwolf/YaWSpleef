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
 * <p/>
 * This file is part of the Rpg Suite Created by Soulofw0lf and Linksy.
 * <p/>
 * The Rpg Suite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * The Rpg Suite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with The Rpg Suite Plugin you have downloaded.  If not, see <http://www.gnu.org/licenses/>.
 */
public class ItemUpdate {
    @SuppressWarnings("deprecation")
    public static void coin(ItemStack iS, Player p){
        if (p.getInventory().getItem(8) != null || !p.getInventory().getItem(8).getType().equals(Material.AIR)){
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
