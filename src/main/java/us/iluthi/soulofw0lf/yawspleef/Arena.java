package us.iluthi.soulofw0lf.yawspleef;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 2:41 PM
 */
public class Arena {
    private String name = "";
    private List<Block> resetBlocks = new ArrayList<>();
    private List<String> players = new ArrayList<>();
    private List<Location> startLocs = new ArrayList<>();
    private Location lobby;
    private String permission = "";
    private boolean permissionNeeded = false;
    private int minPlayers = 0;
    private Integer maxPlayers = 0;
    private boolean running = false;
    private boolean counting = false;
    private Sign startSign;

    public Sign getStartSign() {
        return startSign;
    }

    public void setStartSign(Sign startSign) {
        this.startSign = startSign;
    }

    public boolean isCounting() {
        return counting;
    }

    public void setCounting(boolean counting) {
        this.counting = counting;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isPermissionNeeded() {
        return permissionNeeded;
    }

    public void setPermissionNeeded(boolean permissionNeeded) {
        this.permissionNeeded = permissionNeeded;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Location getLobby() {
        return lobby;
    }

    public void setLobby(Location lobby) {
        this.lobby = lobby;
    }

    public List<Location> getStartLocs() {
        return startLocs;
    }

    public void setStartLocs(List<Location> startLocs) {
        this.startLocs = startLocs;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public List<Block> getResetBlocks() {
        return resetBlocks;
    }

    public void setResetBlocks(List<Block> resetBlocks) {
        this.resetBlocks = resetBlocks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }
}
