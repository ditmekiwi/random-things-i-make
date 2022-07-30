package me.wiburach.custom_item.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Events implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.BLUE + "Chào mừng đến server bọn wibu");
    }

    @EventHandler
    public void onPlayerWalk(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        Material block = player.getWorld().getBlockAt(x, y-1, z).getType();
        if (block == Material.STONE) {
            player.sendMessage(ChatColor.GREEN + "dit me thang nguyen nhat minh");
        }
    }
}

