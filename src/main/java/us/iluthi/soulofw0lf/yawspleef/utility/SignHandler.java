package us.iluthi.soulofw0lf.yawspleef.utility;

import org.bukkit.block.Sign;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:42 PM
 */
public class SignHandler {
    public static void updateSigns(Arena a){
        Sign sign = a.getStartSign();
        sign.setLine(0, Chat.color(YaWSpleef.signLines.get("Line 1")));
        sign.setLine(1, Chat.color(a.getName()));
        Integer i = a.getPlayers().size();
        Integer m = a.getMaxPlayers();
        sign.setLine(2, Chat.color(YaWSpleef.signLines.get("Line 3").replace("@n", i.toString()).replace("@m", m.toString())));
        if (a.isRunning()){
            sign.setLine(3, Chat.color(YaWSpleef.signLines.get("In Progress")));
        } else {
            sign.setLine(3, Chat.color(YaWSpleef.signLines.get("Available")));
        }
        sign.update();
    }
    public static void upateSigns(Arena a, Integer l){
        Sign sign = a.getStartSign();
        sign.setLine(0, Chat.color(YaWSpleef.signLines.get("Line 1")));
        sign.setLine(1, Chat.color(a.getName()));
        Integer i = a.getPlayers().size();
        Integer m = a.getMaxPlayers();
        sign.setLine(2, Chat.color(YaWSpleef.signLines.get("Line 3").replace("@n", i.toString()).replace("@m", m.toString())));
        sign.setLine(3, Chat.color(YaWSpleef.signLines.get("Countdown").replace("@i", l.toString())));
        sign.update();
    }
}
