# AutoMinecart
A useful Minecraft plugin that mimics the Terraria minecarts. Spawns a Minecart upon right-clicking any rail (excluding Activator Rails) with an empty hand and teleports the player into the cart. Then, it will automatically go at full speed depending on chosen direction.

The plugin was made with the [Paper 1.18 API](https://papermc.io/), and is compatible with Spigot servers from 1.18 onwards.

### **Features**
- Allows players to right-click a rail (excluding Activator Rails) with an empty and get teleported into an automatically-spawned minecart
- Automatically travels at max speed, similar to the Terraria minecarts
- Minecarts will automatically be deleted once a player gets out
- Add/remove disabled worlds in the `config.yml` file
- Use the permission `autominecart.use` to allow non-OP players to use the plugin
- Use the `/togglecart` command to toggle the functionality on or off for yourself
- **Note:** due to how Minecraft handles powered rails, if travelling over one, *it must be powered on*. Additionally, having too many corner rails close together may cause the vehicle to fly off-track due to speed.

### **Installation**
1. Go to the [Spigot Page](https://www.spigotmc.org/resources/autominecart.101327/)
2. Download the `.jar` file on the top right
3. Add the `.jar` file to your server's `plugins` folder
4. Reload/restart your server
5. Enjoy!

### **Help**
If you need help, please **start a conversation** with me on Spigot.

**This plugin was inspired by Kreezxil's [Terracart Reloaded Mod](https://www.curseforge.com/minecraft/mc-mods/terracart-reloaded)**
