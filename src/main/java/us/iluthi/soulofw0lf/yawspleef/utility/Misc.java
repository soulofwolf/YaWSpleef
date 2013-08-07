package us.iluthi.soulofw0lf.yawspleef.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.util.Vector;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 2:47 PM
 */
public class Misc {
    public static String color(String s){
        String output = ChatColor.translateAlternateColorCodes('&', YaWSpleef.stub + s);
        return output;
    }


}
