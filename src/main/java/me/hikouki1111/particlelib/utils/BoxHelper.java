package me.hikouki1111.particlelib.utils;

import org.bukkit.util.BoundingBox;

public class BoxHelper {
    public static void unbox(BoundingBox box, BoxConsumer<Double, Double, Double, Double, Double, Double> consumer) {
        consumer.accept(box.getMinX(), box.getMinY(), box.getMinZ(), box.getMaxX(), box.getMaxY(), box.getMaxZ());
    }

    @FunctionalInterface
    public interface BoxConsumer<A, B, C, D, E, F> {
        void accept(A minX, B minY, C minZ, D maxX, E maxY, F maxZ);
    }
}
