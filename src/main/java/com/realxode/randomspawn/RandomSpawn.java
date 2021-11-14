package com.realxode.randomspawn;

import org.bukkit.plugin.java.JavaPlugin;

public final class RandomSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
