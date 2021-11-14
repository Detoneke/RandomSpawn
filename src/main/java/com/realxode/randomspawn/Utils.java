package com.realxode.randomspawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Utils {

    private final RandomSpawn main;
    private final SplittableRandom splittableRandom = new SplittableRandom();

    public Utils(RandomSpawn main) {
        this.main = main;
    }

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public void saveSpawnPoint(String name, Location location) {
        main.getConfig().set("spawnpoints." + name + ".enabled", false);
        main.getConfig().set("spawnpoints." + name + ".world", location.getWorld().getName());
        main.getConfig().set("spawnpoints." + name + ".x", location.getX());
        main.getConfig().set("spawnpoints." + name + ".y", location.getY());
        main.getConfig().set("spawnpoints." + name + ".z", location.getZ());
        main.getConfig().set("spawnpoints." + name + ".yaw", location.getYaw());
        main.getConfig().set("spawnpoints." + name + ".pitch", location.getPitch());
        main.saveConfig();
    }

    public Location getSpawnpoint(String name) {
        return new Location(Bukkit.getWorld(main.getConfig().getString("spawnpoints." + name + ".world")),
                main.getConfig().getDouble("spawnpoints." + name + ".x"),
                main.getConfig().getDouble("spawnpoints." + name + ".y"),
                main.getConfig().getDouble("spawnpoints." + name + ".z"),
                (float) main.getConfig().getDouble("spawnpoints." + name + ".yaw"),
                (float) main.getConfig().getDouble("spawnpoints." + name + ".pitch"));
    }

    public String getRandomSpawnpoint() {
        final List<String> list = new ArrayList<>(main.getConfig().getConfigurationSection("spawnpoints")
                .getKeys(false));
        int randomNumber = splittableRandom.nextInt(list.size());
        return list.get(randomNumber);
    }

}
