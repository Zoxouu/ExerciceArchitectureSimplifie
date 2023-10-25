package me.zoxouu.exercice;


import com.google.inject.Guice;
import com.google.inject.Injector;
import me.zoxouu.exercice.guice.CommandInitializer;
import me.zoxouu.exercice.guice.ExerciseModule;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExerciceEndMC extends JavaPlugin {

    public static ExerciceEndMC plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Injector injector = Guice.createInjector(new ExerciseModule(this));
        injector.getInstance(CommandInitializer.class).registerCommands();
    }
}
