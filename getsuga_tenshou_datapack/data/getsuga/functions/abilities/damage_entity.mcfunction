# Mark as hit to prevent multiple hits
tag @s add getsuga_hit

# Apply damage (15 hearts)
damage @s 30 minecraft:magic

# Visual and sound effects
particle minecraft:sweep_attack ~ ~1 ~ 0.5 0.5 0.5 0.1 3
particle minecraft:crit ~ ~1 ~ 0.8 0.8 0.8 0.1 15
playsound minecraft:entity.player.attack.crit player @a ~ ~ ~ 0.8 0.8

# Simple knockback effect in the direction of the projectile
execute store result score #getsuga_yaw getsuga_timer run data get entity @e[tag=getsuga_projectile,limit=1] Rotation[0] 1
execute if score #getsuga_yaw getsuga_timer matches 0..45 run data modify entity @s Motion set value [1.0d, 0.4d, 0.0d]
execute if score #getsuga_yaw getsuga_timer matches 46..135 run data modify entity @s Motion set value [0.0d, 0.4d, 1.0d]
execute if score #getsuga_yaw getsuga_timer matches 136..225 run data modify entity @s Motion set value [-1.0d, 0.4d, 0.0d]
execute if score #getsuga_yaw getsuga_timer matches 226..315 run data modify entity @s Motion set value [0.0d, 0.4d, -1.0d]
execute if score #getsuga_yaw getsuga_timer matches 316..360 run data modify entity @s Motion set value [1.0d, 0.4d, 0.0d]