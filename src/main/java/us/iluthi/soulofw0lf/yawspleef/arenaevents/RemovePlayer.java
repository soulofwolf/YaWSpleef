package us.iluthi.soulofw0lf.yawspleef.arenaevents;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;

/**
 * Created by: soulofw0lf
 * Date: 8/8/13
 * Time: 2:36 PM
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
public class RemovePlayer {
    public static void fellOut(Arena a, Player p){
        a.getPlayers().remove(p.getName());
        if (YaWSpleef.slowG.contains(p.getName())){
            YaWSpleef.slowG.remove(p.getName());
        }
        if (YaWSpleef.summonS.contains(p.getName())){
            YaWSpleef.summonS.remove(p.getName());
        }
        if (YaWSpleef.slowS.contains(p.getName())){
            YaWSpleef.slowS.remove(p.getName());
        }
        if (YaWSpleef.blindG.contains(p.getName())){
            YaWSpleef.blindG.remove(p.getName());
        }
        if (YaWSpleef.CD.contains(p.getName())){
            YaWSpleef.CD.remove(p.getName());
        }
        if (YaWSpleef.specialShotCD.contains(p.getName())){
            YaWSpleef.specialShotCD.remove(p.getName());
        }
        if (YaWSpleef.playerShots.containsKey(p.getName())){
            YaWSpleef.playerShots.remove(p.getName());
        }
        if (YaWSpleef.blindS.contains(p.getName())){
            YaWSpleef.blindS.remove(p.getName());
        }
        if (YaWSpleef.crossS.contains(p.getName())){
            YaWSpleef.crossS.remove(p.getName());
        }
        if (YaWSpleef.speedG.contains(p.getName())){
            YaWSpleef.speedG.remove(p.getName());
        }
        if (YaWSpleef.playerArenas.containsKey(p.getName())){
            YaWSpleef.playerArenas.remove(p.getName());
        }
        p.teleport(YaWSpleef.loc);
        p.getInventory().clear();
        if (YaWSpleef.playerInventory.containsKey(p.getName())){
            p.getInventory().setContents(YaWSpleef.playerInventory.get(p.getName()));
        }
        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("You Are Out")));
        if (a.getPlayers().size() == 1){
            winOut(a, Bukkit.getPlayer(a.getPlayers().get(0)));
        } else {
            for (String s : a.getPlayers()){
                YaWSpleef.econ.depositPlayer(s, 1.0);
                Bukkit.getPlayer(s).sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Player Removed").replace("@p", p.getName())));
            }
        }
    }
    public static void winOut(Arena a, Player p){
        a.getPlayers().remove(p.getName());
        if (YaWSpleef.slowG.contains(p.getName())){
            YaWSpleef.slowG.remove(p.getName());
        }
        if (YaWSpleef.summonS.contains(p.getName())){
            YaWSpleef.summonS.remove(p.getName());
        }
        if (YaWSpleef.slowS.contains(p.getName())){
            YaWSpleef.slowS.remove(p.getName());
        }
        if (YaWSpleef.blindG.contains(p.getName())){
            YaWSpleef.blindG.remove(p.getName());
        }
        if (YaWSpleef.CD.contains(p.getName())){
            YaWSpleef.CD.remove(p.getName());
        }
        if (YaWSpleef.specialShotCD.contains(p.getName())){
            YaWSpleef.specialShotCD.remove(p.getName());
        }
        if (YaWSpleef.playerShots.containsKey(p.getName())){
            YaWSpleef.playerShots.remove(p.getName());
        }
        if (YaWSpleef.blindS.contains(p.getName())){
            YaWSpleef.blindS.remove(p.getName());
        }
        if (YaWSpleef.crossS.contains(p.getName())){
            YaWSpleef.crossS.remove(p.getName());
        }
        if (YaWSpleef.speedG.contains(p.getName())){
            YaWSpleef.speedG.remove(p.getName());
        }
        if (YaWSpleef.playerArenas.containsKey(p.getName())){
            YaWSpleef.playerArenas.remove(p.getName());
        }
        ResetArena.resetOne(a.getName());
        p.teleport(YaWSpleef.loc);
        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Win Message")));
        YaWSpleef.econ.depositPlayer(p.getName(), 15.0);
        EndArena.gameOver(a);
    }
}
