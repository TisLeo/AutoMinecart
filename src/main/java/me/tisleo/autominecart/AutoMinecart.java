package me.tisleo.autominecart;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;

public final class AutoMinecart extends JavaPlugin {

    ArrayList<String> header = new ArrayList<>();

    @Override
    public void onEnable() {
        header.add("+---------------------------------+\n" +
                "# |       AutoMinecart Config       |\n" +
                "# +---------------------------------+\n" +
                "\n" +
                "# WARNING: DO NOT CHANGE THE \"players:\" SECTION. IT WILL\n" +
                "# BREAK THE PLUGIN\n" +
                "\n" +
                "# Select which worlds you want AutoMinecart to be disabled in.\n" +
                "# Add a dash - and then put the world name in speech marks \"\"\n" +
                "# Like shown in the example below\n");
        getConfig().options().setHeader(header);
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new OnRailClick(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new OnMinecartLeave(), this);
        getCommand("togglecart").setExecutor(new ToggleCart());
        saveConfig();
    }

}
