package com.realxode.randomspawn.cmds;

import com.realxode.randomspawn.RandomSpawn;
import com.realxode.randomspawn.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.realxode.randomspawn.Utils.color;

public class MainCommand implements CommandExecutor {

    private final RandomSpawn main;
    private final Utils utils;

    public MainCommand(RandomSpawn main) {
        this.main = main;
        utils = new Utils(main);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(color("&cCommand only for players!"));
            return true;
        }
        Player player = (Player) sender;
        if (args.length < 1) {
            player.sendMessage(color("&6RandomSpawn help:"));
            player.sendMessage(color("&7 setspawn <name> &8| Create a new spawn point"));
            player.sendMessage(color("&7 tp <name> &8| Teleport to spawn point"));
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "setspawn":
                if (args.length < 2) {
                    player.sendMessage(color("&dYou need to specify a name! &7Example: /rs setspawn Test"));
                    return true;
                }
                String name = args[1];
                if (main.getConfig().contains("spawnpoints." + name)) {
                    player.sendMessage(color("That spawnpoint already exists!"));
                    return true;
                }
                // /rs setspawn [NAME]
                utils.saveSpawnPoint(name, player.getLocation());
                player.sendMessage(color("&a&l[DONE] &fSpawnpoint &7" + name + "&f created!"));
                return true;
            case "tp":
                if (args.length < 2) {
                    player.sendMessage(color("&dYou need to specify a name! &7Example: /rs tp Test"));
                    return true;
                }
                String spawnname = args[1];
                if (!main.getConfig().contains("spawnpoints." + spawnname)) {
                    player.sendMessage(color("That spawnpoint doesnt exists!"));
                    return true;
                }
                player.teleport(utils.getSpawnpoint(spawnname));
                player.sendMessage(color("&e&l[TELEPORTED!] &fYou got teleported to &7"
                        + spawnname + "&f spawnpoint!"));
        }
        return false;
    }
}
