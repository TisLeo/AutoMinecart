package me.tisleo.autominecart;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class OnMinecartLeave implements Listener {

    @EventHandler
    public void onMinecartLeave(VehicleExitEvent e) {
        if (e.getVehicle() == OnRailClick.oldMinecart) {
            if (e.getExited() instanceof Player) {
                if (e.getExited() == OnRailClick.p) {
                    OnRailClick.oldMinecart.remove();
                    OnRailClick.p.teleport(OnRailClick.p.getLocation().add(0, 0.5, 0));
                }
            }
        }
    }

}
