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
