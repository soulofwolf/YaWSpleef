package us.iluthi.soulofw0lf.yawspleef.utility;

import org.bukkit.block.Sign;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 3:42 PM
 */
public class SignHandler {
    public static void updateSigns(Sign sign, String line1, String line2, String line3, String line4){
        sign.setLine(0, line1);
        sign.setLine(1, line2);
        sign.setLine(2, line3);
        sign.setLine(3, line4);
        sign.update();
    }
}
