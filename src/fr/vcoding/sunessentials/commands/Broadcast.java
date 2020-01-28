package fr.vcoding.sunessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Broadcast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!sender.hasPermission("sun.bc")) {
			sender.sendMessage(ChatColor.RED + "You don't have permission.");
			return false;
		}
		
		if(args.length == 0) {
			sender.sendMessage("§cPlease insert a message!");
			return true;
		}
		
		if(args.length >= 1) {
			StringBuilder bc = new StringBuilder();
			for(String part : args) {
				bc.append(part + " ");
			}
			Bukkit.broadcastMessage("§4[§cBRODCAST§4] §f"+bc.toString().replace("&", "§"));
			return true;
		}
		
		return false;
	}

}
