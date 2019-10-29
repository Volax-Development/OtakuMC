package fr.volax.otakumc.listeners;

import fr.volax.otakumc.OtakuMain;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class Otaku_ProjectileHitEvent implements Listener {
    @EventHandler
    public void onProjectiles(ProjectileHitEvent e){
        Projectile proj = e.getEntity();
        if(proj instanceof Snowball){
            Snowball snowball = (Snowball)proj;
            Player player = (Player)snowball.getShooter();
            if(snowball.getShooter() instanceof Player){
                if(snowball.hasMetadata("grenadelvl1")){
                    snowball.getWorld().createExplosion(snowball.getLocation(), OtakuMain.getInstance().getConfig().getInt("items.level.grenade-level-1"), false);
                    return;
                }else if(snowball.hasMetadata("grenadelvl2")){
                    snowball.getWorld().createExplosion(snowball.getLocation(),OtakuMain.getInstance().getConfig().getInt("items.level.grenade-level-2"), false);
                    return;
                }else if(snowball.hasMetadata("grenadelvl3")){
                    snowball.getWorld().createExplosion(snowball.getLocation(),OtakuMain.getInstance().getConfig().getInt("items.level.grenade-level-3"), false);
                    return;
                }
            }
        }
    }
}
