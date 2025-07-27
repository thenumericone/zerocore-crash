# Getsuga Tenshou Sword Plugin

A Minecraft 1.21.4 Bukkit/Spigot plugin that adds a legendary sword with the "Getsuga Tenshou" ability - a powerful horizontal projectile attack inspired by Bleach anime.

## Features

- **Custom Netherite Sword**: Enhanced with enchantments and custom name/lore
- **Getsuga Tenshou Ability**: Right-click to unleash a horizontal energy projectile
- **10-Second Cooldown**: Balanced gameplay with proper cooldown system
- **20 Magic Damage**: Bypasses armor for consistent damage
- **Visual Effects**: Soul fire flames, electric sparks, and enchanted particles
- **Sound Effects**: Dragon breath, thunder, and explosion sounds
- **Permission System**: Configurable permissions for getting and using the sword

## Installation

1. Download or compile the plugin JAR file
2. Place it in your server's `plugins` folder
3. Restart the server or use `/reload` (not recommended for production)
4. The plugin will automatically create necessary configuration

## Commands

- `/getsugasword` - Give yourself the Getsuga Tenshou sword
  - **Permission**: `getsuga.sword` (default: op)
  - **Usage**: `/getsugasword`

## Permissions

- `getsuga.sword` - Allows getting the Getsuga Tenshou sword (default: op)
- `getsuga.use` - Allows using the Getsuga Tenshou ability (default: true)

## How to Use

1. Get the sword using `/getsugasword` command
2. Hold the sword in your main hand
3. Right-click to activate the Getsuga Tenshou ability
4. Watch as a horizontal energy projectile travels forward
5. Wait for the 10-second cooldown before using again

## Technical Details

### Sword Stats
- **Base Item**: Netherite Sword
- **Enchantments**: Sharpness V, Unbreaking III, Mending I
- **Custom Name**: 月牙天衝 (Getsuga Tenshou)
- **Identifier**: Custom NBT tag for ability recognition

### Ability Mechanics
- **Damage**: 20 magic damage (bypasses armor)
- **Range**: 30 blocks (60 blocks total travel)
- **Speed**: 2 blocks per tick
- **Damage Radius**: 2.5 blocks around projectile
- **Cooldown**: 10 seconds (200 ticks)
- **Knockback**: Applied to hit entities

### Visual Effects
- **Projectile Trail**: Soul fire flames, enchanted particles, electric sparks
- **Hit Effect**: Critical magic particles and lightning bolt impact sound
- **End Explosion**: Explosion particle and sound when projectile ends

## Building from Source

### Prerequisites
- Java 21 or higher
- Maven 3.6 or higher
- Spigot 1.21.4 (will be downloaded automatically)

### Build Steps
1. Clone the repository
2. Navigate to the project directory
3. Run `mvn clean package`
4. The compiled JAR will be in the `target` directory

### Maven Command
```bash
mvn clean package
```

## Configuration

Currently, the plugin uses hardcoded values. Future versions may include:
- Configurable damage values
- Adjustable cooldown times
- Customizable visual effects
- Multiple sword variants

## Compatibility

- **Minecraft Version**: 1.21.4
- **Server Software**: Bukkit, Spigot, Paper
- **Java Version**: 21 or higher
- **Dependencies**: None (standalone plugin)

## Known Issues

- None currently reported

## Future Enhancements

- Configuration file for customizable settings
- Multiple Getsuga techniques
- Sword upgrade system
- Custom crafting recipes
- Integration with other plugins

## Support

For issues, suggestions, or contributions:
1. Check existing issues in the repository
2. Create a new issue with detailed information
3. Include server version and plugin version
4. Provide error logs if applicable

## Credits

- Inspired by the Getsuga Tenshou technique from Bleach manga/anime
- Created for Minecraft 1.21.4 using Bukkit/Spigot API
- Developed with modern Java practices and Maven build system

## License

This project is open source. See LICENSE file for details.

---

**Enjoy unleashing the power of Getsuga Tenshou in your Minecraft world!**