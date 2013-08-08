package us.iluthi.soulofw0lf.yawspleef.runnables;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.arenaevents.StartArena;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;
import us.iluthi.soulofw0lf.yawspleef.utility.SignHandler;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:35 PM
 */
public class Countdown {
    public static void arenaCountdown(final String aName){
        new BukkitRunnable(){
            Arena a = YaWSpleef.spleefArenas.get(aName);
            Integer i = 30;
            @Override
            public void run(){
                if (i == 0){
                    new StartArena(a);
                    a.setRunning(true);
                    a.setCounting(false);
                    cancel();
                    return;
                }
                if (i == 30 || i == 20 || i == 15 || i == 10 || i <= 5){
                    for (String player : YaWSpleef.mapQueues.get(a.getName())){
                        Bukkit.getPlayer(player).sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Counting Down").replace("@i", i.toString())));
                    }
                }

                SignHandler.upateSigns(a, i);
                i--;

            }
        }.runTaskTimer(YaWSpleef.plugin, 20, 20);
    }
}
