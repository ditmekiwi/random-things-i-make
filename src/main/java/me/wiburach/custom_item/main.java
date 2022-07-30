package me.wiburach.custom_item;

import me.wiburach.custom_item.Commands.Commands;
import me.wiburach.custom_item.events.Events;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        Commands commands = new Commands();
        getServer().getPluginManager().registerEvents(new Events(),this);
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("farmtime").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ditmekiwi]: Plugin is enabled");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[ditmekiwi]: Plugin is disable");
    }

}
