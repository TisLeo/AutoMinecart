package me.tisleo.autominecart.listeners;

import me.tisleo.autominecart.PlayerConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinHandler implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (!(PlayerConfig.getPlayersFileConfig().isSet("players." + e.getPlayer().getUniqueId()))) {
            PlayerConfig.getPlayersFileConfig().set("players."+e.getPlayer().getUniqueId()+".toggled", true);
            PlayerConfig.savePlayerConfig();
            PlayerConfig.reloadPlayerConfig();
        }
    }

}
