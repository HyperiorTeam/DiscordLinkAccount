package net.hyperior.discordlinkaccount.utils;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class LinkManager {
	
	private static HashMap<UUID, String> tokens = new HashMap<UUID, String>();
	
	public static void add(final Plugin plugin, final UUID uuid) {
		
		new BukkitRunnable() {
			
			public void run() {
				
				String token = GenerateToken.getString(10, Mode.ALPHANUMERIC);
				
				//Check if the token already exists
			    if(!tokens.values().contains(token)) {
			    	
			    	tokens.put(uuid, token);
			    	
			    	Bukkit.getPlayer(uuid).sendMessage(plugin.getConfig().getString("token-message").replace("<token>", token));
			    	
			    	cancel();
			    	
			    }
			    
			}
			
		}.runTaskTimer(plugin, 0, 0);
		
	}
	
	public static boolean link(String token, String discord) {
		
		for(UUID uuid : tokens.keySet()) {
			
			if(tokens.get(uuid).equals(token)) {
				
				AccountsFile.addAccount(uuid, discord);
				
				return true;
				
			}
			
		}
		
		//returns false if key is not found (invalid)
		return false;
		
	}
	
	public static boolean isLinked(UUID uuid) {
    	
    	if(AccountsFile.getAccount(uuid) == null) return false;
    	
    	return true;
    	
    }
	
}
