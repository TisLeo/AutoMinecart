package me.tisleo.autominecart;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleUpdateEvent;

public class VehicleUpdateHandler implements Listener {

    private final AutoMinecart plugin;

    VehicleUpdateHandler(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onVehicleUpdate(VehicleUpdateEvent e) {
        if (!(e.getVehicle().getPassengers().isEmpty())) {
            for (Entity p : e.getVehicle().getPassengers()) {
                if (p instanceof Player && plugin.getAMUsers().contains(p)) {
                    e.getVehicle().setVelocity(e.getVehicle().getVelocity().multiply(1.3));
                }
            }
        }
    }
}
