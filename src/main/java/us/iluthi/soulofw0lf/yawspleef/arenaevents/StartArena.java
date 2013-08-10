package us.iluthi.soulofw0lf.yawspleef.arenaevents;

import org.bukkit.Bukkit;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;
import us.iluthi.soulofw0lf.yawspleef.utility.SignHandler;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 4:21 PM
 */
public class StartArena {
    public StartArena(Arena a){
        for (String player : YaWSpleef.mapQueues.get(a.getName())){
            YaWSpleef.playerArenas.put(player, a.getName());
            YaWSpleef.playerQue.remove(player);
            YaWSpleef.onStart.remove(player);
            Bukkit.getPlayer(player).sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Game Started")));
        }
        a.setRunning(true);
        SignHandler.updateSigns(a);
        YaWSpleef.mapQueues.get(a.getName()).clear();
    }
}
