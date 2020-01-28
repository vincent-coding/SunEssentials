package fr.vcoding.sunessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import net.md_5.bungee.api.ChatColor;

public class Effect implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("reffect")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.effect")) {
					player.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				}
				
				if(args.length == 0) {
					for(PotionEffect effect : player.getActivePotionEffects()) {
						player.removePotionEffect(effect.getType());
					}
					player.sendMessage(ChatColor.GREEN + "All the effects have been removed!");
					return true;
				}
				
				if(args.length == 1) {
					String argument = args[0];
					Player target = Bukkit.getPlayer( argument );
					
					if(target != null && target.isOnline()) {
						for(PotionEffect effect : target.getActivePotionEffects()) {
							target.removePotionEffect(effect.getType());
						}
						target.sendMessage(ChatColor.GREEN + "All the effects have been removed!");
						player.sendMessage(ChatColor.GREEN + "All " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + " effect have been removed!");
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
		
		return false;
	}

}
