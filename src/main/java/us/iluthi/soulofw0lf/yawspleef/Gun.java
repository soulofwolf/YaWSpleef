package us.iluthi.soulofw0lf.yawspleef;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 6:24 PM
 */
public class Gun {
    private String name = "";
    private double cooldown = 0.0;
    private boolean crossShot = false;
    private double crossCD = 0.0;
    private boolean slowShot = false;
    private double slowCD = 0.0;
    private int slowStr = 0;
    private int slowDuration = 0;
    private boolean slowGrenade = false;
    private int slowGrenadeRange = 0;
    private int slowGrenadeDuration = 0;
    private int slowGrenadeStrength = 0;
    private double slowGrenadeCD = 0.0;
    private boolean blindGrenade = false;
    private int blindGrenadeRange = 0;
    private int blindGrenadeDuration = 0;
    private int blindGrenadeStrength = 0;
    private double blindGrenadeCD = 0.0;
    private boolean speedGrenade = false;
    private int speedGrenadeRange = 0;
    private int speedGrenadeDuration = 0;
    private int speedGrenadeStrength = 0;
    private double speedGrenadeCD = 0.0;
    private boolean doubleShot = false;
    private double doubleShotCD = 0.0;
    private boolean tripleShot = false;
    private double tripleShotCD = 0.0;
    private boolean rapidShot = false;
    private int rapidShotShots = 0;
    private double rapidShotTime = 0.0;
    private double rapidShotCd = 0.0;
    private boolean teleportShot = false;
    private double teleportShotCD = 0.0;
    private boolean summonShot = false;
    private double summonshotCD = 0.0;
    private boolean invisShot = false;
    private int invisShotDuration = 0;
    private double invisShotCD = 0.0;
    private boolean speedBoost = false;
    private int speedBoostDuration = 0;
    private int speedBoostStrength = 0;
    private double speedBoostCD = 0.0;
    private Double weaponCost = 0.0;
    private Material weaponType = Material.STICK;
    private boolean blindingShot = false;
    private int blindingShotDuration = 0;
    private double blindingShotCD = 0.0;
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

    public Double getWeaponCost() {
        return weaponCost;
    }

    public void setWeaponCost(Double weaponCost) {
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

    public double getBlindingShotCD() {
        return blindingShotCD;
    }

    public void setBlindingShotCD(double blindingShotCD) {
        this.blindingShotCD = blindingShotCD;
    }

    public int getBlindingShotDuration() {
        return blindingShotDuration;
    }

    public void setBlindingShotDuration(int blindingShotDuration) {
        this.blindingShotDuration = blindingShotDuration;
    }

    public double getSpeedBoostCD() {
        return speedBoostCD;
    }

    public void setSpeedBoostCD(double speedBoostCD) {
        this.speedBoostCD = speedBoostCD;
    }

    public int getSpeedBoostStrength() {
        return speedBoostStrength;
    }

    public void setSpeedBoostStrength(int speedBoostStrength) {
        this.speedBoostStrength = speedBoostStrength;
    }

    public int getSpeedBoostDuration() {
        return speedBoostDuration;
    }

    public void setSpeedBoostDuration(int speedBoostDuration) {
        this.speedBoostDuration = speedBoostDuration;
    }

    public double getInvisShotCD() {
        return invisShotCD;
    }

    public void setInvisShotCD(double invisShotCD) {
        this.invisShotCD = invisShotCD;
    }

    public int getInvisShotDuration() {
        return invisShotDuration;
    }

    public void setInvisShotDuration(int invisShotDuration) {
        this.invisShotDuration = invisShotDuration;
    }

    public double getSummonshotCD() {
        return summonshotCD;
    }

    public void setSummonshotCD(double summonshotCD) {
        this.summonshotCD = summonshotCD;
    }

    public double getTeleportShotCD() {
        return teleportShotCD;
    }

    public void setTeleportShotCD(double teleportShotCD) {
        this.teleportShotCD = teleportShotCD;
    }

    public double getRapidShotTime() {
        return rapidShotTime;
    }

    public void setRapidShotTime(double rapidShotTime) {
        this.rapidShotTime = rapidShotTime;
    }

    public int getRapidShotShots() {
        return rapidShotShots;
    }

    public void setRapidShotShots(int rapidShotShots) {
        this.rapidShotShots = rapidShotShots;
    }

    public double getTripleShotCD() {
        return tripleShotCD;
    }

    public void setTripleShotCD(double tripleShotCD) {
        this.tripleShotCD = tripleShotCD;
    }

    public double getDoubleShotCD() {
        return doubleShotCD;
    }

    public void setDoubleShotCD(double doubleShotCD) {
        this.doubleShotCD = doubleShotCD;
    }

    public double getSpeedGrenadeCD() {
        return speedGrenadeCD;
    }

    public void setSpeedGrenadeCD(double speedGrenadeCD) {
        this.speedGrenadeCD = speedGrenadeCD;
    }

    public int getSpeedGrenadeStrength() {
        return speedGrenadeStrength;
    }

    public void setSpeedGrenadeStrength(int speedGrenadeStrength) {
        this.speedGrenadeStrength = speedGrenadeStrength;
    }

    public int getSpeedGrenadeDuration() {
        return speedGrenadeDuration;
    }

    public void setSpeedGrenadeDuration(int speedGrenadeDuration) {
        this.speedGrenadeDuration = speedGrenadeDuration;
    }

    public int getSpeedGrenadeRange() {
        return speedGrenadeRange;
    }

    public void setSpeedGrenadeRange(int speedGrenadeRange) {
        this.speedGrenadeRange = speedGrenadeRange;
    }

    public double getBlindGrenadeCD() {
        return blindGrenadeCD;
    }

    public void setBlindGrenadeCD(double blindGrenadeCD) {
        this.blindGrenadeCD = blindGrenadeCD;
    }

    public int getBlindGrenadeStrength() {
        return blindGrenadeStrength;
    }

    public void setBlindGrenadeStrength(int blindGrenadeStrength) {
        this.blindGrenadeStrength = blindGrenadeStrength;
    }

    public int getBlindGrenadeDuration() {
        return blindGrenadeDuration;
    }

    public void setBlindGrenadeDuration(int blindGrenadeDuration) {
        this.blindGrenadeDuration = blindGrenadeDuration;
    }

    public int getBlindGrenadeRange() {
        return blindGrenadeRange;
    }

    public void setBlindGrenadeRange(int blindGrenadeRange) {
        this.blindGrenadeRange = blindGrenadeRange;
    }

    public double getSlowGrenadeCD() {
        return slowGrenadeCD;
    }

    public void setSlowGrenadeCD(double slowGrenadeCD) {
        this.slowGrenadeCD = slowGrenadeCD;
    }

    public int getSlowGrenadeStrength() {
        return slowGrenadeStrength;
    }

    public void setSlowGrenadeStrength(int slowGrenadeStrength) {
        this.slowGrenadeStrength = slowGrenadeStrength;
    }

    public int getSlowGrenadeDuration() {
        return slowGrenadeDuration;
    }

    public void setSlowGrenadeDuration(int slowGrenadeDuration) {
        this.slowGrenadeDuration = slowGrenadeDuration;
    }

    public int getSlowGrenadeRange() {
        return slowGrenadeRange;
    }

    public void setSlowGrenadeRange(int slowGrenadeRange) {
        this.slowGrenadeRange = slowGrenadeRange;
    }

    public int getSlowDuration() {
        return slowDuration;
    }

    public void setSlowDuration(int slowDuration) {
        this.slowDuration = slowDuration;
    }

    public int getSlowStr() {
        return slowStr;
    }

    public void setSlowStr(int slowStr) {
        this.slowStr = slowStr;
    }

    public double getSlowCD() {
        return slowCD;
    }

    public void setSlowCD(double slowCD) {
        this.slowCD = slowCD;
    }

    public double getCrossCD() {
        return crossCD;
    }

    public void setCrossCD(double crossCD) {
        this.crossCD = crossCD;
    }
}
