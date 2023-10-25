package me.zoxouu.exercice.commands;

import me.zoxouu.exercice.service.DatabaseService;
import me.zoxouu.exercice.service.PlayerService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommand implements CommandExecutor {
    private final PlayerService playerService;

    public PlayerCommand() {
        this.playerService = new PlayerService(new DatabaseService("",27017));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            playerService.doSomething(player);
            return true;
        }
        return false;
    }
}