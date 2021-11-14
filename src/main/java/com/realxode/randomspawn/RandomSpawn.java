package com.realxode.randomspawn;

import com.realxode.randomspawn.cmds.MainCommand;
import com.realxode.randomspawn.listeners.ListenerManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getCommand("randomspawn").setExecutor(new MainCommand(this));
        this.getServer().getPluginManager().registerEvents(new ListenerManager(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
