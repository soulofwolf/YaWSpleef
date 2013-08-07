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
public class Arena {
    private String name = "";
    private List<Block> resetBlocks = new ArrayList<>();
    private List<String> players = new ArrayList<>();
    private List<Location> startLocs = new ArrayList<>();
    private Location lobby;
    private String permission = "";
    private boolean permissionNeeded = false;
    private int minPlayers = 0;
    private int maxPlayers = 0;
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

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }
}
