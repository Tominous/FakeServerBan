package me.nekoli.methods;

import me.nekoli.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

public class API implements Listener {
    private static Main plugin;

    public static String c(final String inputString) {
        return ChatColor.translateAlternateColorCodes('&', inputString);
    }

}
