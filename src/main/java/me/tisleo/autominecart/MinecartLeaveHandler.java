package me.tisleo.autominecart;

import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class MinecartLeaveHandler implements Listener {

    private final AutoMinecart plugin;

    MinecartLeaveHandler(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMinecartLeave(VehicleExitEvent e) {
        if (e.getExited() instanceof Player && e.getVehicle() instanceof Minecart) {
            if (plugin.getAMUsers().contains(e.getExited())) {
                e.getVehicle().remove();
                plugin.removeAMUser((Player) e.getExited());
                ((Player) e.getExited()).getPlayer().teleport(((Player) e.getExited()).getPlayer().getLocation().add(0, 0.5, 0));
            }
        }
    }

}
