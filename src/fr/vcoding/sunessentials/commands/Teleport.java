package fr.vcoding.sunessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Teleport implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//TODO: TOP
		if(cmd.getName().equalsIgnoreCase("top")) {
			
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.tp")) {
					player.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				}
				
				if(args.length > 1) {
					player.sendMessage(ChatColor.RED + "You have inserted too many arguments!");
					return true;
				}
				
				if(args.length == 0) {
					double x = player.getLocation().getBlockX();
					double y = 255;
					double z = player.getLocation().getBlockZ();
					Location tp = new Location(player.getWorld(), x, y, z);
					player.teleport(tp);
					return true;
				}
				
				if(args.length == 1) {
					String argument = args[0];
					Player target = Bukkit.getPlayer( argument );
					if(target != null && target.isOnline()) {
						double x = target.getLocation().getBlockX();
						double y = 255;
						double z = target.getLocation().getBlockZ();
						Location tp = new Location(target.getWorld(), x, y, z);
						target.teleport(tp);
						target.sendMessage(ChatColor.GREEN + "You were teleported to layer 255!");
						player.sendMessage(ChatColor.GREEN + "The player, " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + ", has been teleported!");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "The player you entered does not exist or is not connected!");
						return true;
					}
				}
				
				return true;
			}  else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
		
		//TODO: MTP
		if(cmd.getName().equalsIgnoreCase("mtp")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.tp")) {
					player.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				}
				
				if(args.length == 0) {
					player.sendMessage(ChatColor.RED + "You must enter the name of the player you want to teleport to!");
					return true;
				}
				
				if(args.length > 1 ) {
					player.sendMessage(ChatColor.RED + "You can only teleport to one player at a time!");
					return true;
				}
				
				if(args.length == 1) {
					String argument = args[0];
					Player target = Bukkit.getPlayer(argument);
					
					if(target != null && target.isOnline()) {
						
						double x = target.getLocation().getX();
						double y = target.getLocation().getY();
						double z = target.getLocation().getZ();
						Location tp = new Location(target.getWorld(), x, y, z);
						player.teleport(tp);
						player.sendMessage(ChatColor.GREEN + "You have been teleported to " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + "!");
						
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "The player you entered does not exist or is not connected!");
						return true;
					}
				}
				
				return true;
			}  else {
				sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
				return false;
			}
		}
		
		//TODO: PTM
		if(cmd.getName().equalsIgnoreCase("ptm")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.tp")) {
					player.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				}
				
				if(args.length == 0) {
					player.sendMessage(ChatColor.RED + "You must enter a player's name to teleport!");
					return true;
				}
				
				if(args.length > 1 ) {
					player.sendMessage(ChatColor.RED + "You can only teleport to one player at a time!");
					return true;
				}
				
				if(args.length == 1) {
					String argument = args[0];
					Player target = Bukkit.getPlayer(argument);
					
					if(target != null && target.isOnline()) {
						
						double x = player.getLocation().getX();
						double y = player.getLocation().getY();
						double z = player.getLocation().getZ();
						Location tp = new Location(player.getWorld(), x, y, z);
						target.teleport(tp);
						player.sendMessage(ChatColor.GREEN + "The player, " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + ", has been teleported to you!");
						
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
		
		//TODO:END
		return false;
	}
}
