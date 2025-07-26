# Decrease timer
scoreboard players remove @s getsuga_timer 1

# Remove if timer reaches 0
execute if score @s getsuga_timer matches ..0 run return run function getsuga:abilities/projectile_end

# Move forward
tp @s ^ ^ ^1.5

# Check for blocks (stop on solid blocks except air)
execute unless block ~ ~ ~ #minecraft:air run return run function getsuga:abilities/projectile_end

# Visual effects
particle minecraft:soul_fire_flame ~ ~ ~ 0.3 0.3 0.3 0.05 15
particle minecraft:enchanted_hit ~ ~ ~ 0.5 0.5 0.5 0.02 10
particle minecraft:electric_spark ~ ~ ~ 0.8 0.8 0.8 0.1 8

# Damage entities in range (excluding the player who cast it and already hit entities)
execute as @e[type=!player,type=!marker,type=!armor_stand,type=!item,distance=..2.5,tag=!getsuga_hit] at @s run function getsuga:abilities/damage_entity

# Special effects for hostile mobs
execute as @e[type=#minecraft:hostile,distance=..2.5] at @s run particle minecraft:damage_indicator ~ ~1 ~ 0.5 0.5 0.5 0.1 5