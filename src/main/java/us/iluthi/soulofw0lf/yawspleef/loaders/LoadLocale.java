package us.iluthi.soulofw0lf.yawspleef.loaders;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:31 PM
 */
public class LoadLocale {
    @SuppressWarnings("unchecked")
    public static void loadLocale(){
        YamlConfiguration locale = YamlConfiguration.loadConfiguration(new File("plugins/Gun Spleef/Locale.yml"));
        if (locale.get("Messages") == null){
            locale.set("Messages.Player Removed", "@p has been Vanquished! You have Received 1 point");
            locale.set("Messages.You Are Out", "You have been removed from the game!");
            locale.set("Messages.Win Message", "You have been awarded 15 coins for winning Wizard Spleef!!");
            locale.set("Messages.Counting Down", "Your arena will be starting in @i seconds");
            locale.set("Messages.Shop Item Name", "&4Wand Store");
            locale.set("Messages.Shop Name", "&4Wand Store");
            locale.set("Messages.Game Shop", "&2The Game has started!");
            locale.set("Signs.Line 1", "&eWizard Spleef");
            locale.set("Signs.Line 3", "&2@n &f/ &e@m");
            locale.set("Signs.In Progress", "&4Game Running");
            locale.set("Signs.Available", "&2Available");
            locale.set("Signs.Countdown", "&2Startin &4@i");
            locale.set("Permissions.create", "wspleef.create");
            locale.set("Permissions.delete", "wspleef.delete");
            locale.set("Commands.Main Command", "ws");
            locale.set("Commands.Create", "create");
            locale.set("Commands.Save", "save");
            locale.set("Commands.Delete", "del");
            locale.set("Commands.Load All", "load");
            List<String> lores = new ArrayList<>();
            lores.add("&2click here to");
            lores.add("&2Open the Wand");
            lores.add("&2Shop");
            lores.add("&eCoins: &2@i");
            locale.set("Shop Item Lore", lores);
            locale.set("Shop Item", "EMERALD");
        }
        try {
            locale.save(new File("plugins/Gun Spleef/Locale.yml"));
        } catch (IOException e){
            e.printStackTrace();
        }
        YaWSpleef.stub = locale.getString("Stub Message");
        for (String key : locale.getConfigurationSection("Messages").getKeys(false)){
            YaWSpleef.localeSettings.put(key, locale.getString("Messages." + key));
        }
        for (String key : locale.getConfigurationSection("Commands").getKeys(false)){
            YaWSpleef.commandSettings.put(key, locale.getString("Commands." + key));
        }
        for (String key : locale.getConfigurationSection("Permissions").getKeys(false)){
            YaWSpleef.permissionSettings.put(key, locale.getString("Permissions." + key));
        }
        for (String key : locale.getConfigurationSection("Signs").getKeys(false)){
            YaWSpleef.signLines.put(key, locale.getString("Signs." + key));
        }
        ItemStack iS = new ItemStack(Material.valueOf(locale.getString("Shop Item")), 1);
        ItemMeta iM = iS.getItemMeta();
        iM.setDisplayName(Chat.color(locale.getString("Messages.Shop Item Name")));
        List<String> lore = new ArrayList<>();
        for (String loreString : (List<String>)locale.getList("Shop Item Lore")){
            lore.add(Chat.color(loreString));
        }
        iM.setLore(lore);
        iS.setItemMeta(iM);
        YaWSpleef.shopItem = iS;
    }
}
