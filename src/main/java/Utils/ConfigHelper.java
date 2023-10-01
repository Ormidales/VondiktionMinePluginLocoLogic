package com.vondiktion.VondiktionMinePluginLocoLogic.Utils;

import com.vondiktion.VondiktionMinePluginLocoLogic.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHelper {

    private Main plugin;
    private FileConfiguration config;

    public ConfigHelper(Main plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    // Méthode pour charger la configuration
    public void loadConfig() {
        plugin.reloadConfig();
        this.config = plugin.getConfig();
    }

    // Méthode pour sauvegarder la configuration
    public void saveConfig() {
        plugin.saveConfig();
    }

    // Exemple d'une méthode pour obtenir une valeur de la configuration
    public String getTrainName(String trainId) {
        return config.getString("trains." + trainId + ".name");
    }

    // Exemple d'une méthode pour définir une valeur dans la configuration
    public void setTrainName(String trainId, String name) {
        config.set("trains." + trainId + ".name", name);
        saveConfig(); // Sauvegarder la configuration après la modification
    }

    // ... Ajouter d'autres méthodes pour gérer la configuration
}
