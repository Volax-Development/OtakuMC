package fr.volax.otakumc.listeners;

import fr.volax.otakumc.OtakuMain;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Otaku_GrenadePlayerInteractEvent implements Listener {
    @EventHandler
    public void onInteractEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack item = e.getItem();
        if(!(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)){ return; }
        else if(item.getType() == Material.FIREBALL){
            if(item.getItemMeta().getDisplayName().equals(OtakuMain.getInstance().getConfig().getString("items.grenade-level-2").replaceAll("&","§"))){
                p.launchProjectile(Snowball.class);
                if(p.getGameMode() == GameMode.CREATIVE){ return; } else{
                    if(item.getAmount() > 1){
                        item.setAmount(item.getAmount() - 1);
                        return;
                    }else{
                        p.setItemInHand(null);
                        p.updateInventory();
                        return;
                    }
                }
            }
        }else if(item.getType() == Material.NETHER_STAR){
            if(item.getItemMeta().getDisplayName().equals(OtakuMain.getInstance().getConfig().getString("items.grenade-level-3").replaceAll("&","§"))){
                p.launchProjectile(Snowball.class);
                if(p.getGameMode() == GameMode.CREATIVE){ return; } else{
                    if(item.getAmount() > 1){
                        item.setAmount(item.getAmount() - 1);
                        return;
                    }else{
                        p.setItemInHand(null);
                        p.updateInventory();
                        return;
                    }
                }
            }
        }
    }
}
