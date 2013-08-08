package us.iluthi.soulofw0lf.yawspleef.runnables;

import org.bukkit.scheduler.BukkitRunnable;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:33 PM
 */
public class ArenaCheck {

    public static void checkArenas(){
        new BukkitRunnable(){
            @Override
            public void run(){
                for (String key : YaWSpleef.spleefArenas.keySet()){
                    if (key == null){
                        continue;
                    }
                    if (YaWSpleef.mapQueues.containsKey(key)){
                        Arena a = YaWSpleef.spleefArenas.get(key);
                        if (a.isCounting() || a.isRunning()){
                            continue;
                        }
                        if (YaWSpleef.mapQueues.get(key).size() >= a.getMinPlayers()){
                            a.setCounting(true);
                            Countdown.arenaCountdown(key);
                        }
                    }
                }
            }
        }.runTaskTimer(YaWSpleef.plugin, 20, 60);
    }
}
