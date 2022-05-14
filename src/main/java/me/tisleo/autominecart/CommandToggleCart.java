package me.tisleo.autominecart;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandToggleCart implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            if (sender.hasPermission("autominecart.use") || sender.isOp()) {
                if (command.getName().equals("togglecart")) {
                    if (PlayerConfig.getPlayerConfig().getBoolean("players."+((Player) sender).getUniqueId()+".toggled")) {
                        PlayerConfig.getPlayerConfig().set("players."+((Player) sender).getUniqueId()+".toggled"
                                , false);
                        PlayerConfig.savePlayerConfig();
                        PlayerConfig.reloadPlayerConfig();
                        sender.sendMessage(ChatColor.YELLOW+"AutoMinecart has now been "+ChatColor.RED+"disabled"+ChatColor.YELLOW+" for you!");
                    } else {
                        PlayerConfig.getPlayerConfig().set("players."+((Player) sender).getUniqueId()+".toggled"
                                , true);
                        PlayerConfig.savePlayerConfig();
                        PlayerConfig.reloadPlayerConfig();
                        sender.sendMessage(ChatColor.YELLOW+"AutoMinecart has now been "+ChatColor.GREEN+"enabled"+ChatColor.YELLOW+" for you!");
                    }
                }
            } else
                sender.sendMessage(ChatColor.RED+"You do not have permission to use this command!");
        } else
            sender.sendMessage("Only players can use the /togglecart command!");

        return false;
    }
}
