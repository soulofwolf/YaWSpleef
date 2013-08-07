package us.iluthi.soulofw0lf.yawspleef.utility;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.util.Vector;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:41 PM
 */
public class Locations {
    /**
     * Serializes a location in the form of worldname|x|y|z or worldname|x|y|z|yaw|pitch if either is not equal to zero
     * @param l location
     * @return serilized string
     */
    public static String locToString(Location l) {
        if (l.getPitch() == 0 && l.getYaw() == 0)
            return l.getWorld().getName()+"@"+l.getX()+"@"+l.getY()+"@"+l.getZ();
        else
            return l.getWorld().getName()+"@"+l.getX()+"@"+l.getY()+"@"+l.getZ()+"@"+l.getYaw()+"@"+l.getPitch();
    }
    public static String vecToString(Vector vec){
        return vec.getX()+"@"+vec.getY()+"@"+vec.getZ();
    }
    public static Vector stringToVec(String s){
        String[] vc = s.split("@");
        return new Vector(Double.parseDouble(vc[0]), Double.parseDouble(vc[1]),Double.parseDouble(vc[2]));
    }

    /**
     * Un-serializes a location in the form of worldname|x|y|z or worldname|x|y|z|yaw|pitch
     * @param s string
     * @return location
     */
    public static Location stringToLoc(String s) {
        String[] arr = s.split("@");
        if (arr.length == 4)
            return new Location(Bukkit.getWorld(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]));
        else
            return new Location(Bukkit.getWorld(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Float.parseFloat(arr[4]), Float.parseFloat(arr[5]));
    }
}
