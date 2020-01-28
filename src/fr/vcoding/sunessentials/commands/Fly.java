package fr.vcoding.sunessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.vcoding.sunessentials.Main;
import net.md_5.bungee.api.ChatColor;

public class Fly implements CommandExecutor {

	private Main flying;
	
	public Fly(Main flying) {
		this.flying = flying;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.fly")) {
					player.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				}
				
				if(args.length == 0) {
					flying.toggleFlying(player);
				} else {
					String playerName = args[0];
					Player target = Bukkit.getServer().getPlayer(playerName);
					if(target != null && target.isOnline()) {
						flying.toggleFlying(target);
					} else {
						player.sendMessage(ChatColor.RED + "The player you entered does not exist or is not connected!");
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
