package fr.volax.otakumc.commands;

import fr.volax.otakumc.OtakuMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0){
            if(!(sender instanceof Player)){ sender.sendMessage("§cVous devez être un joueur pour voir votre argent."); return false;}
            Player player = (Player)sender;
            try {
                player.sendMessage(OtakuMain.prefix + "§7Solde de votre compte : " + OtakuMain.economy.getBalance(player.getName()) +"$.");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(args.length == 1){
            String targetName = args[0];
            if (Bukkit.getPlayer(targetName) == null) {
                sender.sendMessage(OtakuMain.prefix + "§cJoueur non trouvé !");
                return false;
            }else{
                Player target = Bukkit.getPlayer(targetName);
                sender.sendMessage(OtakuMain.prefix + "§7Solde de "+target.getName()+": " + OtakuMain.economy.getBalance(target.getName()) +"$.");
            }

        }
        return false;
    }
}
