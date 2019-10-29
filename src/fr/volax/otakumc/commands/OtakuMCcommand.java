package fr.volax.otakumc.commands;

import fr.volax.otakumc.OtakuMain;
import fr.volax.otakumc.utils.ItemInit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class OtakuMCcommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){ return false; }
            Player player = (Player)sender;
            if(!(args.length == 2)){
                player.sendMessage("§c/otakumc give grenades");
            }else{
                if(args[0].equals("give") && args[1].equals("grenades") && args.length == 2){
                    Inventory inv = Bukkit.createInventory(null, 1*9, OtakuMain.getInstance().getConfig().getString("inventories.give-grenades").replaceAll("&","§"));
                    inv.setItem(1, ItemInit.proj_snow_level1.toItemStack());
                    inv.setItem(4, ItemInit.proj_snow_level2.toItemStack());
                    inv.setItem(7, ItemInit.proj_snow_level3.toItemStack());
                    player.openInventory(inv);
                }
            }
        return false;
    }
}
