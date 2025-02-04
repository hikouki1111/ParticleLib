package me.hikouki1111.particlelib;

import me.hikouki1111.particlelib.utils.BoxHelper;
import me.hikouki1111.particlelib.utils.ParticleRenderer;
import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;

public final class ParticleLib extends JavaPlugin {
    public static boolean INDEV = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (INDEV) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    ParticleRenderer.renderCircle(Particle.DOLPHIN, 0, 100, 0, 5, 32, 0.1, Bukkit.getWorld("world"));
                    BoundingBox box = new BoundingBox(0, 101, 0, 1, 102, 1);
                    ParticleRenderer.renderBox(Particle.DOLPHIN, box, 0.1, Bukkit.getWorld("world"));
                    ParticleRenderer.renderFilledBox(Particle.DOLPHIN, new BoundingBox(0, 99, 0, 1, 100, 1), 0.1, Bukkit.getWorld("world"));
                }
            }.runTaskTimerAsynchronously(this, 0, 0);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
