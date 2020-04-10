package me.sybsuper.SybChunkRegen;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender.hasPermission("sybcunkregen.regenerate")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				World w = p.getWorld();
				Chunk c = p.getLocation().getChunk();
				w.regenerateChunk(c.getX(), c.getZ());
				p.sendMessage("Successfully regenerated chunk.");
			} else {
				sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command.");
		}
		return true;
	}
}
