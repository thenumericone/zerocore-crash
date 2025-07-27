package com.getsuga;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SwordListener implements Listener {
    
    private final AbilityManager abilityManager;
    private final SwordManager swordManager;
    
    public SwordListener(AbilityManager abilityManager, SwordManager swordManager) {
        this.abilityManager = abilityManager;
        this.swordManager = swordManager;
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        // Check if player right-clicked
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        
        // Check if item is the Getsuga Tenshou sword
        if (!isGetsugaSword(item)) {
            return;
        }
        
        // Cancel the default interaction
        event.setCancelled(true);
        
        // Use the Getsuga Tenshou ability
        abilityManager.useGetsugaTenshou(player);
    }
    
    private boolean isGetsugaSword(ItemStack item) {
        return swordManager.isGetsugaSword(item);
    }
}