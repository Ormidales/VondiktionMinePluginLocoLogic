package com.vondiktion.VondiktionMinePluginLocoLogic.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationHelper {

    // Convertit une Location en une chaîne de caractères pour le stockage
    public static String locationToString(Location location) {
        if (location == null) {
            return "";
        }
        return location.getWorld().getName() + "," +
                location.getX() + "," +
                location.getY() + "," +
                location.getZ() + "," +
                location.getYaw() + "," +
                location.getPitch();
    }

    // Convertit une chaîne de caractères en Location
    public static Location stringToLocation(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }

        String[] parts = str.split(",");
        if (parts.length == 6) {
            World world = Bukkit.getServer().getWorld(parts[0]);
            double x = Double.parseDouble(parts[1]);
            double y = Double.parseDouble(parts[2]);
            double z = Double.parseDouble(parts[3]);
            float yaw = Float.parseFloat(parts[4]);
            float pitch = Float.parseFloat(parts[5]);

            return new Location(world, x, y, z, yaw, pitch);
        } else {
            return null;
        }
    }

    // Vérifie si deux Locations sont à la même position (sans vérifier le pitch et le yaw)
    public static boolean isSameLocation(Location loc1, Location loc2) {
        if (loc1 == null || loc2 == null) {
            return false;
        }
        return loc1.getWorld().equals(loc2.getWorld()) &&
                loc1.getBlockX() == loc2.getBlockX() &&
                loc1.getBlockY() == loc2.getBlockY() &&
                loc1.getBlockZ() == loc2.getBlockZ();
    }
}
