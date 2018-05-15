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
		if (event.getWhoClicked() instanceof Player) {
			final Player p = (Player) event.getWhoClicked();
		}

		if (event.getClickedInventory() != null && event.getCurrentItem() != null
				&& event.getClickedInventory().getName().contains("FakeServerBan")) {
			switch (event.getCurrentItem().getType()) {
			case PAPER: {
				final Inventory inv = event.getInventory();
				final Player player = (Player) event.getWhoClicked();
				final ItemStack item = event.getCurrentItem();
				Player target = this.plugin.targetedUser;
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

				if (!inv.getName().contains("FakeServerBan") && !(event.getWhoClicked() instanceof Player)) {
					return;
				}
				if (event.getClickedInventory() == null) {
					return;
				}
				if (item.getItemMeta().getDisplayName().contains("Hypixel")) {
					target.kickPlayer( "§cYou are permanently banned from this server!\n§f\n§7Reason: §fWATCHDOG CHEAT DETECTION §7§o(VAPE-548931)\n§7Find out more: §b§nhttps://www.hypixel.net/watchdog§r\n§f\n§7Ban ID: §f#54CDF99E\n§7Sharing your Ban ID may affect the processing of your appeal!");
					player.sendMessage("§aSuccess! " + target.getName() + " was *banned*");
					console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (Hypixel)]");

				}

				if (item.getItemMeta().getDisplayName().contains("Mineplex")) {
					target.kickPlayer( "§cKicked whilst connecting to Lobby-14: §c§lYou are banned for 7.0 days\n§f[GWEN] Hacking [MB]\n§2Unfairly banned? Appeal at §awww.mineplex.com/appeals");
					player.sendMessage("§aSuccess! " + target.getName() + " was *banned*");
					console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (Mineplex)]");

				}
				if (item.getItemMeta().getDisplayName().contains("Cubecraft")) {
					target.kickPlayer( "§4§lTemporarily Banned!\n\n§cYou have been banned from §9CubeCraft §cfor:\n§6Sentinel caught you cheating! (Anticheat)\n\n§7Your ban will expire in:\n§c29 days and 23 hours\n\n§3You can appeal this ban at:\n§bappeals.cubecraft.net\n§3using the appeal code:\n§d6762");
					player.sendMessage("§aSuccess! " + target.getName() + " was *banned*");
					console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (Cubecraft)]");

				}
				if (item.getItemMeta().getDisplayName().contains("GommeHD")) {
					target.kickPlayer( "§cDu wurdest §4PERMANENT §cvom Netzwerk gebannt.\n§3Grund§7: §cHacking [R:59HHKx66]\n\n§aDu kannst auf §ewww.GommeHD.net §aeinen Entbannungsantrag stellen.");
					player.sendMessage("§aSuccess! " + target.getName() + " was *banned*");
					console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (GommeHD)]");

				}
				if (item.getItemMeta().getDisplayName().contains("CosmicPrison")) {
					target.kickPlayer( "§6You have been temporarily banned from this server for §eUnfair Advantage §f- To\n§fappeal, post in the appeals section on §bcosmicprisons.com\n\n§e§lTo make an appeal, go to: §b§nforum.cosmicprisons.com\n\n§c§lTo register your forum account, go to:\n§bhttps://wwww.cosmicprisons.com/forum/register.php?u=546984&c§b=DBAMvWMdhvtQbb3i");
					player.sendMessage("§aSuccess! " + target.getName() + " was *banned*");
					console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (CosmicPrison)]");

				}
				if (item.getItemMeta().getDisplayName().contains("Skycade")) {
					target.kickPlayer( "§cYou are banned from this server!\n\n§fBanned on: %now% \n§fBanned by: JackSucksAtMC\n§fReason: Malicious hacks\n\n§fYou are permanently banned!\n§fAppeal at: §nhttps://skycade.net");
					player.sendMessage("§aSuccess! " + target.getName() + " was *banned*");
					console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (Skycade)]");

				}
				if (item.getItemMeta().getDisplayName().contains("VeltPvP")) {
					target.kickPlayer( "§cYour account has been suspended from the VeltPvP Network\n\n§cAppeal at veltpvp.com/appeal");
					player.sendMessage("§aSuccess! " + target.getName() + " was *banned*");
					console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (VeltPvP)]");

				}
				if (item.getItemMeta().getDisplayName().contains("InvadedLands")) {
					target.kickPlayer( "§cYour account has been suspended from the network\n\n§4Banned on: §a" + format.format(date) + "\n§dBanned by: §aStaff\n§bReason: §6Cheating\n\n§cYour account is permanently suspended.\n§aAppeal at: §nwww.invadedlands.net");
					player.sendMessage("§aSuccess! " + target.getName() + " was *banned*");
					console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (InvadedLands)]");

				}
				if (item.getItemMeta().getDisplayName().contains("MunchyMC")) {
					target.kickPlayer( "§b§l[MunchyMC]\n§cYou have baeen banned");
					player.sendMessage("§aSuccess! " + target.getName() + " was *banned*");
					console.sendMessage("[" + player.getName() + ": FakeServerBanned " + target.getName() + " (MunchyMC)]");

				}
				event.setCancelled(true);
				player.closeInventory();
				break;
			}
			}
		}
	}
}
