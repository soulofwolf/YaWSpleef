package us.iluthi.soulofw0lf.yawspleef.utility;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 8/7/13
 * Time: 6:04 PM
 */
public enum ParticleEffect {
    HUGE_EXPLOSION("hugeexplosion", 0),
    LARGE_EXPLODE("largeexplode", 1),
    FIREWORKS_SPARK("fireworksSpark", 2),
    BUBBLE("bubble", 3),
    SUSPEND("suspend", 4),
    DEPTH_SUSPEND("depthSuspend", 5),
    TOWN_AURA("townaura", 6),
    CRIT("crit", 7),
    MAGIC_CRIT("magicCrit", 8),
    MOB_SPELL("mobSpell", 9),
    MOB_SPELL_AMBIENT("mobSpellAmbient", 10),
    SPELL("spell", 11),
    INSTANT_SPELL("instantSpell", 12),
    WITCH_MAGIC("witchMagic", 13),
    NOTE("note", 14),
    PORTAL("portal", 15),
    ENCHANTMENT_TABLE("enchantmenttable", 16),
    EXPLODE("explode", 17),
    FLAME("flame", 18),
    LAVA("lava", 19),
    FOOTSTEP("footstep", 20),
    SPLASH("splash", 21),
    LARGE_SMOKE("largesmoke", 22),
    CLOUD("cloud", 23),
    RED_DUST("reddust", 24),
    SNOWBALL_POOF("snowballpoof", 25),
    DRIP_WATER("dripWater", 26),
    DRIP_LAVA("dripLava", 27),
    SNOW_SHOVEL("snowshovel", 28),
    SLIME("slime", 29),
    HEART("heart", 30),
    ANGRY_VILLAGER("angryVillager", 31),
    HAPPY_VILLAGER("happyVillager", 32);
    /**
     *
     */
    private String name;
    private int id;

    /**
     *
     * @param name
     * @param id
     */
    ParticleEffect(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     */
    private static final Map<String, ParticleEffect> NAME_MAP = new HashMap<String, ParticleEffect>();
    private static final Map<Integer, ParticleEffect> ID_MAP = new HashMap<Integer, ParticleEffect>();

    /**
     *
     */
    static {
        for (ParticleEffect effect : values()) {
            NAME_MAP.put(effect.name, effect);
            ID_MAP.put(effect.id, effect);
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public static ParticleEffect fromName(String name) {
        if (name == null) {
            return null;
        }
        for (Map.Entry<String, ParticleEffect> e : NAME_MAP.entrySet()) {
            if (e.getKey().equalsIgnoreCase(name)) {
                return e.getValue();
            }
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public static ParticleEffect fromId(int id) {
        return ID_MAP.get(id);
    }

    /**
     * Plays a particle effect at a location which is only shown to a specific player.
     * @param p the player to play the effect to
     * @param loc the location to display the effect to the player
     * @param offsetX
     * @param offsetY
     * @param offsetZ
     * @param speed
     * @param amount
     */
    public void play(Player p, Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        sendPacket(p, createNormalPacket(this, loc, offsetX, offsetY, offsetZ, speed, amount));
    }

    /**
     * Plays a particle effect at a location which is shown to all players in the current world.
     * @param loc the location to play the effect at
     * @param offsetX
     * @param offsetY
     * @param offsetZ
     * @param speed
     * @param amount
     */
    public void play(Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        Object packet = createNormalPacket(this, loc, offsetX, offsetY, offsetZ, speed, amount);
        for (Player p : loc.getWorld().getPlayers()) {
            sendPacket(p, packet);
        }
    }

    /**
     * Plays a particle effect at a location which is shown to all players whitin a certain range in the current world.
     * This is highly prefered over the play without a range.
     *
     * @param loc the location to play the effect at
     * @param range the radius players have to be within to see the effect
     * @param offsetX
     * @param offsetY
     * @param offsetZ
     * @param speed
     * @param amount
     */
    public void play(Location loc, double range, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        Object packet = createNormalPacket(this, loc, offsetX, offsetY, offsetZ, speed, amount);
        for (Player p : loc.getWorld().getPlayers()) {
            if (p.getLocation().distance(loc) <= range) {
                sendPacket(p, packet);
            }
        }
    }

    /**
     * Plays a tilecrack effect at a location which is only shown to a specific player.
     */
    public static void playTileCrack(Player p, Location loc, int id, byte data, float offsetX, float offsetY, float offsetZ, int amount) {
        sendPacket(p, createTileCrackPacket(id, data, loc, offsetX, offsetY, offsetZ, amount));
    }

    /**
     * Plays a tilecrack effect at a location which is shown to all players in the current world.
     */
    public static void playTileCrack(Location loc, int id, byte data, float offsetX, float offsetY, float offsetZ, int amount) {
        Object packet = createTileCrackPacket(id, data, loc, offsetX, offsetY, offsetZ, amount);
        for (Player p : loc.getWorld().getPlayers()) {
            sendPacket(p, packet);
        }
    }

    /**
     * Plays a tilecrack effect at a location which is shown to all players within a certain range in the current world.
     */
    public static void playTileCrack(Location loc, double range, int id, byte data, float offsetX, float offsetY, float offsetZ, int amount) {
        Object packet = createTileCrackPacket(id, data, loc, offsetX, offsetY, offsetZ, amount);
        for (Player p : loc.getWorld().getPlayers()) {
            if (p.getLocation().distance(loc) <= range) {
                sendPacket(p, packet);
            }
        }
    }

    /**
     * Plays an iconcrack effect at a location which is only shown to a specific player.
     */
    public static void playIconCrack(Player p, Location loc, int id, float offsetX, float offsetY, float offsetZ, int amount) {
        sendPacket(p, createIconCrackPacket(id, loc, offsetX, offsetY, offsetZ, amount));
    }

    /**
     * Plays an iconcrack effect at a location which is shown to all players in the current world.
     */
    public static void playIconCrack(Location loc, int id, float offsetX, float offsetY, float offsetZ, int amount) {
        Object packet = createIconCrackPacket(id, loc, offsetX, offsetY, offsetZ, amount);
        for (Player p : loc.getWorld().getPlayers()) {
            sendPacket(p, packet);
        }
    }

    /**
     * Plays an iconcrack effect at a location which is shown to all players within a certain range in the current world.
     */
    public static void playIconCrack(Location loc, double range, int id, float offsetX, float offsetY, float offsetZ, int amount) {
        Object packet = createIconCrackPacket(id, loc, offsetX, offsetY, offsetZ, amount);
        for (Player p : loc.getWorld().getPlayers()) {
            if (p.getLocation().distance(loc) <= range) {
                sendPacket(p, packet);
            }
        }
    }

    /**
     *
     * @param effect
     * @param loc
     * @param offsetX
     * @param offsetY
     * @param offsetZ
     * @param speed
     * @param amount
     * @return
     */
    private Object createNormalPacket(ParticleEffect effect, Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        return createPacket(effect.getName(), loc, offsetX, offsetY, offsetZ, speed, amount);
    }

    /**
     *
     * @param id
     * @param data
     * @param loc
     * @param offsetX
     * @param offsetY
     * @param offsetZ
     * @param amount
     * @return
     */
    private static Object createTileCrackPacket(int id, byte data, Location loc, float offsetX, float offsetY, float offsetZ, int amount) {
        return createPacket("tilecrack_" + id + "_" + data, loc, offsetX, offsetY, offsetZ, 0.1F, amount);
    }

    /**
     *
     * @param id
     * @param loc
     * @param offsetX
     * @param offsetY
     * @param offsetZ
     * @param amount
     * @return
     */
    private static Object createIconCrackPacket(int id, Location loc, float offsetX, float offsetY, float offsetZ, int amount) {
        return createPacket("iconcrack_" + id, loc, offsetX, offsetY, offsetZ, 0.1F, amount);
    }

    /**
     *
     * @param effectName
     * @param loc
     * @param offsetX
     * @param offsetY
     * @param offsetZ
     * @param speed
     * @param amount
     * @return
     */
    private static Object createPacket(String effectName, Location loc, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount of particles has to be greater than 0!");
            }
            Object packet = ReflectionUtil.getClass("Packet63WorldParticles");
            ReflectionUtil.setValue(packet, "a", effectName);
            ReflectionUtil.setValue(packet, "b", (float) loc.getX());
            ReflectionUtil.setValue(packet, "c", (float) loc.getY());
            ReflectionUtil.setValue(packet, "d", (float) loc.getZ());
            ReflectionUtil.setValue(packet, "e", offsetX);
            ReflectionUtil.setValue(packet, "f", offsetY);
            ReflectionUtil.setValue(packet, "g", offsetZ);
            ReflectionUtil.setValue(packet, "h", speed);
            ReflectionUtil.setValue(packet, "i", amount);
            return packet;
        } catch (Exception e) {
            Bukkit.getLogger().warning("[ParticleEffect] Failed to create a particle packet!");
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param p
     * @param packet
     */
    private static void sendPacket(Player p, Object packet) {
        if (packet == null) {
            return;
        }
        try {
            Object entityPlayer = ReflectionUtil.getMethod("getHandle", p.getClass(), 0).invoke(p);
            Object playerConnection = entityPlayer.getClass().getField("playerConnection").get(entityPlayer);
            ReflectionUtil.getMethod("sendPacket", playerConnection.getClass(), 1).invoke(playerConnection, packet);
        } catch (Exception e) {
            Bukkit.getLogger().warning("[ParticleEffect] Failed to send a particle packet to " + p.getName() + "!");
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private static class ReflectionUtil {
        /**
         *
         * @param name
         * @param args
         * @return
         * @throws Exception
         */
        public static Object getClass(String name, Object... args) throws Exception {
            Class<?> c = Class.forName(ReflectionUtil.getPackageName() + "." + name);
            int params = 0;
            if (args != null) {
                params = args.length;
            }
            for (Constructor<?> co : c.getConstructors()) {
                if (co.getParameterTypes().length == params) {
                    return co.newInstance(args);
                }
            }
            return null;
        }

        /**
         *
         * @param name
         * @param c
         * @param params
         * @return
         */
        public static Method getMethod(String name, Class<?> c, int params) {
            for (Method m : c.getMethods()) {
                if (m.getName().equals(name) && m.getParameterTypes().length == params) {
                    return m;
                }
            }
            return null;
        }

        /**
         *
         * @param instance
         * @param fieldName
         * @param value
         * @throws Exception
         */
        public static void setValue(Object instance, String fieldName, Object value) throws Exception {
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        }

        /**
         *
         * @return
         */
        public static String getPackageName() {
            return "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        }
    }
}
