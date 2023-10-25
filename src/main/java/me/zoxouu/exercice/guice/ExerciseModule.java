package me.zoxouu.exercice.guice;

import com.google.inject.AbstractModule;
import org.bukkit.plugin.java.JavaPlugin;

public class ExerciseModule extends AbstractModule {

    private final JavaPlugin plugin;

    public ExerciseModule(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    protected void configure() {
        bind(JavaPlugin.class).toInstance(plugin);
    }
}
