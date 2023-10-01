package com.vondiktion.VondiktionMinePluginLocoLogic.LineManager;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String lineName;
    private List<Location> stations;
    private int trainSpawnInterval; // en secondes
    private Location startStation;
    private Location endStation;

    public Line(String lineName) {
        this.lineName = lineName;
        this.stations = new ArrayList<>();
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public List<Location> getStations() {
        return stations;
    }

    public void addStation(Location station) {
        stations.add(station);
    }

    public void removeStation(Location station) {
        stations.remove(station);
    }

    public int getTrainSpawnInterval() {
        return trainSpawnInterval;
    }

    public void setTrainSpawnInterval(int trainSpawnInterval) {
        this.trainSpawnInterval = trainSpawnInterval;
    }

    public Location getStartStation() {
        return startStation;
    }

    public void setStartStation(Location startStation) {
        this.startStation = startStation;
    }

    public Location getEndStation() {
        return endStation;
    }

    public void setEndStation(Location endStation) {
        this.endStation = endStation;
    }
}
