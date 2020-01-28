package fr.vcoding.sunessentials;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.vcoding.sunessentials.commands.*;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {

	private Set<Player> vanishedList = new HashSet<>();
	private Set<Player> flyList = new HashSet<>();
	
	public void onEnable() {
		System.out.println("[SunEssentials] Enabled");
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("bc").setExecutor(new Broadcast());
		getCommand("alert").setExecutor(new Broadcast());
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("top").setExecutor(new Teleport());
		getCommand("mtp").setExecutor(new Teleport());
		getCommand("ptm").setExecutor(new Teleport());
		getCommand("suicide").setExecutor(new Kill());
		getCommand("vanish").setExecutor(new VanishCommand(this));
		getCommand("day").setExecutor(new Times());
		getCommand("night").setExecutor(new Times());
		getCommand("wclear").setExecutor(new Times());
		getCommand("wc").setExecutor(new Times());
		getCommand("wstorm").setExecutor(new Times());
		getCommand("ws").setExecutor(new Times());
		getCommand("wrain").setExecutor(new Times());
		getCommand("wr").setExecutor(new Times());
		getCommand("fly").setExecutor(new Fly(this));
		getCommand("health").setExecutor(new HealthAndFeed());
		getCommand("feed").setExecutor(new HealthAndFeed());
		getCommand("hunger").setExecutor(new HealthAndFeed());
		getCommand("reffect").setExecutor(new Effect());
		getCommand("ping").setExecutor(new TinyCommands());
		getCommand("ip").setExecutor(new TinyCommands());
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onDisable() {
		for (Player player : this.getServer().getOnlinePlayers()) {
			for(Player hidden : vanishedList) {
				player.showPlayer(hidden);
			}
			for(Player Pflying : flyList) {
				Pflying.setAllowFlight(false);
				Pflying.setFlying(false);
			}
		}
		vanishedList.clear();
		flyList.clear();
		
		System.out.println("[SunEssentials] Disabled");
	}

	public void toggleVanish(Player player) {
		toggleVanishWithSender(player, player);
	}
	
	@SuppressWarnings("deprecation")
	public void toggleVanishWithSender(Player player, Player sender) {
		if(vanishedList.contains(player)) {
			// Unvanish
			
			vanishedList.remove(player);
			
			for(Player online : this.getServer().getOnlinePlayers()) {
				online.showPlayer(player);
			}
			
			if(player == sender) {
				player.sendMessage(ChatColor.RED + "You've un-vanished!");
			} else {
				player.sendMessage(ChatColor.GOLD + sender.getName() + ChatColor.RED + " has unvanished you!");
			}
		} else {
			// Vanish
			
			vanishedList.add(player);
			
			for(Player online : this.getServer().getOnlinePlayers()) {
				
				if(online.hasPermission("sun.vanish") || online == player) {
					continue;
				}
				
				online.hidePlayer(player);
			}
			
			if(player == sender) {
				player.sendMessage(ChatColor.GREEN + "You've vanished!");
			} else {
				player.sendMessage(ChatColor.GOLD + sender.getName() + ChatColor.GREEN + " has vanished you!");
			}
		}
	}
	
	public void toggleFlying(Player player) {
		toggleFlyingWithSender(player, player);
	}
	
	public void toggleFlyingWithSender(Player player, Player sender) {
		if(flyList.contains(player)) {
			// Disabled
			flyList.remove(player);
			
			player.setAllowFlight(false);
			player.setFlying(false);
			
			if(player == sender) {
				player.sendMessage(ChatColor.RED + "Flying disabled!");
			} else {
				player.sendMessage(ChatColor.GOLD + sender.getName() + ChatColor.RED + " has taken away your power to fly!");
			}
			
		} else {
			// Enabled
			flyList.add(player);
			
			player.setAllowFlight(true);
			player.setFlying(true);
			
			if(player == sender) {
				player.sendMessage(ChatColor.GREEN + "Flying enabled!");
			} else {
				player.sendMessage(ChatColor.GOLD + sender.getName() + ChatColor.GREEN + " has gave you the power to fly!");
			}
		}
	}
	
}
