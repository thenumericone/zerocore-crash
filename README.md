# Getsuga Tenshou Sword Datapack

A Minecraft 1.21.4 datapack that adds a legendary sword with the "Getsuga Tenshou" ability - a powerful horizontal projectile attack that damages entities in its path.

## Features

- **Custom Sword**: Netherite sword with enhanced damage (12 attack damage) and custom name/lore
- **Getsuga Tenshou Ability**: Right-click to unleash a horizontal energy projectile
- **Visual Effects**: Soul fire flames, enchanted particles, and electric sparks
- **Sound Effects**: Dragon breath, thunder, and explosion sounds
- **Cooldown System**: 5-second cooldown between uses
- **Smart Targeting**: Damages all entities except the caster, with knockback effects

## Installation

1. Download the `getsuga_tenshou_datapack` folder
2. Place it in your world's `datapacks` folder:
   - Single player: `.minecraft/saves/[world_name]/datapacks/`
   - Server: `[server_folder]/[world_name]/datapacks/`
3. Reload the world or restart the server
4. Run `/reload` command if needed

## Usage

### Getting the Sword
Run the following command to get the Getsuga Tenshou sword:
```
/function getsuga:give_sword
```

### Using the Ability
1. Hold the Getsuga Tenshou sword in your main hand
2. Right-click to activate the Getsuga Tenshou ability
3. Watch as a horizontal energy projectile travels forward, damaging enemies in its path
4. Wait for the 5-second cooldown before using again

## Technical Details

### Damage
- Sword base damage: 12 (6 hearts)
- Getsuga Tenshou projectile damage: 30 (15 hearts)
- Damage type: Magic damage (bypasses armor)

### Range and Duration
- Projectile travels up to 60 blocks (40 ticks × 1.5 blocks/tick)
- Damage radius: 2.5 blocks around the projectile
- Cooldown: 100 ticks (5 seconds)

### Visual Effects
- Soul fire flames and enchanted particles trail
- Electric sparks and damage indicators
- Explosion effect when projectile ends
- Custom blue-themed particle effects

## Compatibility

- **Minecraft Version**: 1.21.4
- **Pack Format**: 48
- **Dependencies**: None
- **Conflicts**: Should work with most other datapacks

## Commands

- `/function getsuga:give_sword` - Get the Getsuga Tenshou sword
- `/function getsuga:load` - Manually reload the datapack (usually automatic)

## Troubleshooting

If the ability isn't working:
1. Make sure you're holding the correct sword (check the name and lore)
2. Verify the datapack is loaded with `/datapack list`
3. Try reloading with `/reload`
4. Check that you're not on cooldown (actionbar will show cooldown message)

## Credits

Inspired by the Getsuga Tenshou technique from the anime/manga Bleach.
Created for Minecraft 1.21.4 using the latest datapack format and item components.
