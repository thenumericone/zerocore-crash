# Handle cooldowns
execute as @a if score @s getsuga_cooldown matches 1.. run scoreboard players remove @s getsuga_cooldown 1

# Detect Getsuga Tenshou usage (right-click with Getsuga sword)
execute as @a[scores={getsuga_rightclick=1..}] if items entity @s weapon.mainhand *[custom_data~{getsuga_sword:true}] run function getsuga:abilities/getsuga_tenshou

# Reset usage detection
scoreboard players set @a getsuga_rightclick 0

# Update projectile entities
execute as @e[tag=getsuga_projectile] at @s run function getsuga:abilities/projectile_tick