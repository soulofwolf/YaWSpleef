package us.iluthi.soulofw0lf.yawspleef.arenaevents;

import org.bukkit.Material;
import org.bukkit.block.Block;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.SignHandler;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 4:21 PM
 */
public class ResetArena {
    public static void resetAll(){
        for (String key : YaWSpleef.spleefArenas.keySet()){
            Arena a = YaWSpleef.spleefArenas.get(key);
            a.setRunning(false);
            a.setCounting(false);
            a.getPlayers().clear();
            SignHandler.updateSigns(a);
            if (a.getResetBlocks().isEmpty()){
                continue;
            }
            for (Block b : a.getResetBlocks()){
                b.setType(Material.TNT);
            }
            a.getResetBlocks().clear();
        }
    }
    public static void resetOne(String arenaName){
        Arena a = YaWSpleef.spleefArenas.get(arenaName);
        a.setRunning(false);
        a.setCounting(false);
        a.getPlayers().clear();
        SignHandler.updateSigns(a);
        if (a.getResetBlocks().isEmpty()){
            return;
        }
        for (Block b : a.getResetBlocks()){
            b.setType(Material.TNT);
        }
        a.getResetBlocks().clear();
    }
}
