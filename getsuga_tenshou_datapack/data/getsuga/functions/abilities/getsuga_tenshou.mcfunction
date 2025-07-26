# Check cooldown
execute if score @s getsuga_cooldown matches 1.. run return run title @s actionbar {"text":"Getsuga Tenshou on cooldown!","color":"red"}

# Set cooldown (100 ticks = 5 seconds)
scoreboard players set @s getsuga_cooldown 100

# Visual and sound effects
playsound minecraft:entity.ender_dragon.shoot player @a ~ ~ ~ 1 0.8
playsound minecraft:entity.lightning_bolt.thunder player @a ~ ~ ~ 0.5 1.5
particle minecraft:enchanted_hit ~ ~1 ~ 2 1 2 0.1 50

# Summon projectile marker
summon marker ^ ^1.5 ^2 {Tags:["getsuga_projectile","getsuga_new"],data:{damage:15,range:20,owner:""}}

# Set owner data
execute as @e[tag=getsuga_new,limit=1] run data modify entity @s data.owner set from entity @p UUID

# Initialize projectile
execute as @e[tag=getsuga_new,limit=1] at @s run function getsuga:abilities/init_projectile

# Give feedback
title @s actionbar {"text":"Getsuga Tenshou!","color":"dark_blue","bold":true}