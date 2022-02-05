package net.hyperior.discordlinkaccount.main;

import org.bukkit.plugin.java.JavaPlugin;

import net.hyperior.discordlinkaccount.commands.LinkCommand;
import net.hyperior.discordlinkaccount.discord.main.DiscordMain;
import net.hyperior.discordlinkaccount.utils.AccountsFile;

public class DLA extends JavaPlugin {
	
	private static DLA instance;
	
	public void onEnable() {
		
		instance = this;
		
		registerCommands();
		
		if(!getDataFolder().exists()) {
			
			getDataFolder().mkdir();
			
		}
		
		reloadConfig();
		saveDefaultConfig();
		
		DiscordMain.load(instance);
		AccountsFile.load(instance);
		
	}
	
	public void onDisable() {
		
		DiscordMain.shutdown();
		
	}
	
	public void registerCommands() {
		
		getCommand("linkaccount").setExecutor(new LinkCommand());
		
	}
	
	public static DLA getInstance() {
		
		return instance;
		
	}
	
}
