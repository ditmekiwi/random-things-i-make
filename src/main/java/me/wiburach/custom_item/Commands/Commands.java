package me.wiburach.custom_item.Commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Locale;

public class Commands  implements CommandExecutor {

    @Override
    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("chỉ có người chơi mới có thể sử dụng lệnh này");
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("heal")) {
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage(ChatColor.AQUA + "(!) bạn đã được hồi máu");
        }

       else if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
        player.sendMessage(ChatColor.AQUA + "(!) bạn đã no");
       }

       else if (cmd.getName().equalsIgnoreCase("farmtime")) {
           if (args.length  >= 2) {
               try {
               EntityType enity = EntityType.valueOf(args[0].toUpperCase());
               int amount = Integer.parseInt(args[1]);
               for (int i = 0; i < amount; i++) {
                   player.getWorld().spawnEntity(player.getLocation(), enity);
                   }
               } catch (IllegalArgumentException e) {
                   player.sendMessage(ChatColor.AQUA + "(!) Thực thể này không tồn tại trong game");
               }
           } else {
               player.sendMessage(ChatColor.AQUA + "(!) /farmtime <mob> <amount>");
           }
        }

        return true;
    }
}
