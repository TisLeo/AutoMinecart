package me.tisleo.autominecart;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

import java.util.logging.Level;

public class OnMinecartLeave implements Listener {

    private final AutoMinecart plugin;

    OnMinecartLeave(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMinecartLeave(VehicleExitEvent e) {

        if (plugin.getConfig().getBoolean("remove_minecart_on_exit")) {
            if (e.getVehicle() == OnRailClick.minecart) {
                if (e.getExited() instanceof Player) {
                    if (e.getVehicle().getPassengers().toArray().length == 1) {
                        e.getVehicle().remove();
                        ((Player) e.getExited()).getPlayer().teleport(((Player) e.getExited()).getPlayer().getLocation().add(0, 0.5, 0));
                    }
                }
            }
        }
    }

}
