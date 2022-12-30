package me.tisleo.autominecart.commands;

import me.tisleo.autominecart.PlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandToggleCart implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!manageValidity(command, sender)) {
            return false;
        }

        final boolean isToggled = PlayerConfig.getPlayersFileConfig().getBoolean("players."+((Player) sender).getUniqueId()+".toggled");
        if (isToggled) {
            PlayerConfig.getPlayersFileConfig().set("players."+((Player) sender).getUniqueId()+".toggled", false);
            PlayerConfig.savePlayerConfig();
            PlayerConfig.reloadPlayerConfig();

            sender.sendMessage(ChatColor.YELLOW + "AutoMinecart has now been " + ChatColor.RED + "disabled" + ChatColor.YELLOW + " for you!");
        } else {
            PlayerConfig.getPlayersFileConfig().set("players."+((Player) sender).getUniqueId()+".toggled", true);
            PlayerConfig.savePlayerConfig();
            PlayerConfig.reloadPlayerConfig();

            sender.sendMessage(ChatColor.YELLOW + "AutoMinecart has now been " + ChatColor.GREEN + "enabled" + ChatColor.YELLOW + " for you!");
        }

        return true;
    }

    /**
     * Checks whether the command and sender are valid to execute the /togglecart command. If at any stage the validity
     * is not met, the sender is sent a messages stating why. To use the command, the sender must:
     * <ol>
     *     <li>Be a player</li>
     *     <li>Use the correct command ("/togglecart")</li>
     *     <li>Have permission to use the command (autominecart.use) or have OP</li>
     * </ol>
     * @param command the command
     * @param sender the command sender
     * @return whether the command and sender are valid for the /togglecart command
     */
    private boolean manageValidity(Command command, CommandSender sender) {
        if (!command.getName().equals("togglecart")) {
            return false;
        } else if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use the /togglecart command!");
            return false;
        } else if (!sender.hasPermission("autominecart.use") && !sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            return false;
        }

        return true;
    }
}
