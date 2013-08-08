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
