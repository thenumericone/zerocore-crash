package com.getsuga;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SwordCommand implements CommandExecutor {
    
    private final SwordManager swordManager;
    
    public SwordCommand(SwordManager swordManager) {
        this.swordManager = swordManager;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }
        
        Player player = (Player) sender;
        
        if (!player.hasPermission("getsuga.sword")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to get the Getsuga Tenshou sword!");
            return true;
        }
        
        ItemStack sword = swordManager.createGetsugaSword();
        player.getInventory().addItem(sword);
        
        player.sendMessage(ChatColor.GREEN + "You have been given the legendary " + 
                          ChatColor.AQUA + ChatColor.BOLD + "Getsuga Tenshou" + 
                          ChatColor.GREEN + " sword!");
        player.sendMessage(ChatColor.YELLOW + "Right-click to unleash its power!");
        
        return true;
    }
}