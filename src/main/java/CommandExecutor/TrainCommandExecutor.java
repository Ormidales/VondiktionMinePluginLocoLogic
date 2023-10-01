package com.vondiktion.VondiktionMinePluginLocoLogic.CommandExecutor;

import com.vondiktion.VondiktionMinePluginLocoLogic.TrainManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TrainCommandExecutor implements CommandExecutor {

    private TrainManager trainManager;

    public TrainCommandExecutor(TrainManager trainManager) {
        this.trainManager = trainManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage("Usage: /train <sub-command> [arguments]");
            return true;
        }

        String subCommand = args[0];

        switch (subCommand.toLowerCase()) {
            case "create":
                if (args.length < 2) {
                    sender.sendMessage("Usage: /train create <TrainID>");
                    return true;
                }
                trainManager.createTrain(args[1]);
                sender.sendMessage("Train " + args[1] + " created.");
                break;

            case "delete":
                if (args.length < 2) {
                    sender.sendMessage("Usage: /train delete <TrainID>");
                    return true;
                }
                trainManager.deleteTrain(args[1]);
                sender.sendMessage("Train " + args[1] + " deleted.");
                break;

            case "start":
                if (args.length < 2) {
                    sender.sendMessage("Usage: /train start <TrainID>");
                    return true;
                }
                trainManager.startTrain(args[1]);
                sender.sendMessage("Train " + args[1] + " started.");
                break;

            // Ajoutez d'autres commandes ici...

            default:
                sender.sendMessage("Unknown sub-command. Use /train for a list of commands.");
                break;
        }
        
        return true;
    }
}