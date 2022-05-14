package me.tisleo.autominecart;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RailClickHandler implements Listener {

    private final AutoMinecart plugin;

    RailClickHandler(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!p.isInsideVehicle()) {
            if (!(plugin.getConfig().getStringList("disabled_worlds").contains(p.getWorld().getName()))) {
                if (PlayerConfig.getPlayerConfig().getBoolean("players."+p.getUniqueId()+".toggled") && (p.isOp() || p.hasPermission("autominecart.use"))) {
                    if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() ==
                            Material.RAIL || e.getClickedBlock().getType() == Material.DETECTOR_RAIL
                            || e.getClickedBlock().getType() == Material.POWERED_RAIL)) {
                        if (p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                            Minecart minecart = (Minecart) p.getWorld().spawn(e.getClickedBlock().getLocation(), EntityType.MINECART.getEntityClass());
                            plugin.addAMUser(p);
                            minecart.addPassenger(p);
                        }
                    }
                }
            }
        }
    }
}


