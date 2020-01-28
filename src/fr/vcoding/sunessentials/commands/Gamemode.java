package fr.vcoding.sunessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Gamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			if(!player.hasPermission("sun.gm")) {
				player.sendMessage(ChatColor.RED + "You don't have permission.");
				return false;
			}
			
			if(args.length == 0 ){
				player.sendMessage("§cPlease insert the desired gamemode!");
				return true;
			}
			
			if(args.length == 1) {	
				if(args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to creative!");
					return true;
				}
				if(args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("3")) {
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to spectator!");
					return true;
				}
				if(args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2")) {
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to adventure!");
					return true;
				}
				if(args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to survival!");
					return true;
				}
				else {
					player.sendMessage(ChatColor.RED + "The gamemode you want doesn't exist!");
					return true;
				}
			}
			
			if(args.length == 2) {
				if(args[1].contains("@")) {
					player.sendMessage(ChatColor.RED + "Arguments containing an @a or @e or @p @s or @r are not yet available.");
					return true;
				}
				String argument = args[1];
				Player target = Bukkit.getPlayer( argument );
				if(target !=null && target.isOnline()) {
					if(args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
						target.setGameMode(GameMode.CREATIVE);
						target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to creative!");
						player.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.GREEN + " gamemode has been changed to creative!");
						return true;
					}
					if(args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("3")) {
						target.setGameMode(GameMode.SPECTATOR);
						target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to spectator!");
						player.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.GREEN + " gamemode has been changed to spectator!");
						return true;
					}
					if(args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2")) {
						target.setGameMode(GameMode.ADVENTURE);
						target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to adventure!");
						player.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.GREEN + " gamemode has been changed to adventure!");
						return true;
					}
					if(args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
						target.setGameMode(GameMode.SURVIVAL);
						target.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to survival!");
						player.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.GREEN + " gamemode has been changed to survival!");
						return true;
					}
					else {
						player.sendMessage(ChatColor.RED + "The gamemode you want doesn't exist!");
						return true;
					}
				} else {
					player.sendMessage(ChatColor.RED + "The player you entered does not exist or is not connected!");
					return true;
				}
			}
			
			if(args.length > 2) {
				player.sendMessage("You've put too many arguments in!");
				return true;
			}
			
		} else {
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
			return false;
		}
		
		return false;
	}

}
