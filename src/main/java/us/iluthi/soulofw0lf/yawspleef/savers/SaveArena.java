package us.iluthi.soulofw0lf.yawspleef.savers;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.Locations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:32 PM
 */
public class SaveArena {
    public static void saveArenas(){
        for (String key : YaWSpleef.spleefArenas.keySet()){
            Arena a = YaWSpleef.spleefArenas.get(key);
            YamlConfiguration f = YamlConfiguration.loadConfiguration(new File("plugins/Gun Spleef/Arenas/" + a.getName() + ".yml"));
            f.set("Arena.Name", key);
            f.set("Arena.Permission Needed", a.isPermissionNeeded());
            f.set("Arena.Floor Level", a.getArenaY());
            f.set("Arena.Permission", a.getPermission());
            List<String> locs = new ArrayList<>();
            for (Location loc : a.getStartLocs()){
                locs.add(Locations.locToString(loc));
            }
            f.set("Arena.Start Locations", locs);
            f.set("Arena.Minimum Players", a.getMinPlayers());
            f.set("Arena.Maximum Players", a.getMaxPlayers());
            f.set("Arena.Sign Location", Locations.locToString(a.getStartSign().getLocation()));
            try {
                f.save(new File("plugins/Gun Spleef/Arenas/" + a.getName() + ".yml"));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void single(Arena a){
        YamlConfiguration f = YamlConfiguration.loadConfiguration(new File("plugins/Gun Spleef/Arenas/" + a.getName() + ".yml"));
        f.set("Arena.Name", a.getName());
        f.set("Arena.Permission Needed", a.isPermissionNeeded());
        f.set("Arena.Floor Level", a.getArenaY());
        f.set("Arena.Permission", a.getPermission());
        List<String> locs = new ArrayList<>();
        for (Location loc : a.getStartLocs()){
            locs.add(Locations.locToString(loc));
        }
        f.set("Arena.Start Locations", locs);
        f.set("Arena.Minimum Players", a.getMinPlayers());
        f.set("Arena.Maximum Players", a.getMaxPlayers());
        f.set("Arena.Sign Location", Locations.locToString(a.getStartSign().getLocation()));
        try {
            f.save(new File("plugins/Gun Spleef/Arenas/" + a.getName() + ".yml"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
