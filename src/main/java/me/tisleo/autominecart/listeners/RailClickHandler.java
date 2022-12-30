package me.tisleo.autominecart.listeners;

import me.tisleo.autominecart.AutoMinecart;
import me.tisleo.autominecart.PlayerConfig;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;

public class RailClickHandler implements Listener {

    private final AutoMinecart plugin;
    private static final Material[] validRails = {Material.RAIL, Material.DETECTOR_RAIL, Material.POWERED_RAIL};

    public RailClickHandler(AutoMinecart plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (!manageValidity(p, e)) {
            return;
        }

        Minecart minecart = p.getWorld().spawn(e.getClickedBlock().getLocation(), Minecart.class);
        plugin.addMinecartUser(p);
        minecart.addPassenger(p);
    }

    /**
     * Checks whether the player is valid to create and use a new AutoMinecart. To be valid, the player must:
     * <ol>
     *     <li>Be inside a world where the plugin is enabled</li>
     *     <li>Have permission to use the plugin</li>
     *     <li>Have the plugin toggled on for them (/togglecart command)</li>
     *     <li>Not be inside a vehicle</li>
     *     <li>Have right-clicked a valid rail with an empty main hand</li>
     * </ol>
     * @param p the player
     * @return whether the player is valid to create and use a new AutoMinecart.
     */
    private boolean manageValidity(Player p, PlayerInteractEvent e) {
        return !plugin.getConfig().getStringList("disabled_worlds").contains(p.getWorld().getName())
                && (p.isOp() || p.hasPermission("autominecart.use"))
                && (PlayerConfig.getPlayersFileConfig().getBoolean("players." + p.getUniqueId() + ".toggled"))
                && !p.isInsideVehicle()
                && (e.getAction() == Action.RIGHT_CLICK_BLOCK && Arrays.asList(validRails).contains(e.getClickedBlock().getType()) && p.getInventory().getItemInMainHand().getType().equals(Material.AIR));
    }

}


