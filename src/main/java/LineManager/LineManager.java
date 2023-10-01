package com.vondiktion.VondiktionMinePluginLocoLogic.LineManager;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class LineManager {

    // Stocke les lignes en mémoire
    private Map<String, Line> lines;

    public LineManager() {
        lines = new HashMap<>();
    }

    /**
     * Ajoute une nouvelle ligne.
     * @param lineName Le nom de la ligne
     * @param startStation La station de départ
     * @param endStation La station d'arrivée
     */
    public void createLine(String lineName, Location startStation, Location endStation) {
        Line newLine = new Line(lineName, startStation, endStation);
        lines.put(lineName, newLine);
    }

    /**
     * Supprime une ligne.
     * @param lineName Le nom de la ligne à supprimer
     */
    public void removeLine(String lineName) {
        lines.remove(lineName);
    }

    /**
     * Obtient une ligne par son nom.
     * @param lineName Le nom de la ligne
     * @return La ligne, ou null si elle n'existe pas
     */
    public Line getLine(String lineName) {
        return lines.get(lineName);
    }

    /**
     * Vérifie si une ligne existe.
     * @param lineName Le nom de la ligne
     * @return true si elle existe, false sinon
     */
    public boolean lineExists(String lineName) {
        return lines.containsKey(lineName);
    }

    /**
     * Démarre le spawn automatique de trains sur une ligne.
     * @param lineName Le nom de la ligne
     * @param interval L'intervalle en secondes
     */
    public void startAutoSpawn(String lineName, int interval) {
        Line line = getLine(lineName);
        if (line != null) {
            line.startAutoSpawn(interval);
        }
    }

    /**
     * Arrête le spawn automatique de trains sur une ligne.
     * @param lineName Le nom de la ligne
     */
    public void stopAutoSpawn(String lineName) {
        Line line = getLine(lineName);
        if (line != null) {
            line.stopAutoSpawn();
        }
    }

    /**
     * Sauvegarde toutes les lignes (par exemple dans un fichier ou une base de données).
     */
    public void saveLines() {
        // Implémentez la logique de sauvegarde ici
    }

    /**
     * Charge toutes les lignes à partir de la source de données.
     */
    public void loadLines() {
        // Implémentez la logique de chargement ici
    }
}
