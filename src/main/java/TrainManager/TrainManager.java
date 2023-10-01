package com.vondiktion.VondiktionMinePluginLocoLogic.TrainManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Minecart;
import org.bukkit.Location;

public class TrainManager {

    // Map pour stocker les trains en fonction de leur identifiant unique (TrainID)
    private Map<String, Train> trains;

    public TrainManager() {
        this.trains = new HashMap<>();
    }

    // Créer un nouveau train
    public Train createTrain(String trainID, Location spawnLocation) {
        if (trains.containsKey(trainID)) {
            return null; // Un train avec cet identifiant existe déjà
        }
        Train newTrain = new Train(trainID, spawnLocation);
        trains.put(trainID, newTrain);
        return newTrain;
    }

    // Supprimer un train existant
    public boolean deleteTrain(String trainID) {
        if (!trains.containsKey(trainID)) {
            return false; // Aucun train avec cet identifiant
        }
        trains.remove(trainID);
        return true;
    }

    // Récupérer un train existant
    public Train getTrain(String trainID) {
        return trains.get(trainID);
    }

    // Liste de tous les trains
    public Map<String, Train> listTrains() {
        return trains;
    }

    // Démarrer un train
    public boolean startTrain(String trainID) {
        Train train = getTrain(trainID);
        if (train == null) {
            return false; // Le train n'existe pas
        }
        train.start();
        return true;
    }

    // Arrêter un train
    public boolean stopTrain(String trainID) {
        Train train = getTrain(trainID);
        if (train == null) {
            return false; // Le train n'existe pas
        }
        train.stop();
        return true;
    }

    // Autres méthodes, comme la sauvegarde des trains dans un fichier, etc.

    public void saveTrains() {
        // Implémentation de la sauvegarde ici
    }
}
