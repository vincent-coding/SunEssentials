package fr.vcoding.sunessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class TinyCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		//TODO: Ping
		if(cmd.getName().equalsIgnoreCase("ping")) {
			
			if(sender instanceof Player) {
				Player player = (Player)sender;
				
				if(!player.hasPermission("sun.tinycmd")) {
					player.sendMessage(ChatColor.RED + "You don't have permission.");
					return false;
				}
				
				int ping = ((CraftPlayer) player).getHandle().ping;
				if(ping <= 100) {
					player.sendMessage("Ping: " + ChatColor.GREEN + ping);
					return true;
				}
				if(ping >= 101 && ping < 200) {
					player.sendMessage("Ping: " + ChatColor.DARK_GREEN + ping);
					return true;
				}
				if(ping > 201 && ping < 500) {
					player.sendMessage("Ping: " + ChatColor.RED + ping);
					return true;
				}
				if(ping > 500) {
					player.sendMessage("Ping: " + ChatColor.DARK_RED + ping);
					return true;
				}
			}
		}
		
		
		//TODO: Ip
		if(cmd.getName().equalsIgnoreCase("ip")) {
			sender.sendMessage(Bukkit.getIp().toString());
		}
		
		
		//TODO: End
		return false;
	}

}
