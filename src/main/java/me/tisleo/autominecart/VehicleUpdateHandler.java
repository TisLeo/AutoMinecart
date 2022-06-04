package me.tisleo.autominecart;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import org.bukkit.util.Vector;

public class VehicleUpdateHandler implements Listener {

    private final AutoMinecart plugin;

    VehicleUpdateHandler(AutoMinecart plugin) {
        this.plugin = plugin;
    }
    private final Vector multiplier = new Vector(1.3D, 1D, 1.3D);

    @EventHandler
    public void onVehicleUpdate(VehicleUpdateEvent e) {
        if (!(e.getVehicle().getPassengers().isEmpty())) {
            for (Entity p : e.getVehicle().getPassengers()) {
                if (p instanceof Player && plugin.getAMUsers().contains(p)) {
                    e.getVehicle().setVelocity(e.getVehicle().getVelocity().multiply(multiplier));
                }
            }
        }
    }
}
