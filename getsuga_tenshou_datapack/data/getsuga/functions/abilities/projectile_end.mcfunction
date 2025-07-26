# Final explosion effect
particle minecraft:explosion ~ ~ ~ 1 1 1 0.1 5
particle minecraft:soul_fire_flame ~ ~ ~ 2 2 2 0.1 30
playsound minecraft:entity.generic.explode player @a ~ ~ ~ 0.5 1.2

# Remove hit tags from all entities
tag @e remove getsuga_hit

# Remove the projectile
kill @s