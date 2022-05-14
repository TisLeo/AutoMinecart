package me.tisleo.autominecart;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinHandler implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        PlayerConfig.getPlayerConfig().options().copyDefaults();
        if (!(PlayerConfig.getPlayerConfig().isSet("players." + e.getPlayer().getUniqueId()))) {
            PlayerConfig.getPlayerConfig().set("players."+e.getPlayer().getUniqueId(), ".toggled");
            PlayerConfig.getPlayerConfig().set("players."+e.getPlayer().getUniqueId()+".toggled", true);
            PlayerConfig.savePlayerConfig();
            PlayerConfig.reloadPlayerConfig();
        }
    }

}
