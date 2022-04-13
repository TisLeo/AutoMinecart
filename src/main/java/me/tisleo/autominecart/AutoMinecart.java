package me.tisleo.autominecart;

import org.bukkit.plugin.java.JavaPlugin;

public final class AutoMinecart extends JavaPlugin {

    //TODO: make cart have constant velocity.
    //TODO: fix multiple people bug

    @Override
    public void onEnable() {

        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new OnRailClick(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new OnMinecartLeave(this), this);
        getCommand("togglecart").setExecutor(new ToggleCart());
    }

}
