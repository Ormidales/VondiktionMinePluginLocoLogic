package com.vondiktion.VondiktionMinePluginLocoLogic;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Instance du TrainManager pour gérer les trains
    private TrainManager trainManager;
    // Instance du LineManager pour gérer les lignes
    private LineManager lineManager;

    @Override
    public void onEnable() {
        // Initialisation
        this.trainManager = new TrainManager();
        this.lineManager = new LineManager();

        // Enregistrement des commandes
        this.getCommand("train").setExecutor(new TrainCommandExecutor(trainManager));
        this.getCommand("line").setExecutor(new LineCommandExecutor(lineManager));

        // Charger la configuration
        saveDefaultConfig();

        // Autres initialisations...
        getLogger().info("VondiktionMinePluginLocoLogic has been enabled!");
    }

    @Override
    public void onDisable() {
        // Sauvegarde et nettoyage
        trainManager.saveTrains();
        lineManager.saveLines();

        getLogger().info("VondiktionMinePluginLocoLogic has been disabled!");
    }

    // Getters pour accéder aux managers depuis d'autres classes
    public TrainManager getTrainManager() {
        return trainManager;
    }

    public LineManager getLineManager() {
        return lineManager;
    }
}
