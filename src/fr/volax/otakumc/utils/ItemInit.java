package fr.volax.otakumc.utils;

import fr.volax.otakumc.OtakuMain;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;

public class ItemInit {
    public static ItemAPI proj_snow_level1 = new ItemAPI(Material.SNOW_BALL).setName(OtakuMain.getInstance().getConfig().getString("items.grenade-level-1").replaceAll("&","§")).addFlag(ItemFlag.HIDE_ENCHANTS).addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1);
    public static ItemAPI proj_snow_level2 = new ItemAPI(Material.FIREBALL).setName(OtakuMain.getInstance().getConfig().getString("items.grenade-level-2").replaceAll("&","§")).addFlag(ItemFlag.HIDE_ENCHANTS).addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1);
    public static ItemAPI proj_snow_level3 = new ItemAPI(Material.NETHER_STAR).setName(OtakuMain.getInstance().getConfig().getString("items.grenade-level-3").replaceAll("&","§")).addFlag(ItemFlag.HIDE_ENCHANTS).addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1);
}
