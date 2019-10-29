package fr.volax.otakumc.listeners;

import fr.volax.otakumc.OtakuMain;
import fr.volax.otakumc.utils.ItemInit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Otaku_InventoryGrenadeEvent implements Listener {
    @EventHandler
    public void onInventoryGrenadeEvent(InventoryClickEvent e){
        if(!(e.getWhoClicked() instanceof Player)){ return; }
        Player player = (Player) e.getWhoClicked();
        String inv = e.getInventory().getName();
        ItemStack item = e.getCurrentItem();
        if(inv.equalsIgnoreCase(OtakuMain.getInstance().getConfig().getString("inventories.give-grenades").replaceAll("&","§"))) {
            if (item.getType() == Material.SNOW_BALL) {
                if (item.getItemMeta().getDisplayName().equalsIgnoreCase(OtakuMain.getInstance().getConfig().getString("items.grenade-level-1").replaceAll("&", "§"))) {
                    player.getInventory().addItem(ItemInit.proj_snow_level1.toItemStack());
                    e.setCancelled(true);
                    return;
                }
            } else if (item.getType() == Material.FIREBALL) {
                if (item.getItemMeta().getDisplayName().equalsIgnoreCase(OtakuMain.getInstance().getConfig().getString("items.grenade-level-2").replaceAll("&", "§"))) {
                    player.getInventory().addItem(ItemInit.proj_snow_level2.toItemStack());
                    e.setCancelled(true);
                    return;
                }
            } else if (item.getType() == Material.NETHER_STAR) {
                if (item.getItemMeta().getDisplayName().equalsIgnoreCase(OtakuMain.getInstance().getConfig().getString("items.grenade-level-3").replaceAll("&", "§"))) {
                    player.getInventory().addItem(ItemInit.proj_snow_level3.toItemStack());
                    e.setCancelled(true);
                    return;
                }
            }
        }
    }
}
