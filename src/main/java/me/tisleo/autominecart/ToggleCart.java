package me.tisleo.autominecart;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ToggleCart implements CommandExecutor {
    private final Plugin plugin = AutoMinecart.getPlugin(AutoMinecart.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            if (sender.hasPermission("autominecart.use") || sender.isOp()) {
                if (command.getName().equals("togglecart")) {
                    plugin.getConfig().options().copyDefaults();
                    if (plugin.getConfig().getBoolean("players."+((Player) sender).getUniqueId().toString()+".toggled")) {
                        plugin.getConfig().set("players."+((Player) sender).getUniqueId()+".toggled"
                                , false);
                        plugin.saveConfig();
                        plugin.reloadConfig();
                        sender.sendMessage(ChatColor.YELLOW+"AutoMinecart has now been "+ChatColor.RED+"disabled"+ChatColor.YELLOW+" for you!");
                    } else {
                        plugin.getConfig().set("players."+((Player) sender).getUniqueId()+".toggled"
                                , true);
                        plugin.saveConfig();
                        plugin.reloadConfig();
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
