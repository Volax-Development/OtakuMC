package fr.volax.otakumc.listeners;

import fr.volax.otakumc.OtakuMain;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class Otaku_ProjectileLaunchEvent implements Listener {
    @EventHandler
    public void onLaunchProjectil(ProjectileLaunchEvent e){
        Projectile proj = e.getEntity();
        if(!(proj instanceof Snowball)){ return; }
        if(!(e.getEntity().getShooter() instanceof Player)){return;}
        Player player = (Player) e.getEntity().getShooter();
        if(player.getItemInHand().getType() == Material.SNOW_BALL && player.getItemInHand().containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS) && player.getItemInHand().getItemMeta().getDisplayName().equals("§a§lGrenade Niveau 1")) {
            proj.setMetadata("grenadelvl1", new FixedMetadataValue(OtakuMain.getInstance(), null));
            return;
        }
        if(player.getItemInHand().getType() == Material.FIREBALL && player.getItemInHand().containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS) && player.getItemInHand().getItemMeta().getDisplayName().equals("§a§lGrenade Niveau 2")) {
            proj.setMetadata("grenadelvl2", new FixedMetadataValue(OtakuMain.getInstance(), null));
            return;
        }
        if(player.getItemInHand().getType() == Material.NETHER_STAR && player.getItemInHand().containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS) && player.getItemInHand().getItemMeta().getDisplayName().equals("§a§lGrenade Niveau 3")) {
            proj.setMetadata("grenadelvl3", new FixedMetadataValue(OtakuMain.getInstance(), null));
            return;
        }
    }
}
