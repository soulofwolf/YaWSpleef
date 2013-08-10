package us.iluthi.soulofw0lf.yawspleef;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import us.iluthi.soulofw0lf.yawspleef.loaders.LoadArena;
import us.iluthi.soulofw0lf.yawspleef.loaders.LoadLocale;
import us.iluthi.soulofw0lf.yawspleef.loaders.RegisterEvents;
import us.iluthi.soulofw0lf.yawspleef.loaders.WeaponLoader;
import us.iluthi.soulofw0lf.yawspleef.runnables.ArenaCheck;
import us.iluthi.soulofw0lf.yawspleef.savers.SaveArena;
import us.iluthi.soulofw0lf.yawspleef.utility.Locations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 2:38 PM
 */
public class YaWSpleef extends JavaPlugin implements Listener {
    public static Plugin plugin;

    public static Map<String, Arena> spleefArenas = new HashMap<>();
    public static Map<String, String> playerArenas = new HashMap<>();
    public static Map<String, List<String>> mapQueues = new HashMap<>();
    public static List<String> playerQue = new ArrayList<>();
    public static Map<String, String> localeSettings = new HashMap<>();
    public static Map<String, String> commandSettings = new HashMap<>();
    public static Map<String, String> permissionSettings = new HashMap<>();
    public static Map<String, String> signLines = new HashMap<>();
    public static Map<String, ItemStack> weaponPerms = new HashMap<>();
    public static Map<String, ItemStack[]> playerInventory = new HashMap<>();
    public static String stub = "";
    public static Location loc;
    public static Economy econ;
    public static boolean econOn = false;
    public static List<String> onStart = new ArrayList<>();
    public static Map<String, Gun> guns = new HashMap<>();
    public static List<String> CD = new ArrayList<>();
    public static List<String> specialShotCD = new ArrayList<>();
    public static Map<String, String> playerShots = new HashMap<>();
    public static List<String> blindG = new ArrayList<>();
    public static List<String> blindS = new ArrayList<>();
    public static List<String> crossS = new ArrayList<>();
    public static List<String> slowG = new ArrayList<>();
    public static List<String> slowS = new ArrayList<>();
    public static List<String> speedG = new ArrayList<>();
    public static List<String> summonS = new ArrayList<>();
    public static ScoreboardManager manager;
    public static Map<String, Scoreboard> playerBoards = new HashMap<>();
    public static ItemStack shopItem;
    public static List<String> editingSpawns = new ArrayList<>();
    public static List<String> addingSigns = new ArrayList<>();
    public static Map<String, Arena> arenaEdit = new HashMap<>();

    @Override
    public void onEnable(){
        plugin = this;
        RegisterEvents.regAll(plugin);
        LoadLocale.loadLocale();
        LoadArena.loadArenas();
        ArenaCheck.checkArenas();
        WeaponLoader.loadAll();
        econOn = setupEconomy();
        manager = Bukkit.getScoreboardManager();
        if (getConfig().get("Lobby") != null){
            loc = Locations.stringToLoc(getConfig().getString("Lobby"));
            for (Player p : Bukkit.getOnlinePlayers()){
                p.teleport(loc);
            }
        }
    }
    @Override
    public void onDisable(){
        SaveArena.saveArenas();
        if (loc != null){
            getConfig().set("Lobby", Locations.locToString(loc));
            saveConfig();
        }
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
}
