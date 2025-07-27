package com.getsuga;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AbilityManager {
    
    private final GetsugaTenshouPlugin plugin;
    private final Map<UUID, Long> cooldowns;
    private final int COOLDOWN_SECONDS = 10;
    private final double MAGIC_DAMAGE = 20.0;
    private final double PROJECTILE_SPEED = 2.0;
    private final int PROJECTILE_RANGE = 30;
    private final double DAMAGE_RADIUS = 2.5;
    
    public AbilityManager(GetsugaTenshouPlugin plugin) {
        this.plugin = plugin;
        this.cooldowns = new HashMap<>();
    }
    
    public boolean useGetsugaTenshou(Player player) {
        UUID playerId = player.getUniqueId();
        
        // Check cooldown
        if (isOnCooldown(playerId)) {
            long timeLeft = getRemainingCooldown(playerId);
            player.sendMessage(ChatColor.RED + "Getsuga Tenshou is on cooldown for " + timeLeft + " more seconds!");
            return false;
        }
        
        // Check permission
        if (!player.hasPermission("getsuga.use")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use Getsuga Tenshou!");
            return false;
        }
        
        // Set cooldown
        cooldowns.put(playerId, System.currentTimeMillis());
        
        // Launch the Getsuga Tenshou projectile
        launchGetsugaTenshou(player);
        
        return true;
    }
    
    private void launchGetsugaTenshou(Player player) {
        Location startLocation = player.getEyeLocation();
        Vector direction = startLocation.getDirection().normalize();
        
        // Play initial sound and effects
        player.getWorld().playSound(startLocation, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 0.5f);
        player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, startLocation, 30, 0.5, 0.5, 0.5, 0.1);
        
        // Send message to player
        player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "GETSUGA TENSHOU!");
        
        new BukkitRunnable() {
            private int ticks = 0;
            private Location currentLocation = startLocation.clone();
            
            @Override
            public void run() {
                if (ticks >= PROJECTILE_RANGE) {
                    // End of projectile range
                    createEndExplosion();
                    cancel();
                    return;
                }
                
                // Move projectile forward
                currentLocation.add(direction.clone().multiply(PROJECTILE_SPEED));
                
                // Check for solid blocks
                if (currentLocation.getBlock().getType().isSolid()) {
                    createEndExplosion();
                    cancel();
                    return;
                }
                
                // Create visual effects
                createProjectileEffects();
                
                // Damage nearby entities
                damageNearbyEntities(player);
                
                ticks++;
            }
            
            private void createProjectileEffects() {
                World world = currentLocation.getWorld();
                if (world != null) {
                    // Main projectile particles
                    world.spawnParticle(Particle.SOUL_FIRE_FLAME, currentLocation, 10, 0.3, 0.3, 0.3, 0.05);
                    world.spawnParticle(Particle.ENCHANT, currentLocation, 15, 0.5, 0.5, 0.5, 0.1);
                    world.spawnParticle(Particle.ELECTRIC_SPARK, currentLocation, 5, 0.2, 0.2, 0.2, 0.05);
                    
                    // Sound effect
                    if (ticks % 5 == 0) {
                        world.playSound(currentLocation, Sound.BLOCK_CONDUIT_AMBIENT, 0.3f, 1.5f);
                    }
                }
            }
            
            private void damageNearbyEntities(Player caster) {
                World world = currentLocation.getWorld();
                if (world == null) return;
                
                for (Entity entity : world.getNearbyEntities(currentLocation, DAMAGE_RADIUS, DAMAGE_RADIUS, DAMAGE_RADIUS)) {
                    if (entity instanceof LivingEntity && !entity.equals(caster)) {
                        LivingEntity target = (LivingEntity) entity;
                        
                        // Deal magic damage
                        target.damage(MAGIC_DAMAGE, caster);
                        
                        // Apply knockback
                        Vector knockback = target.getLocation().toVector().subtract(currentLocation.toVector()).normalize();
                        knockback.multiply(1.5).setY(0.5);
                        target.setVelocity(knockback);
                        
                        // Visual and sound effects for hit
                        world.spawnParticle(Particle.CRIT_MAGIC, target.getLocation().add(0, 1, 0), 20, 0.5, 0.5, 0.5, 0.1);
                        world.playSound(target.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 0.7f, 1.2f);
                        
                        // Send damage message to caster
                        if (caster instanceof Player) {
                            caster.sendMessage(ChatColor.YELLOW + "Getsuga Tenshou hit " + 
                                             ChatColor.WHITE + target.getName() + 
                                             ChatColor.YELLOW + " for " + 
                                             ChatColor.RED + MAGIC_DAMAGE + 
                                             ChatColor.YELLOW + " magic damage!");
                        }
                    }
                }
            }
            
            private void createEndExplosion() {
                World world = currentLocation.getWorld();
                if (world != null) {
                    world.spawnParticle(Particle.EXPLOSION, currentLocation, 1);
                    world.spawnParticle(Particle.ELECTRIC_SPARK, currentLocation, 50, 2, 2, 2, 0.3);
                    world.playSound(currentLocation, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 0.8f);
                }
            }
            
        }.runTaskTimer(plugin, 0L, 1L);
    }
    
    private boolean isOnCooldown(UUID playerId) {
        if (!cooldowns.containsKey(playerId)) {
            return false;
        }
        
        long timePassed = System.currentTimeMillis() - cooldowns.get(playerId);
        return timePassed < (COOLDOWN_SECONDS * 1000L);
    }
    
    private long getRemainingCooldown(UUID playerId) {
        if (!cooldowns.containsKey(playerId)) {
            return 0;
        }
        
        long timePassed = System.currentTimeMillis() - cooldowns.get(playerId);
        long timeLeft = (COOLDOWN_SECONDS * 1000L) - timePassed;
        return Math.max(0, timeLeft / 1000L);
    }
}