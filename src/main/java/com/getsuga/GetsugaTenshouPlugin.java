package com.getsuga;

import org.bukkit.plugin.java.JavaPlugin;

public class GetsugaTenshouPlugin extends JavaPlugin {
    
    private SwordManager swordManager;
    private AbilityManager abilityManager;
    
    @Override
    public void onEnable() {
        getLogger().info("Getsuga Tenshou Plugin has been enabled!");
        
        // Initialize managers
        swordManager = new SwordManager(this);
        abilityManager = new AbilityManager(this);
        
        // Register events
        getServer().getPluginManager().registerEvents(new SwordListener(abilityManager, swordManager), this);
        
        // Register commands
        getCommand("getsugasword").setExecutor(new SwordCommand(swordManager));
        
        getLogger().info("Getsuga Tenshou sword is ready for battle!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("Getsuga Tenshou Plugin has been disabled!");
    }
    
    public SwordManager getSwordManager() {
        return swordManager;
    }
    
    public AbilityManager getAbilityManager() {
        return abilityManager;
    }
}