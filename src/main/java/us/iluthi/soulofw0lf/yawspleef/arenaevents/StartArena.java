package us.iluthi.soulofw0lf.yawspleef.arenaevents;

import org.bukkit.Bukkit;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 4:21 PM
 */
public class StartArena {
    public StartArena(Arena a){
        for (String player : YaWSpleef.mapQueues.get(a.getName())){
            a.getPlayers().add(player);
            YaWSpleef.playerArenas.put(player, a.getName());
            YaWSpleef.playerQue.remove(player);
            YaWSpleef.onStart.remove(player);
            YaWSpleef.mapQueues.get(a.getName()).remove(player);
            Bukkit.getPlayer(player).sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Game Started")));
        }
    }
}
