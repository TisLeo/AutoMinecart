package me.tisleo.autominecart;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public final class AutoMinecart extends JavaPlugin {
    ArrayList<Player> AMUser;

    @Override
    public void onEnable() {
        AMUser = new ArrayList<>();
        List<String> playerFileHeader = new ArrayList<>();
        playerFileHeader.add("WARNING: DO NOT TOUCH THIS FILE.");
        saveDefaultConfig();
        PlayerConfig.initPlayerConfig();
        PlayerConfig.getPlayerConfig().options().setHeader(playerFileHeader);
        PlayerConfig.getPlayerConfig().options().copyDefaults(true);
        PlayerConfig.savePlayerConfig();
        getServer().getPluginManager().registerEvents(new RailClickHandler(this), this);
        getServer().getPluginManager().registerEvents(new VehicleUpdateHandler(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinHandler(), this);
        getServer().getPluginManager().registerEvents(new MinecartLeaveHandler(this), this);
        getCommand("togglecart").setExecutor(new CommandToggleCart());
    }

    public void addAMUser(Player p) {
        AMUser.add(p);
    }

    public ArrayList<Player> getAMUsers() {
        return this.AMUser;
    }

    public void removeAMUser(Player p) {
        AMUser.remove(p);
    }
}
