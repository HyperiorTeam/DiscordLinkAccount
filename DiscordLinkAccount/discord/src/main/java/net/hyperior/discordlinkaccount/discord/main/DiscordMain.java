package net.hyperior.discordlinkaccount.discord.main;

import javax.security.auth.login.LoginException;

import org.bukkit.plugin.Plugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.hyperior.discordlinkaccount.discord.commands.DSInfoCommand;
import net.hyperior.discordlinkaccount.discord.commands.DSLinkCommand;

public class DiscordMain {
	
	static JDA api;
	
	public static void load(Plugin plugin) {
		
		try {
			
			api = JDABuilder.createDefault(plugin.getConfig().getString("discordbot-token")).build();
			
			api.addEventListener(new DSLinkCommand());
			api.addEventListener(new DSInfoCommand());
			
		} catch (LoginException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void shutdown() {
		
		api.shutdown();
		
	}
	
}
