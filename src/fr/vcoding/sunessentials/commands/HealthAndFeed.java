package fr.vcoding.sunessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class HealthAndFeed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//TODO: Health
		if(cmd.getName().equalsIgnoreCase("health")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.health")) {
					player.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				}
				
				if(args.length == 0) {
					player.setHealth(20.0D);
					player.sendMessage(ChatColor.GREEN + "You've been healed!");
					return true;
				}
				
				if(args.length == 1) {
					String arguments = args[0];
					Player target = Bukkit.getPlayer( arguments );
					
					if(target != null && target.isOnline()) {
						target.setHealth(20.0D);
						target.sendMessage(ChatColor.GREEN + "You've been healed!");
						player.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.GREEN + " has been healed!");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "The player you entered does not exist or is not connected!");
						return true;
					}
				}
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
		
		
		//TODO: Feed
		if(cmd.getName().equalsIgnoreCase("feed")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.feed")) {
					player.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				}
				
				if(args.length == 0) {
					player.setFoodLevel(20);
					player.sendMessage(ChatColor.GREEN + "You've been feeded!");
					return true;
				}
				
				if(args.length == 1) {
					String arguments = args[0];
					Player target = Bukkit.getPlayer( arguments );
					
					if(target != null && target.isOnline()) {
						target.setFoodLevel(20);
						target.sendMessage(ChatColor.GREEN + "You've been feeded!");
						player.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.GREEN + " has been feeded!");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "The player you entered does not exist or is not connected!");
						return true;
					}
				}
				
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
		
		
		//TODO: Hunger
		if(cmd.getName().equalsIgnoreCase("hunger")) {
		if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.hunger")) {
					player.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				}
				
				if(args.length == 0) {
					player.setFoodLevel(0);
					player.sendMessage(ChatColor.GREEN + "You've been hungered!");
					return true;
				}
				
				if(args.length == 1) {
					String arguments = args[0];
					Player target = Bukkit.getPlayer( arguments );
					
					if(target != null && target.isOnline()) {
						target.setFoodLevel(0);
						target.sendMessage(ChatColor.GREEN + "You've been hungered!");
						player.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.GREEN + " has been hungered!");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "The player you entered does not exist or is not connected!");
						return true;
					}
				}
				
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
		
		
		//TODO: End
		return false;
	}

}
