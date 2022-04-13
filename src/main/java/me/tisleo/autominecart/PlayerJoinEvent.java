package me.tisleo.autominecart;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class PlayerJoinEvent implements Listener {

    private final Plugin plugin;

    public PlayerJoinEvent(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        if (!(plugin.getConfig().isSet("players." + e.getPlayer().getUniqueId()))) {
            plugin.getConfig().set("players."+e.getPlayer().getUniqueId(), ".toggled");
            plugin.getConfig().set("players."+e.getPlayer().getUniqueId()+".toggled", true);
            plugin.saveConfig();
            plugin.reloadConfig();
        }
    }

}
