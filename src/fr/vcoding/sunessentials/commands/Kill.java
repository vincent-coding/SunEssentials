package fr.vcoding.sunessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(!player.hasPermission("sun.kill")) {
				player.sendMessage(ChatColor.RED + "You don't have permission.");
				return false;
			}
			
			if(args.length == 0) {
				player.setHealth(0);
				return true;
			}
			
			if(args.length == 1) {
				String argument = args[0];
				Player target = Bukkit.getPlayer( argument );
				
				if(target != null && target.isOnline()) {
					target.setHealth(0);
					player.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.GREEN + " was killed!");
					return true;
				} else {
					player.sendMessage(ChatColor.RED + "The player you entered does not exist or is not connected!");
					return true;
				}
			}
			
			if(args.length > 1) {
				player.sendMessage(ChatColor.RED + "You can only kill to one player at a time!");
				return true;
			}
			
		} else {
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
			return true;
		}
		
		return false;
	}

}
