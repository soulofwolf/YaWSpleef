package us.iluthi.soulofw0lf.yawspleef.loaders;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import us.iluthi.soulofw0lf.yawspleef.Gun;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/8/13
 * Time: 9:07 AM
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
public class WeaponLoader {
    @SuppressWarnings("unchecked")
    public static void loadAll(){
        YamlConfiguration weap = YamlConfiguration.loadConfiguration(new File("plugins/Gun Spleef/Weapons.yml"));
        if (weap.get("Weapons") == null){
            weap.set("Weapons.&4Rail Gun.Cool Down", 1.25);
            weap.set("Weapons.&4Rail Gun.Cross Shot.Use", false);
            weap.set("Weapons.&4Rail Gun.Cross Shot.Cooldown", 3.5);
            weap.set("Weapons.&4Rail Gun.Slow Shot.Use", false);
            weap.set("Weapons.&4Rail Gun.Slow Shot.Duration", 3);
            weap.set("Weapons.&4Rail Gun.Slow Shot.Strength", 1);
            weap.set("Weapons.&4Rail Gun.Slow Shot.Cooldown", 5.0);
            weap.set("Weapons.&4Rail Gun.Slow Grenade.Use", false);
            weap.set("Weapons.&4Rail Gun.Slow Grenade.Range", 5);
            weap.set("Weapons.&4Rail Gun.Slow Grenade.Duration", 3);
            weap.set("Weapons.&4Rail Gun.Slow Grenade.Strength", 1);
            weap.set("Weapons.&4Rail Gun.Slow Grenade.Cooldown", 5.0);
            weap.set("Weapons.&4Rail Gun.Blind Grenade.Use", false);
            weap.set("Weapons.&4Rail Gun.Blind Grenade.Range", 5);
            weap.set("Weapons.&4Rail Gun.Blind Grenade.Duration", 3);
            weap.set("Weapons.&4Rail Gun.Blind Grenade.Strength", 1);
            weap.set("Weapons.&4Rail Gun.Blind Grenade.Cooldown", 5.0);
            weap.set("Weapons.&4Rail Gun.Speed Grenade.Use", false);
            weap.set("Weapons.&4Rail Gun.Speed Grenade.Range", 5);
            weap.set("Weapons.&4Rail Gun.Speed Grenade.Duration", 3);
            weap.set("Weapons.&4Rail Gun.Speed Grenade.Strength", 1);
            weap.set("Weapons.&4Rail Gun.Speed Grenade.Cooldown", 5.0);
            weap.set("Weapons.&4Rail Gun.Double Shot.Use", false);
            weap.set("Weapons.&4Rail Gun.Double Shot.Cooldown", 5.0);
            weap.set("Weapons.&4Rail Gun.Triple Shot.Use", false);
            weap.set("Weapons.&4Rail Gun.Triple Shot.Cooldown", 5.0);
            weap.set("Weapons.&4Rail Gun.Rapid Shot.Use", true);
            weap.set("Weapons.&4Rail Gun.Rapid Shot.Shots", 8);
            weap.set("Weapons.&4Rail Gun.Rapid Shot.Time", 1.5);
            weap.set("Weapons.&4Rail Gun.Rapid Shot.Cooldown", 3.5);
            weap.set("Weapons.&4Rail Gun.Teleport Shot.Use", false);
            weap.set("Weapons.&4Rail Gun.Teleport Shot.Cooldown", 10.0);
            weap.set("Weapons.&4Rail Gun.Summon Shot.Use", false);
            weap.set("Weapons.&4Rail Gun.Summon Shot.Cooldown", 10.0);
            weap.set("Weapons.&4Rail Gun.Invisible Shot.Use", false);
            weap.set("Weapons.&4Rail Gun.Invisible Shot.Duration", 3);
            weap.set("Weapons.&4Rail Gun.Invisible Shot.Cooldown", 10.0);
            weap.set("Weapons.&4Rail Gun.Speed Boost.Use", false);
            weap.set("Weapons.&4Rail Gun.Speed Boost.Duration", 3);
            weap.set("Weapons.&4Rail Gun.Speed Boost.Strength", 1);
            weap.set("Weapons.&4Rail Gun.Speed Boost.Cooldown", 5.0);
            weap.set("Weapons.&4Rail Gun.Blinding Shot.Use", false);
            weap.set("Weapons.&4Rail Gun.Blinding Shot.Duration", 3);
            weap.set("Weapons.&4Rail Gun.Blinding Shot.Cooldown", 10.0);
            weap.set("Weapons.&4Rail Gun.Weapon Cost", 1000);
            weap.set("Weapons.&4Rail Gun.Weapon Type", "STICK");
            List<String> lores = new ArrayList<>();
            lores.add("&2This gun fires in short bursts!");
            lores.add("&2Right click to Launch 8 shots");
            lores.add("&2 Over 8 Seconds");
            weap.set("Weapons.&4Rail Gun.Weapon Lore", lores);
            weap.set("Weapons.&4Rail Gun.Permission", "gun.rapidshot");
            weap.set("Weapons.&4Rail Gun.Projectile Type", "ARROW");
            try{
                weap.save(new File("plugins/Gun Spleef/Weapons.yml"));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        for (String key : weap.getConfigurationSection("Weapons").getKeys(false)){
        Gun g = new Gun();
            g.setName(key);
            g.setCooldown(weap.getDouble("Weapons."+key+".Cool Down"));
            g.setCrossShot(weap.getBoolean("Weapons." + key + ".Cross Shot.Use"));
            g.setCrossCD(weap.getDouble("Weapons." + key + ".Cross Shot.Cooldown"));
            g.setSlowShot(weap.getBoolean("Weapons." + key + ".Slow Shot.Use"));
            g.setSlowDuration(weap.getInt("Weapons." + key + ".Slow Shot.Duration"));
            g.setSlowStr(weap.getInt("Weapons." + key + ".Slow Shot.Strength"));
            g.setSlowCD(weap.getDouble("Weapons." + key + ".Slow Shot.Cooldown"));
            g.setSlowGrenade(weap.getBoolean("Weapons." + key + ".Slow Grenade.Use"));
            g.setSlowGrenadeRange(weap.getInt("Weapons." + key + ".Slow Grenade.Range"));
            g.setSlowGrenadeDuration(weap.getInt("Weapons." + key + ".Slow Grenade.Duration"));
            g.setSlowGrenadeStrength(weap.getInt("Weapons." + key + ".Slow Grenade.Strength"));
            g.setSlowGrenadeCD(weap.getDouble("Weapons." + key + ".Slow Grenade.Cooldown"));
            g.setBlindGrenade(weap.getBoolean("Weapons." + key + ".Blind Grenade.Use"));
            g.setBlindGrenadeRange(weap.getInt("Weapons." + key + ".Blind Grenade.Range"));
            g.setBlindGrenadeDuration(weap.getInt("Weapons."+key+".Blind Grenade.Duration"));
            g.setBlindGrenadeStrength(weap.getInt("Weapons." + key + ".Blind Grenade.Strength"));
            g.setBlindGrenadeCD(weap.getDouble("Weapons." + key + ".Blind Grenade.Cooldown"));
            g.setSpeedGrenade(weap.getBoolean("Weapons." + key + ".Speed Grenade.Use"));
            g.setSpeedGrenadeRange(weap.getInt("Weapons." + key + ".Speed Grenade.Range"));
            g.setSpeedGrenadeDuration(weap.getInt("Weapons." + key + ".Speed Grenade.Duration"));
            g.setSpeedGrenadeStrength(weap.getInt("Weapons." + key + ".Speed Grenade.Strength"));
            g.setSpeedGrenadeCD(weap.getDouble("Weapons." + key + ".Speed Grenade.Cooldown"));
            g.setDoubleShot(weap.getBoolean("Weapons." + key + ".Double Shot.Use"));
            g.setDoubleShotCD(weap.getDouble("Weapons." + key + ".Double Shot.Cooldown"));
            g.setTripleShot(weap.getBoolean("Weapons." + key + ".Triple Shot.Use"));
            g.setTripleShotCD(weap.getDouble("Weapons." + key + ".Triple Shot.Cooldown"));
            g.setRapidShot(weap.getBoolean("Weapons." + key + ".Rapid Shot.Use"));
            g.setRapidShotShots(weap.getInt("Weapons." + key + ".Rapid Shot.Shots"));
            g.setRapidShotTime(weap.getDouble("Weapons." + key + ".Rapid Shot.Time"));
            g.setRapidShotCd(weap.getDouble("Weapons." + key + ".Rapid Shot.Cooldown"));
            g.setTeleportShot(weap.getBoolean("Weapons." + key + ".Teleport Shot.Use"));
            g.setTeleportShotCD(weap.getDouble("Weapons." + key + ".Teleport Shot.Cooldown"));
            g.setSummonShot(weap.getBoolean("Weapons." + key + ".Summon Shot.Use"));
            g.setSummonshotCD(weap.getDouble("Weapons." + key + ".Summon Shot.Cooldown"));
            g.setInvisShot(weap.getBoolean("Weapons." + key + ".Invisible Shot.Use"));
            g.setInvisShotDuration(weap.getInt("Weapons." + key + ".Invisible Shot.Duration"));
            g.setInvisShotCD(weap.getDouble("Weapons." + key + ".Invisible Shot.Cooldown"));
            g.setSpeedBoost(weap.getBoolean("Weapons." + key + ".Speed Boost.Use"));
            g.setSpeedBoostDuration(weap.getInt("Weapons." + key + ".Speed Boost.Duration"));
            g.setSpeedBoostStrength(weap.getInt("Weapons." + key + ".Speed Boost.Strength"));
            g.setSpeedBoostCD(weap.getDouble("Weapons." + key + ".Speed Boost.Cooldown"));
            g.setBlindingShot(weap.getBoolean("Weapons." + key + ".Blinding Shot.Use"));
            g.setBlindingShotDuration(weap.getInt("Weapons." + key + ".Blinding Shot.Duration"));
            g.setBlindingShotCD(weap.getDouble("Weapons." + key + ".Blinding Shot.Cooldown"));
            g.setWeaponCost(weap.getDouble("Weapons." + key + ".Weapon Cost"));
            g.setWeaponType(Material.valueOf(weap.getString("Weapons." + key + ".Weapon Type")));
            g.setWeaponLore((List<String>)weap.getList("Weapons." + key + ".Weapon Lore"));
            g.setPermissionNeeded(weap.getString("Weapons." + key + ".Permission"));
            g.setProjectile(weap.getString("Weapons." + key + ".Projectile Type"));
            YaWSpleef.guns.put(key, g);
        }
    }
}
