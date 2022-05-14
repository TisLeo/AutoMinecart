package me.tisleo.autominecart;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {

    private static File file;
    private static FileConfiguration playerFile;

    private static final Plugin plugin = AutoMinecart.getPlugin(AutoMinecart.class);

    public static void initPlayerConfig() {
        file = new File(plugin.getServer().getPluginManager().getPlugin("AutoMinecart").getDataFolder(), "players.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "There was an error creating the AutoMinecart player file. " +
                        "Please try to reload the plugin/server, or contact the developer under the 'Help' section at https://github.com/TisLeo/AutoMinecart");
            }
        }
        playerFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getPlayerConfig() {
        return playerFile;
    }

    public static void reloadPlayerConfig() {
        playerFile = YamlConfiguration.loadConfiguration(file);
    }

    public static void savePlayerConfig() {
        try {
            playerFile.save(file);
        } catch (IOException e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "There was an error saving AutoMinecart player file. " +
                    "Please try to reload the plugin/server, or contact the developer under the 'Help' section at https://github.com/TisLeo/AutoMinecart");
        }
    }

}
