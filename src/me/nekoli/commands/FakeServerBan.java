package me.nekoli.commands;

import me.nekoli.Main;
import me.nekoli.methods.API;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.stream.Stream;

import static org.bukkit.Bukkit.getServer;

public class FakeServerBan implements CommandExecutor {
	private Main plugin;
	private ConsoleCommandSender console = getServer().getConsoleSender();



	public FakeServerBan(final Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("FakeServerBan")) {
				if (sender.hasPermission("fsb.use")) {
					if (args.length == 0) {
						sender.sendMessage(API.c(plugin.getConfig().getString("General.NoArgument")));
						return true;
					}
					Player target = getServer().getPlayer(args[0]);
					if (target == null && !args[0].equals("reload")) {
						sender.sendMessage(API.c(plugin.getConfig().getString("General.NoPlayer").replace("%target%", (args[0]))));
						return true;
					}
					if (args.length == 1 && !args[0].equals("reload")) {
						this.plugin.targetedUser = getServer().getPlayer(args[0]);
						sender.sendMessage(API.c(plugin.getConfig().getString("General.OpenGUI").replace("%target%", target.getName())));
						openInventory((Player) sender);
						return true;
					}
				} else if (!sender.hasPermission("fsb.use")) {
					sender.sendMessage(API.c(plugin.getConfig().getString("General.NoPermission")));
					console.sendMessage(sender.getName() + " attempted to use the command /fakeserverban!");
					return true;
				}
			}
			if (cmd.getName().equalsIgnoreCase("FakeServerBan") || args.length == 1 || args[0].equalsIgnoreCase("reload")) {
				sender.sendMessage(API.c(plugin.getConfig().getString("General.Reload")));
				this.plugin.reloadConfig();
				return true;
			}
			if (!sender.hasPermission("fsb.reload")) {
				sender.sendMessage(API.c(plugin.getConfig().getString("General.NoPermission")));
				console.sendMessage(sender.getName() + " attempted to reload the plugin fakeserverban!");
				return true;
			}
		} else {
			sender.sendMessage(API.c(plugin.getConfig().getString("General.PlayerOnly")));

		}
		return true;
	}

	private void openInventory(final Player player) {
		Player target = this.plugin.targetedUser;
		final Inventory inv = Bukkit.createInventory(null, 27, "FakeServerBan");
		inv.setItem(10, build(Material.PAPER, "&fHypixel", " ", "&7Click to kick " + target.getName() + " &7with Hypixel message."));
		inv.setItem(11, build(Material.PAPER, "&fMineplex", " ", "&7Click to kick " + target.getName() + "&7with Mineplex message."));
		inv.setItem(12, build(Material.PAPER, "&fCubeCraft", " ", "&7Click to kick " + target.getName() + " &7with CubeCraft message."));
		inv.setItem(13, build(Material.PAPER, "&fGommeHD", " ", "&7Click to kick " + target.getName() + " &7with GommeHD message."));
		inv.setItem(14, build(Material.PAPER, "&fCosmicPrison", " ", "&7Click to kick " + target.getName() + " &7with CosmicPrison message."));
		inv.setItem(15, build(Material.PAPER, "&fSkycade", " ", "&7Click to kick " + target.getName() + " &7with Skycade message."));
		inv.setItem(16, build(Material.PAPER, "&fVeltPvP", " ", "&7Click to kick " + target.getName() + " &7with VeltPvP message."));
		inv.setItem(21, build(Material.PAPER, "&fInvadedLands", " ", "&7Click to kick " + target.getName() + " &7with InvadedLands message."));
		inv.setItem(22, build(Material.BOOK_AND_QUILL, "&cCustom", " ", "&7Click to kick " + target.getName() + " &7with Custom message."));
		inv.setItem(23, build(Material.PAPER, "&fMunchyMC", " ", "&7Click to kick " + target.getName() + " &7with MunchyMC message."));

		player.openInventory(inv);
	}



	private ItemStack build(Material type, String name, String... description) {
		ItemStack i = new ItemStack(type, 1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		if (description != null) {
			List<String> lore = Lists.newArrayList();
			Stream.of(description).forEach(line -> lore.add(ChatColor.translateAlternateColorCodes('&', line)));
			im.setLore(lore);
		}
		i.setItemMeta(im);
		return i;
	}
}