package com.realxode.randomspawn.cmds;

import com.realxode.randomspawn.RandomSpawn;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.realxode.randomspawn.Utils.color;

public class MainCommand implements CommandExecutor {

    private RandomSpawn main;
    public MainCommand(RandomSpawn main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage(color("&cCommand only for players!"));
            return true;
        }
        Player player = (Player) sender;
        if (args.length < 1){
            player.sendMessage(color("&6RandomSpawn help:"));
            player.sendMessage(color("&7 setspawn <name> &8| Create a new spawn point"));
            return true;
        }
        if (args[0].equalsIgnoreCase("setspawn")){
            if (args.length < 2){
                player.sendMessage(color("&dYou need to specify a name! &7Example: /rs setspawn Test"));
                return true;
            }

        }
        return false;
    }
}
