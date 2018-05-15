package me.nekoli;

import me.nekoli.methods.InventoryClick;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import me.nekoli.commands.FakeServerBan;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends JavaPlugin implements Listener {
	public static Main plugin;
	public Player targetedUser;
	ConsoleCommandSender console = getServer().getConsoleSender();

	public void onEnable() {
		console.sendMessage(" ");
		console.sendMessage("FakeServerBan has been enabled, Woahhh, I like it here! :)");
		console.sendMessage(" ");
		this.registerCommands();
		this.registerEvents();
		Main.plugin = this;
	}

	public void onDisable() {
		console.sendMessage(" ");
		console.sendMessage("FakeServerBan has been disabled, I hope this isn't forever! :(");
		console.sendMessage(" ");
		Main.plugin = null;
	}

	public void registerCommands() {
		this.getCommand("FakeServerBan").setExecutor(new FakeServerBan(this));
	}

	public void registerEvents() {
		final PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new InventoryClick(this), this);

	}
}
