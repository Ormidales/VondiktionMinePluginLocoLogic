package com.vondiktion.VondiktionMinePluginLocoLogic.CommandExecutor;

import com.vondiktion.VondiktionMinePluginLocoLogic.LineManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LineCommandExecutor implements CommandExecutor {

    private LineManager lineManager;

    public LineCommandExecutor(LineManager lineManager) {
        this.lineManager = lineManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Cette commande est réservée aux joueurs !");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("Usage : /line <subcommand> <arguments>");
            return true;
        }

        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "create":
                if (args.length < 2) {
                    player.sendMessage("Usage : /line create <LineName>");
                    return true;
                }
                lineManager.createLine(args[1], player);
                break;

            case "delete":
                if (args.length < 2) {
                    player.sendMessage("Usage : /line delete <LineName>");
                    return true;
                }
                lineManager.deleteLine(args[1]);
                break;

            case "list":
                lineManager.listLines(player);
                break;

            case "info":
                if (args.length < 2) {
                    player.sendMessage("Usage : /line info <LineName>");
                    return true;
                }
                lineManager.showLineInfo(args[1], player);
                break;

            case "autospawn":
                if (args.length < 5) {
                    player.sendMessage("Usage : /line autospawn <LineName> <Interval> <StartStation> <EndStation>");
                    return true;
                }
                lineManager.setAutoSpawn(args[1], Integer.parseInt(args[2]), args[3], args[4]);
                break;

            case "stopautospawn":
                if (args.length < 2) {
                    player.sendMessage("Usage : /line stopautospawn <LineName>");
                    return true;
                }
                lineManager.stopAutoSpawn(args[1]);
                break;

            default:
                player.sendMessage("Commande inconnue. Utilisez /line pour obtenir de l'aide.");
        }
        return true;
    }
}
