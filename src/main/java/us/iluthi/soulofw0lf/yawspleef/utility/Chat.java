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
public class Chat {
    public static String colorStub(String s){
        s = ChatColor.translateAlternateColorCodes('&', YaWSpleef.stub + s);
        return s;
    }
    public static String color(String s){
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
}
