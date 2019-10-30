package fr.volax.otakumc.commands;

import fr.volax.otakumc.OtakuMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 3){
            Player target = Bukkit.getPlayer(args[1]);
            if(args[0].equalsIgnoreCase("give") ){
                if(target == null){ sender.sendMessage(OtakuMain.prefix + "§cCe joueur n'existe pas !"); return false; }
                if(!OtakuMain.getInstance().isInt(args[2])){  sender.sendMessage(OtakuMain.prefix + "§cVeillez fournir un nombre valide !"); return false; }
                int money = Integer.parseInt(args[2]);
                OtakuMain.economy.depositPlayer(target, money);
                target.sendMessage(OtakuMain.prefix + "§a" + money + "$ ont été ajoutés à votre compte !");
                sender.sendMessage(OtakuMain.prefix + "§a" + money + "$ ont été ajoutés de " + target.getName() +". Nouveau solde: " + OtakuMain.economy.getBalance(target) + "$");

                return false;
            }else if(args[0].equalsIgnoreCase("set")){
                if(target == null){ sender.sendMessage(OtakuMain.prefix + "§cCe joueur n'existe pas !"); return false; }
                if(!OtakuMain.getInstance().isInt(args[2])){  sender.sendMessage(OtakuMain.prefix + "§cVeillez fournir un nombre valide !"); return false; }
                int money = Integer.parseInt(args[2]);
                OtakuMain.economy.withdrawPlayer(target, OtakuMain.economy.getBalance(target));
                OtakuMain.economy.depositPlayer(target, money);
                target.sendMessage(OtakuMain.prefix + "§aVotre solde a été modifié à " + OtakuMain.economy.getBalance(target) + "$.");
                sender.sendMessage(OtakuMain.prefix + "§aVous avez modifié à " + OtakuMain.economy.getBalance(target) + "$ le solde de " + target.getName());


                return false;
            }else if(args[0].equalsIgnoreCase("take")){
                if(target == null){ sender.sendMessage(OtakuMain.prefix + "§cCe joueur n'existe pas !"); return false; }
                if(!OtakuMain.getInstance().isInt(args[2])){  sender.sendMessage(OtakuMain.prefix + "§cVeillez fournir un nombre valide !"); return false; }

                return false;
            }else{
                sender.sendMessage(OtakuMain.prefix + "§7/otakueco <give|reset|set|take> <joueur> <montant>");
                return false;
            }
        }else if(args.length == 2){
            Player target = Bukkit.getPlayer(args[1]);
            if(args[0].equalsIgnoreCase("reset") ){
                if(target == null){ sender.sendMessage(OtakuMain.prefix + "§cCe joueur n'existe pas !"); return false; }
                OtakuMain.economy.withdrawPlayer(target, OtakuMain.economy.getBalance(target));
                target.sendMessage(OtakuMain.prefix + "§aVotre solde a été modifié à " + OtakuMain.economy.getBalance(target) + "$.");
                sender.sendMessage(OtakuMain.prefix + "§aVous avez modifié à " + OtakuMain.economy.getBalance(target) + "$ le solde de " + target.getName());
                return false;
            }else{
                sender.sendMessage(OtakuMain.prefix + "§7/otakueco <give|reset|set|take> <joueur> <montant>");
                return false;
            }
        }else{
            sender.sendMessage(OtakuMain.prefix + "§7/otakueco <give|reset|set|take> <joueur> <montant>");
            return false;
        }
    }
}
