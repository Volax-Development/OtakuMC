package fr.volax.otakumc;

import fr.volax.otakumc.commands.EcoCommand;
import fr.volax.otakumc.commands.MoneyCommand;
import fr.volax.otakumc.commands.OtakuMCcommand;
import fr.volax.otakumc.listeners.*;
import fr.volax.otakumc.listeners.economy.OtakuEco_PlayerJoinEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class OtakuMain extends JavaPlugin {
    private static OtakuMain instance;
    public static Economy economy;
    public static String prefix = "§3§lOtaku§b§lMC ⋙§r ";

    @Override
    public void onEnable() {
        saveDefaultConfig();

        instance = this;
        registerEvents();
        registerCommands();

        if (!setupEconomy()) {
            Bukkit.shutdown();
        }
    }


    private void registerCommands() {
        getCommand("otakumc").setExecutor(new OtakuMCcommand());
        getCommand("money").setExecutor(new MoneyCommand());
        getCommand("otakueco").setExecutor(new EcoCommand());
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Otaku_ProjectileHitEvent(), this);
        pm.registerEvents(new Otaku_InventoryGrenadeEvent(), this);
        pm.registerEvents(new Otaku_ProjectileLaunchEvent(), this);
        pm.registerEvents(new Otaku_BlockExplodeEvent(), this);
        pm.registerEvents(new Otaku_GrenadePlayerInteractEvent(), this);
        pm.registerEvents(new OtakuEco_PlayerJoinEvent(this), this);
    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
        return (economy != null);
    }

    public static OtakuMain getInstance(){ return instance;   }

    public boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
