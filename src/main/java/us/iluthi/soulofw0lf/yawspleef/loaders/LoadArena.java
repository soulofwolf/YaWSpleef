package us.iluthi.soulofw0lf.yawspleef.loaders;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.Locations;
import us.iluthi.soulofw0lf.yawspleef.utility.SignHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:30 PM
 */
public class LoadArena {
    @SuppressWarnings("unchecked")
    public static void loadArenas(){
        File directory = new File("plugins/Gun Spleef/Arenas");
        if (!directory.exists()){
            return;
        }
        File[] fc = directory.listFiles();
        for (File file : fc){
            if (!file.exists()){
                continue;
            }
            YamlConfiguration f = YamlConfiguration.loadConfiguration(file);
            Arena a = new Arena();
            a.setName(f.getString("Arena.Name"));
            a.setPermissionNeeded(f.getBoolean("Arena.Permission Needed"));
            a.setArenaY(f.getDouble("Arena.Floor Level"));
            a.setPermission(f.getString("Arena.Permission"));
            List<String> locs = (List<String>)f.getList("Arena.Start Locations");
            for (String s : locs){
                a.getStartLocs().add(Locations.stringToLoc(s));
            }
            a.setMinPlayers(f.getInt("Arena.Minimum Players"));
            a.setMaxPlayers(f.getInt("Arena.Maximum Players"));
            String sn = f.getString("Arena.Sign Location");
            Location loc = Locations.stringToLoc(sn);
            Block b = loc.getBlock();
            Sign sign = (Sign)b.getState();
            a.setStartSign(sign);
            YaWSpleef.spleefArenas.put(a.getName(), a);
            SignHandler.updateSigns(a);
        }
    }
}
