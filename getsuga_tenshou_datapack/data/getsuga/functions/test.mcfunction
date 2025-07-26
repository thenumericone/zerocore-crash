# Test function for Getsuga Tenshou datapack
tellraw @s {"text":"Testing Getsuga Tenshou datapack...","color":"yellow"}

# Give the sword
function getsuga:give_sword

# Spawn some test mobs in front of the player
summon minecraft:zombie ^ ^ ^5 {CustomName:'{"text":"Test Target 1","color":"red"}'}
summon minecraft:skeleton ^ ^ ^10 {CustomName:'{"text":"Test Target 2","color":"red"}'}
summon minecraft:creeper ^ ^ ^15 {CustomName:'{"text":"Test Target 3","color":"red"}'}

tellraw @s {"text":"Test mobs spawned! Try using your Getsuga Tenshou sword!","color":"green"}