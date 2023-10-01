package com.vondiktion.VondiktionMinePluginLocoLogic.TrainManager;

import org.bukkit.Location;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

public class Wagon {

    private Minecart minecart;
    private String type; // Peut être "passenger", "storage", etc.
    private Location location;
    
    // Constructeur
    public Wagon(Minecart minecart, String type, Location location) {
        this.minecart = minecart;
        this.type = type;
        this.location = location;
    }

    // Déplace le wagon à une nouvelle position
    public void moveTo(Location newLocation) {
        this.minecart.teleport(newLocation);
        this.location = newLocation;
    }

    // Met à jour le type de wagon
    public void setType(String newType) {
        this.type = newType;
    }

    // Méthodes pour embarquer/débarquer un joueur (pour les wagons passagers)
    public void board(Player player) {
        if ("passenger".equals(this.type)) {
            minecart.addPassenger(player);
        }
    }

    public void unboard(Player player) {
        if ("passenger".equals(this.type)) {
            minecart.removePassenger(player);
        }
    }

    // Getters et Setters
    public Minecart getMinecart() {
        return minecart;
    }

    public String getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }
}
