package me.hikouki1111.particlelib.utils;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public class ParticleRenderer {
    public static void renderBox(Particle particle, BoundingBox box, double step, World world) {
        BoxHelper.unbox(box, (minX, minY, minZ, maxX, maxY, maxZ) -> {
            lineTo(particle, new BoundingBox(minX, minY, minZ, maxX, minY, minZ), step, world);
            lineTo(particle, new BoundingBox(maxX, minY, minZ, maxX, minY, maxZ), step, world);
            lineTo(particle, new BoundingBox(maxX, minY, maxZ, minX, minY, maxZ), step, world);
            lineTo(particle, new BoundingBox(minX, minY, maxZ, minX, minY, minZ), step, world);

            lineTo(particle, new BoundingBox(minX, maxY, minZ, maxX, maxY, minZ), step, world);
            lineTo(particle, new BoundingBox(maxX, maxY, minZ, maxX, maxY, maxZ), step, world);
            lineTo(particle, new BoundingBox(maxX, maxY, maxZ, minX, maxY, maxZ), step, world);
            lineTo(particle, new BoundingBox(minX, maxY, maxZ, minX, maxY, minZ), step, world);

            lineTo(particle, new BoundingBox(minX, minY, minZ, minX, maxY, minZ), step, world);
            lineTo(particle, new BoundingBox(maxX, minY, minZ, maxX, maxY, minZ), step, world);
            lineTo(particle, new BoundingBox(maxX, minY, maxZ, maxX, maxY, maxZ), step, world);
            lineTo(particle, new BoundingBox(minX, minY, maxZ, minX, maxY, maxZ), step, world);
        });
    }

    public static void renderFilledBox(Particle particle, BoundingBox box, double step, World world) {
        Vector min = box.getMin();
        Vector max = box.getMax();
        for (double x = min.getX(); x <= max.getX(); x+=step) {
            for (double y = min.getY(); y <= max.getY(); y+=step) {
                for (double z = min.getZ(); z <= max.getZ(); z+=step) {
                    world.spawnParticle(particle, new Location(world, x, y, z), 1, 0, 0, 0, 0);
                }
            }
        }
    }

    private static void lineTo(Particle particle, BoundingBox box, double step, World world) {
        Vector min = box.getMin();
        Vector max = box.getMax();
        for (double x = min.getX(); x <= max.getX(); x+=step) {
            world.spawnParticle(particle, new Location(world, x, min.getY(), min.getZ()), 1, 0, 0, 0, 0);
        }

        for (double y = min.getY(); y <= max.getY(); y+=step) {
            world.spawnParticle(particle, new Location(world, min.getX(), y, min.getZ()), 1, 0, 0, 0, 0);
        }

        for (double z = min.getZ(); z <= max.getZ(); z+=step) {
            world.spawnParticle(particle, new Location(world, min.getX(), min.getY(), z), 1, 0, 0, 0, 0);
        }
    }
}
