package fr.volax.otakumc.listeners.economy;

import fr.volax.otakumc.OtakuMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OtakuEco_PlayerJoinEvent implements Listener {

    private OtakuMain plugin;

    public OtakuEco_PlayerJoinEvent(OtakuMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(!OtakuMain.economy.hasAccount(e.getPlayer().getName())){
            OtakuMain.economy.createPlayerAccount(e.getPlayer().getName());
        }
    }
}