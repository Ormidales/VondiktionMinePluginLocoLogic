package com.vondiktion.VondiktionMinePluginLocoLogic.TrainManager;

import org.bukkit.Location;
import org.bukkit.entity.Minecart;
import java.util.ArrayList;
import java.util.List;

public class Train {

    private String id; // Identifiant unique du train
    private Location spawnLocation; // L'endroit où le train apparaît
    private List<Minecart> wagons; // Liste des wagons du train
    private boolean isRunning; // État actuel du train (en marche ou pas)
    private double speed; // Vitesse du train
    private List<String> stations; // Liste des stations que le train va desservir

    public Train(String id, Location spawnLocation) {
        this.id = id;
        this.spawnLocation = spawnLocation;
        this.wagons = new ArrayList<>();
        this.isRunning = false;
        this.speed = 0.0;
        this.stations = new ArrayList<>();
    }

    // Getter et Setter pour l'ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter et Setter pour spawnLocation
    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    // Méthodes pour gérer les wagons
    public void addWagon(Minecart wagon) {
        wagons.add(wagon);
    }

    public void removeWagon(Minecart wagon) {
        wagons.remove(wagon);
    }

    public List<Minecart> getWagons() {
        return wagons;
    }

    // Getter et Setter pour isRunning
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    // Getter et Setter pour la vitesse
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Méthodes pour gérer les stations
    public void addStation(String station) {
        stations.add(station);
    }

    public void removeStation(String station) {
        stations.remove(station);
    }

    public List<String> getStations() {
        return stations;
    }
}
