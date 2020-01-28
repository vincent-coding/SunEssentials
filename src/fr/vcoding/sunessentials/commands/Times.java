package fr.vcoding.sunessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Times implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//TODO: Day
		if(cmd.getName().equalsIgnoreCase("day")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.time")) {
					sender.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				} else {
					player.getWorld().setTime(6000L);
					player.sendMessage(ChatColor.GREEN + "The day has been set right!");
					return true;
				}
				
				
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
		
		
		//TODO: Night
		if(cmd.getName().equalsIgnoreCase("night")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.time")) {
					sender.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				} else {
					player.getWorld().setTime(18000L);
					player.sendMessage(ChatColor.GREEN + "The night has been set right!");
					return true;
				}
				
				
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
		
		
		//TODO: WClear
		if(cmd.getName().equalsIgnoreCase("wclear") || cmd.getName().equalsIgnoreCase("wc")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.time")) {
					sender.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				} else {
					player.getWorld().setStorm(false);
					player.getWorld().setThundering(false);
					player.sendMessage(ChatColor.GREEN + "The rain has been removed!");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
		
		
		//TODO: WStorm
		if(cmd.getName().equalsIgnoreCase("wstorm") || cmd.getName().equalsIgnoreCase("ws")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.time")) {
					sender.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				} else {
					player.getWorld().setStorm(true);
					player.getWorld().setThundering(true);
					player.sendMessage(ChatColor.GREEN + "The thunderstorm has been put on well!");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
		
		
		//TODO: WRain
		if(cmd.getName().equalsIgnoreCase("wrain") || cmd.getName().equalsIgnoreCase("wr")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.time")) {
					sender.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				} else {
					player.getWorld().setStorm(true);
					player.getWorld().setThundering(false);
					player.sendMessage(ChatColor.GREEN + "The rain has been put on well!");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
				
		return false;
	}

}
