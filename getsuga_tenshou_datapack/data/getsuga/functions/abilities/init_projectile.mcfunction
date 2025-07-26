# Remove new tag
tag @s remove getsuga_new

# Set initial motion and timer
scoreboard players set @s getsuga_timer 40

# Store facing direction
execute store result entity @s Rotation[0] float 1 run data get entity @p Rotation[0]
execute store result entity @s Rotation[1] float 1 run data get entity @p Rotation[1]

# Add visual effects
particle minecraft:soul_fire_flame ~ ~ ~ 0.5 0.5 0.5 0.1 20
particle minecraft:enchanted_hit ~ ~ ~ 1 1 1 0.1 30