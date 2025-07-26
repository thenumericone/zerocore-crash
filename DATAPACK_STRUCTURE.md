# Getsuga Tenshou Datapack Structure

```
getsuga_tenshou_datapack/
├── pack.mcmeta                                    # Datapack metadata
└── data/
    ├── minecraft/
    │   └── tags/
    │       └── functions/
    │           ├── load.json                      # Load tag
    │           └── tick.json                      # Tick tag
    └── getsuga/
        ├── functions/
        │   ├── abilities/
        │   │   ├── damage_entity.mcfunction       # Entity damage handler
        │   │   ├── getsuga_tenshou.mcfunction     # Main ability function
        │   │   ├── init_projectile.mcfunction     # Projectile initialization
        │   │   ├── projectile_end.mcfunction      # Projectile cleanup
        │   │   └── projectile_tick.mcfunction     # Projectile movement
        │   ├── give_sword.mcfunction              # Give sword command
        │   ├── load.mcfunction                    # Datapack initialization
        │   ├── test.mcfunction                    # Testing function
        │   └── tick.mcfunction                    # Main tick function
        └── item_modifiers/
            └── getsuga_sword.json                 # Sword item modifier
```

## File Descriptions

### Core Functions
- **load.mcfunction**: Sets up scoreboards and teams
- **tick.mcfunction**: Handles cooldowns and ability detection
- **give_sword.mcfunction**: Gives the player the Getsuga Tenshou sword

### Ability System
- **getsuga_tenshou.mcfunction**: Main ability handler with cooldown checks
- **init_projectile.mcfunction**: Sets up projectile properties
- **projectile_tick.mcfunction**: Handles projectile movement and effects
- **damage_entity.mcfunction**: Applies damage and knockback to entities
- **projectile_end.mcfunction**: Cleanup when projectile ends

### Configuration
- **pack.mcmeta**: Datapack metadata for Minecraft 1.21.4
- **load.json/tick.json**: Function tags for automatic execution
- **getsuga_sword.json**: Item modifier for sword properties

### Testing
- **test.mcfunction**: Spawns test mobs and gives sword for testing

## Key Features Implemented

1. **Right-click Detection**: Uses `minecraft.used:minecraft.netherite_sword` statistic
2. **Custom Item Components**: Uses 1.21.4 item component system
3. **Projectile System**: Marker entity with visual effects and collision detection
4. **Damage System**: Magic damage with knockback effects
5. **Cooldown System**: 5-second cooldown with actionbar feedback
6. **Visual Effects**: Particles, sounds, and special effects
7. **Smart Targeting**: Prevents hitting the same entity multiple times