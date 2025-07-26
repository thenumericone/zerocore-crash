# Getsuga Tenshou Datapack Load Function
tellraw @a {"text":"Getsuga Tenshou Datapack Loaded!","color":"dark_blue","bold":true}

# Create scoreboards
scoreboard objectives add getsuga_cooldown dummy
scoreboard objectives add getsuga_rightclick minecraft.used:minecraft.netherite_sword
scoreboard objectives add getsuga_timer dummy

# Set up team for visual effects
team add getsuga_effect
team modify getsuga_effect color dark_blue