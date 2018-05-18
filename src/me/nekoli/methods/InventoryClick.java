package me.nekoli.methods;

import me.nekoli.Main;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.bukkit.Bukkit.getServer;

public class InventoryClick implements Listener {
	private Main plugin;
	private ConsoleCommandSender console = getServer().getConsoleSender();
	public InventoryClick(final Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onClick(final InventoryClickEvent event) {
		if (event.getClickedInventory() != null && event.getCurrentItem() != null && event.getClickedInventory().getName().contains("FakeServerBan")) {
			switch (event.getCurrentItem().getType()) {
				case PAPER:
				case BOOK_AND_QUILL:
					{
					final Inventory inv = event.getInventory();
					final Player player = (Player) event.getWhoClicked();
					final ItemStack item = event.getCurrentItem();
					Player target = this.plugin.targetedUser;
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

					if (!inv.getName().contains("FakeServerBan") && !(event.getWhoClicked() instanceof Player)) {
						return;
					}
					if (event.getClickedInventory() == null){
						return;
					}
					if (item.getItemMeta().getDisplayName().contains("Hypixel")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("Hypixel.Message").replace("%date%", format.format(date))));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (Hypixel)]");
					}
					if (item.getItemMeta().getDisplayName().contains("Mineplex")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("Mineplex.Message").replace("%date%", format.format(date))));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (Mineplex)]");
					}
					if (item.getItemMeta().getDisplayName().contains("CubeCraft")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("CubeCraft.Message").replace("%date%", format.format(date))));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (Cubecraft)]");
					}
					if (item.getItemMeta().getDisplayName().contains("GommeHD")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("GommeHD.Message").replace("%date%", format.format(date))));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (GommeHD)]");
					}
					if (item.getItemMeta().getDisplayName().contains("CosmicPrison")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("CosmicPrison.Message").replace("%date%", format.format(date))));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (CosmicPrison)]");
					}
					if (item.getItemMeta().getDisplayName().contains("Skycade")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("Skycade.Message").replace("%date%", format.format(date))));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (Skycade)]");
					}
					if (item.getItemMeta().getDisplayName().contains("VeltPvP")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("VeltPvP.Message").replace("%date%", format.format(date))));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (VeltPvP)]");
					}
					if (item.getItemMeta().getDisplayName().contains("InvadedLands")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("InvadedLands.Message").replace("%date%", format.format(date))));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (InvadedLands)]");
					}
					if (item.getItemMeta().getDisplayName().contains("MunchyMC")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("MunchyMC.Message")));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (MunchyMC)]");
					}
					if (item.getItemMeta().getDisplayName().contains("Custom")) {
						target.kickPlayer(API.c(plugin.getConfig().getString("Custom.Message")));
						player.sendMessage(API.c(plugin.getConfig().getString("General.Success").replace("%target%", target.getName())));
						console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (Custom)]");
					}
					event.setCancelled(true);
					player.closeInventory();
					break;
				}
			}
		}
	}
}
