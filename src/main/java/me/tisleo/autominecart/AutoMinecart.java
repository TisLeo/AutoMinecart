package me.tisleo.autominecart;

import me.tisleo.autominecart.commands.CommandToggleCart;
import me.tisleo.autominecart.listeners.MinecartLeaveHandler;
import me.tisleo.autominecart.listeners.PlayerJoinHandler;
import me.tisleo.autominecart.listeners.RailClickHandler;
import me.tisleo.autominecart.listeners.VehicleMoveHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

public final class AutoMinecart extends JavaPlugin {

    /**
     * A list of players currently inside an AutoMinecart
     */
    private final ArrayList<Player> minecartUsers = new ArrayList<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();

        try {
            PlayerConfig.initPlayerConfig();
            PlayerConfig.getPlayersFileConfig().options().copyDefaults(true);
            PlayerConfig.savePlayerConfig();
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "There was an error creating the AutoMinecart player file. " +
                    "Please try to reload the plugin/server, or contact the developer under the 'Help' section at https://github.com/TisLeo/AutoMinecart");
            getPluginLoader().disablePlugin(this);
        }

        registerEvents();
        registerCommands();
    }

    /**
     * Registers event listeners
     */
    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new RailClickHandler(this), this);
        getServer().getPluginManager().registerEvents(new VehicleMoveHandler(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinHandler(), this);
        getServer().getPluginManager().registerEvents(new MinecartLeaveHandler(this), this);
    }

    /**
     * Sets executors for commands
     */
    private void registerCommands() {
        getCommand("togglecart").setExecutor(new CommandToggleCart());
    }

    public void addMinecartUser(Player p) {
        minecartUsers.add(p);
    }

    public ArrayList<Player> getMinecartUsers() {
        return this.minecartUsers;
    }

    public void removeMinecartUser(Player p) {
        minecartUsers.remove(p);
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "AutoMinecart has been disabled!");
    }
}
