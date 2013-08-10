package us.iluthi.soulofw0lf.yawspleef.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;
import us.iluthi.soulofw0lf.yawspleef.Arena;
import us.iluthi.soulofw0lf.yawspleef.YaWSpleef;
import us.iluthi.soulofw0lf.yawspleef.arenaevents.RemovePlayer;
import us.iluthi.soulofw0lf.yawspleef.arenaevents.ResetArena;
import us.iluthi.soulofw0lf.yawspleef.loaders.LoadArena;
import us.iluthi.soulofw0lf.yawspleef.loaders.LoadLocale;
import us.iluthi.soulofw0lf.yawspleef.loaders.WeaponLoader;
import us.iluthi.soulofw0lf.yawspleef.savers.SaveArena;
import us.iluthi.soulofw0lf.yawspleef.utility.Chat;

import java.io.File;

/**
 * Created by: soulofw0lf
 * Date: 8/8/13
 * Time: 8:45 PM
 */
public class Commands implements Listener{
    public Commands(Plugin plug){
        Bukkit.getPluginManager().registerEvents(this, plug);
    }
    @EventHandler
    public void playerCom(PlayerCommandPreprocessEvent event){
        Player p = event.getPlayer();
        String[] args = event.getMessage().split(" ");
        String cmd = args[0].replace("/", "");
        if (cmd.equalsIgnoreCase(YaWSpleef.commandSettings.get("Main Command")) && args[1].equalsIgnoreCase(YaWSpleef.commandSettings.get("Leave"))){
            if (YaWSpleef.playerQue.contains(p.getName())){
                YaWSpleef.playerQue.remove(p.getName());
            }
            if (YaWSpleef.onStart.contains(p.getName())){
                YaWSpleef.onStart.remove(p.getName());
            }
            for (String key : YaWSpleef.mapQueues.keySet()){
                if (YaWSpleef.mapQueues.get(key).contains(p.getName())){
                    Arena a = YaWSpleef.spleefArenas.get(key);
                    RemovePlayer.fellOut(a, p);
                    YaWSpleef.mapQueues.get(key).remove(p.getName());
                }
            }
            p.teleport(YaWSpleef.loc);
            return;
        }
        if (YaWSpleef.playerArenas.containsKey(p.getName())){
            event.setCancelled(true);
            return;
        }
        if (cmd.equalsIgnoreCase(YaWSpleef.commandSettings.get("Main Command"))){
            event.setCancelled(true);
            if (args.length == 2){
                if (args[1].equalsIgnoreCase(YaWSpleef.commandSettings.get("Set Lobby"))){
                    if (!p.hasPermission(YaWSpleef.permissionSettings.get("Create"))){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("No Perms")));
                        return;
                    }
                    YaWSpleef.loc = p.getLocation();
                    p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Lobby Set")));
                    return;
                }
                if (args[1].equalsIgnoreCase(YaWSpleef.commandSettings.get("Load All"))){
                    if (!p.hasPermission(YaWSpleef.permissionSettings.get("Load"))){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("No Perms")));
                        return;
                    }
                    YaWSpleef.spleefArenas.clear();
                    YaWSpleef.onStart.clear();
                    YaWSpleef.playerArenas.clear();
                    YaWSpleef.mapQueues.clear();
                    YaWSpleef.addingSigns.clear();
                    YaWSpleef.arenaEdit.clear();
                    YaWSpleef.commandSettings.clear();
                    YaWSpleef.guns.clear();
                    YaWSpleef.localeSettings.clear();
                    for (Player pl : Bukkit.getOnlinePlayers()){
                        pl.teleport(YaWSpleef.loc);
                    }
                    LoadLocale.loadLocale();
                    WeaponLoader.loadAll();
                    LoadArena.loadArenas();
                    p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Arenas Loaded")));
                    return;
                }

                if (args[1].equalsIgnoreCase(YaWSpleef.commandSettings.get("Save"))){
                    if (!p.hasPermission(YaWSpleef.permissionSettings.get("Create"))){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("No Perms")));
                        return;
                    }
                    if (!YaWSpleef.arenaEdit.containsKey(p.getName())){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Not Editing")));
                        return;
                    }
                    Arena a = YaWSpleef.arenaEdit.get(p.getName());
                    SaveArena.single(a);
                    YaWSpleef.arenaEdit.remove(p.getName());
                    YaWSpleef.spleefArenas.put(a.getName(), a);
                    p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Arena Saved")));
                    return;
                }
            }
            if (args.length == 3){
                if (args[1].equalsIgnoreCase(YaWSpleef.commandSettings.get("Delete"))){
                    if (!p.hasPermission(YaWSpleef.permissionSettings.get("Delete"))){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("No Perms")));
                        return;
                    }
                    if (!YaWSpleef.spleefArenas.containsKey(args[2].replace("_", " "))){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Arena Not Found")));
                        return;
                    }
                    Arena a = YaWSpleef.spleefArenas.get(args[2].replace("_", " "));

                    if (YaWSpleef.mapQueues.containsKey(args[2].replace("_", " "))){
                        for (String player : YaWSpleef.mapQueues.get(args[2].replace("_", " "))){
                            RemovePlayer.fellOut(a, Bukkit.getPlayer(player));
                        }
                        ResetArena.resetOne(args[2].replace("_", " "));
                    }
                    YaWSpleef.spleefArenas.remove(args[2].replace("_", " "));
                    YaWSpleef.mapQueues.remove(args[2].replace("_", " "));
                    File f = new File("plugins/YaWSpleef/Arena/"+args[2].replace("_", " ")+".yml");
                    f.delete();
                    p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Arena Deleted")));
                    return;
                }
            }
            if (args.length == 5){
                if (args[1].equalsIgnoreCase(YaWSpleef.commandSettings.get("Create"))){
                    if (!p.hasPermission(YaWSpleef.permissionSettings.get("Create"))){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("No Perms")));
                        return;
                    }
                    if (YaWSpleef.arenaEdit.containsKey(p.getName())){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Already Editing")));
                        return;
                    }
                    if (YaWSpleef.spleefArenas.containsKey(args[2].replace("_", " "))){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Arena Exists")));
                        return;
                    }
                    int min = Integer.parseInt(args[3]);
                    int max = Integer.parseInt(args[4]);
                    Arena a = new Arena();
                    a.setName(args[2].replace("_", " "));
                    a.setMinPlayers(min);
                    a.setMaxPlayers(max);
                    a.setArenaY(p.getLocation().getY());
                    a.setPermissionNeeded(false);
                    YaWSpleef.arenaEdit.put(p.getName(), a);
                    YaWSpleef.editingSpawns.add(p.getName());
                    p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Create Started")));
                    return;
                }
            }
            if (args.length == 6){
                if (args[1].equalsIgnoreCase(YaWSpleef.commandSettings.get("Create"))){
                    if (!p.hasPermission(YaWSpleef.permissionSettings.get("Create"))){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("No Perms")));
                        return;
                    }
                    if (YaWSpleef.arenaEdit.containsKey(p.getName())){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Already Editing")));
                        return;
                    }
                    if (YaWSpleef.spleefArenas.containsKey(args[2].replace("_", " "))){
                        p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Arena Exists")));
                        return;
                    }
                    int min = Integer.parseInt(args[3]);
                    int max = Integer.parseInt(args[4]);
                    Arena a = new Arena();
                    a.setName(args[2].replace("_", " "));
                    a.setMinPlayers(min);
                    a.setMaxPlayers(max);
                    a.setArenaY(p.getLocation().getY() - 1);
                    a.setPermissionNeeded(true);
                    a.setPermission(args[5]);
                    YaWSpleef.arenaEdit.put(p.getName(), a);
                    YaWSpleef.editingSpawns.add(p.getName());
                    p.sendMessage(Chat.colorStub(YaWSpleef.localeSettings.get("Create Started")));
                }
            }
        }
    }
}
