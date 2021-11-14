package com.realxode.randomspawn.listeners;

import com.realxode.randomspawn.RandomSpawn;
import com.realxode.randomspawn.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class ListenerManager implements Listener {

    private final RandomSpawn main;
    private final Utils utils;

    public ListenerManager(RandomSpawn main) {
        this.main = main;
        utils = new Utils(main);
    }

    @EventHandler
    public void onBedRespawn(PlayerRespawnEvent event) {
        if (event.getRespawnLocation() != event.getPlayer().getBedSpawnLocation()) {
            event.setRespawnLocation(utils.getSpawnpoint(utils.getRandomSpawnpoint()));
        }
    }

}
