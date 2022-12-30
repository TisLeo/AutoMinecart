package me.tisleo.autominecart;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PlayerConfig {

    private static File playersFile;
    private static FileConfiguration playersFileConfig;
    private static final Plugin plugin = AutoMinecart.getPlugin(AutoMinecart.class);

    public static void initPlayerConfig() throws IOException {
        playersFile = new File(plugin.getServer().getPluginManager().getPlugin("AutoMinecart").getDataFolder(), "players.yml");

        if (!playersFile.exists()) {
            playersFile.createNewFile();
        }

        playersFileConfig = YamlConfiguration.loadConfiguration(playersFile);

        setHeader();
    }

    private static void setHeader() {
        List<String> playerFileHeader = new ArrayList<>();
        playerFileHeader.add("WARNING: DO NOT TOUCH THIS FILE OR THE PLUGIN MAY BREAK.");
        getPlayersFileConfig().options().setHeader(playerFileHeader);
    }

    public static FileConfiguration getPlayersFileConfig() {
        return playersFileConfig;
    }

    public static void reloadPlayerConfig() {
        playersFileConfig = YamlConfiguration.loadConfiguration(playersFile);
    }

    public static void savePlayerConfig() {
        try {
            playersFileConfig.save(playersFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "There was an error saving the AutoMinecart player file. " +
                    "Please try to reload the plugin/server, or contact the developer under the 'Help' section at https://github.com/TisLeo/AutoMinecart");
        }
    }
}
