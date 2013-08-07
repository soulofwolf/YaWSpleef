package us.iluthi.soulofw0lf.yawspleef;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import us.iluthi.soulofw0lf.yawspleef.loaders.LoadArena;
import us.iluthi.soulofw0lf.yawspleef.loaders.LoadLocale;
import us.iluthi.soulofw0lf.yawspleef.runnables.ArenaCheck;
import us.iluthi.soulofw0lf.yawspleef.savers.SaveArena;
import us.iluthi.soulofw0lf.yawspleef.utility.Misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 2:38 PM
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
public class YaWSpleef extends JavaPlugin implements Listener {
    public static Plugin plugin;

    public static Map<String, Arena> spleefArenas = new HashMap<>();
    public static Map<String, String> playerArenas = new HashMap<>();
    public static Map<String, List<String>> mapQueues = new HashMap<>();
    public static Map<String, String> localeSettings = new HashMap<>();
    public static Map<String, String> commandSettings = new HashMap<>();
    public static YamlConfiguration locale;
    public static String stub = "";
    public static Location loc;
    public static Economy econ;
    public static boolean econOn = false;


    @Override
    public void onEnable(){
        plugin = this;
        saveDefaultConfig();
        LoadLocale.loadLocale();
        LoadArena.loadArenas();
        ArenaCheck.checkArenas();
        econOn = setupEconomy();
        if (getConfig().get("Lobby") != null){
            loc = Misc.stringToLoc(getConfig().getString("Lobby"));
        }

    }
    @Override
    public void onDisable(){
        SaveArena.saveArenas();
    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }



    private void arenaStarter(String aName) {

    }
}
