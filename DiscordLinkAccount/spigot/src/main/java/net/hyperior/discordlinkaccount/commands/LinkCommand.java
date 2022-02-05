package net.hyperior.discordlinkaccount.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.hyperior.discordlinkaccount.main.DLA;
import net.hyperior.discordlinkaccount.utils.LinkManager;

public class LinkCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		
		LinkManager.add(DLA.getInstance(), ((Player) sender).getUniqueId());
		
		return false;
		
	}
	
}
