package fr.vcoding.sunessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.vcoding.sunessentials.Main;
import net.md_5.bungee.api.ChatColor;

public class VanishCommand implements CommandExecutor {

	private Main vanish;
	
	public VanishCommand(Main vanish) {
		this.vanish = vanish;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(!player.hasPermission("sun.vanish")) {
				player.sendMessage(ChatColor.RED + "You don't have permission.");
				return false;
			}
			
			if(args.length == 0) {
				vanish.toggleVanish(player);
			} else {
				String playerName = args[0];
				Player target = Bukkit.getServer().getPlayer(playerName);
				if(target != null && target.isOnline()) {
					vanish.toggleVanish(target);
				} else {
					player.sendMessage(ChatColor.RED + "The player you entered does not exist or is not connected!");
				}
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
			return false;
		}
		
		return false;
	}

}
