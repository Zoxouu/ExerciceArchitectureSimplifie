package me.zoxouu.exercice.guice;

import me.zoxouu.exercice.commands.PlayerCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandInitializer {

    private final JavaPlugin plugin;

    public CommandInitializer(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommands() {
        plugin.getCommand("mycommand").setExecutor(new PlayerCommand());
    }
}
