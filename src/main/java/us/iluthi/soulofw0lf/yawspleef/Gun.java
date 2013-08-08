package us.iluthi.soulofw0lf.yawspleef;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 6:24 PM
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
public class Gun {
    private String name = "";
    private double cooldown = 0.0;
    private boolean crossShot = false;
    private boolean slowShot = false;
    private boolean slowGrenade = false;
    private boolean blindGrenade = false;
    private boolean speedGrenade = false;
    private boolean doubleShot = false;
    private boolean tripleShot = false;
    private boolean rapidShot = false;
    private double rapidShotCd = 0.0;
    private boolean teleportShot = false;
    private boolean summonShot = false;
    private boolean invisShot = false;
    private boolean speedBoost = false;
    private double weaponCost = 0.0;
    private Material weaponType = Material.STICK;
    private boolean blindingShot = false;
    private List<String> weaponLore = new ArrayList<>();
    private String permissionNeeded = "";
    private String projectile = "";

    public String getProjectile() {
        return projectile;
    }

    public void setProjectile(String projectile) {
        this.projectile = projectile;
    }

    public String getPermissionNeeded() {
        return permissionNeeded;
    }

    public void setPermissionNeeded(String permissionNeeded) {
        this.permissionNeeded = permissionNeeded;
    }

    public List<String> getWeaponLore() {
        return weaponLore;
    }

    public void setWeaponLore(List<String> weaponLore) {
        this.weaponLore = weaponLore;
    }

    public boolean isBlindingShot() {
        return blindingShot;
    }

    public void setBlindingShot(boolean blindingShot) {
        this.blindingShot = blindingShot;
    }

    public Material getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(Material weaponType) {
        this.weaponType = weaponType;
    }

    public double getWeaponCost() {
        return weaponCost;
    }

    public void setWeaponCost(double weaponCost) {
        this.weaponCost = weaponCost;
    }

    public boolean isSpeedBoost() {
        return speedBoost;
    }

    public void setSpeedBoost(boolean speedBoost) {
        this.speedBoost = speedBoost;
    }

    public boolean isInvisShot() {
        return invisShot;
    }

    public void setInvisShot(boolean invisShot) {
        this.invisShot = invisShot;
    }

    public boolean isSummonShot() {
        return summonShot;
    }

    public void setSummonShot(boolean summonShot) {
        this.summonShot = summonShot;
    }

    public boolean isTeleportShot() {
        return teleportShot;
    }

    public void setTeleportShot(boolean teleportShot) {
        this.teleportShot = teleportShot;
    }

    public double getRapidShotCd() {
        return rapidShotCd;
    }

    public void setRapidShotCd(double rapidShotCd) {
        this.rapidShotCd = rapidShotCd;
    }

    public boolean isRapidShot() {
        return rapidShot;
    }

    public void setRapidShot(boolean rapidShot) {
        this.rapidShot = rapidShot;
    }

    public boolean isTripleShot() {
        return tripleShot;
    }

    public void setTripleShot(boolean tripleShot) {
        this.tripleShot = tripleShot;
    }

    public boolean isDoubleShot() {
        return doubleShot;
    }

    public void setDoubleShot(boolean doubleShot) {
        this.doubleShot = doubleShot;
    }

    public boolean isSpeedGrenade() {
        return speedGrenade;
    }

    public void setSpeedGrenade(boolean speedGrenade) {
        this.speedGrenade = speedGrenade;
    }

    public boolean isBlindGrenade() {
        return blindGrenade;
    }

    public void setBlindGrenade(boolean blindGrenade) {
        this.blindGrenade = blindGrenade;
    }

    public boolean isSlowGrenade() {
        return slowGrenade;
    }

    public void setSlowGrenade(boolean slowGrenade) {
        this.slowGrenade = slowGrenade;
    }

    public boolean isSlowShot() {
        return slowShot;
    }

    public void setSlowShot(boolean slowShot) {
        this.slowShot = slowShot;
    }

    public boolean isCrossShot() {
        return crossShot;
    }

    public void setCrossShot(boolean crossShot) {
        this.crossShot = crossShot;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
