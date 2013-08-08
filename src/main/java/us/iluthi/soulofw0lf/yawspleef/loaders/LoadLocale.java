package us.iluthi.soulofw0lf.yawspleef.loaders;

import org.bukkit.configuration.file.YamlConfiguration;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:31 PM
 */
public class LoadLocale {
    public static void loadLocale(){
        YamlConfiguration locale = YamlConfiguration.loadConfiguration(new File("plugins/Gun Spleef/Locale.yml"));
        if (locale.get("Messages") == null){
            locale.set("Messages.Player Removed", "@p has been Vanquished! You have Received 1 point");
            locale.set("Messages.You Are Out", "You have been removed from the game!");
            locale.set("Messages.Win Message", "You have been awarded 15 coins for winning Wizard Spleef!!");
            locale.set("Messages.Counting Down", "Your arena will be starting in @i seconds");
            locale.set("Messages.Shop Item Name", "&4Wand Store");
            locale.set("Messages.Shop Name", "&4Wand Store");
            locale.set("Signs.Line 1", "&eWizard Spleef");
            locale.set("Signs.Line 3", "&2@n &f/ &e@m");
            locale.set("Signs.In Progress", "&4Game Running");
            locale.set("Signs.Available", "&2Available");
            locale.set("Signs.Countdown", "&2Startin &4@i");
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

    }
}
