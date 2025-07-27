package com.getsuga;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;

public class SwordManager {
    
    private final GetsugaTenshouPlugin plugin;
    private final NamespacedKey getsugaKey;
    
    public SwordManager(GetsugaTenshouPlugin plugin) {
        this.plugin = plugin;
        this.getsugaKey = new NamespacedKey(plugin, "getsuga_sword");
    }
    
    public ItemStack createGetsugaSword() {
        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = sword.getItemMeta();
        
        if (meta != null) {
            // Set display name
            meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "月牙天衝 (Getsuga Tenshou)");
            
            // Set lore
            List<String> lore = Arrays.asList(
                ChatColor.GRAY + "A legendary blade that can",
                ChatColor.GRAY + "unleash devastating energy waves.",
                "",
                ChatColor.YELLOW + "Right-click to use " + ChatColor.AQUA + "Getsuga Tenshou",
                ChatColor.RED + "Deals 20 magic damage",
                ChatColor.GOLD + "10 second cooldown",
                "",
                ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "\"The moon has fallen...\""
            );
            meta.setLore(lore);
            
            // Add enchantments for visual effect
            meta.addEnchant(Enchantment.SHARPNESS, 5, true);
            meta.addEnchant(Enchantment.UNBREAKING, 3, true);
            meta.addEnchant(Enchantment.MENDING, 1, true);
            
            // Add custom identifier
            meta.getPersistentDataContainer().set(getsugaKey, PersistentDataType.STRING, "true");
            
            sword.setItemMeta(meta);
        }
        
        return sword;
    }
    
    public boolean isGetsugaSword(ItemStack item) {
        if (item == null || !item.hasItemMeta()) {
            return false;
        }
        
        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().has(getsugaKey, PersistentDataType.STRING);
    }
    
    public NamespacedKey getGetsugaKey() {
        return getsugaKey;
    }
}