package me.tisleo.autominecart.listeners;

import me.tisleo.autominecart.AutoMinecart;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

public class VehicleMoveHandler implements Listener {

    private final AutoMinecart plugin;
    private static final Vector multiplier = new Vector(1.3D, 1D, 1.3D);

    public VehicleMoveHandler(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onVehicleUpdate(VehicleMoveEvent e) {
        if (e.getVehicle().getPassengers().isEmpty() || !(e.getVehicle() instanceof Minecart)) {
            return;
        }

        for (Entity entity : e.getVehicle().getPassengers()) {
            if (!(entity instanceof Player && plugin.getMinecartUsers().contains(entity))) {
                return;
            }

            Minecart minecart = (Minecart) e.getVehicle();
            minecart.setVelocity(minecart.getVelocity().multiply(multiplier));
        }
    }
}
