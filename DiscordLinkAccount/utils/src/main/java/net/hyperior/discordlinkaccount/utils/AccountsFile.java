package net.hyperior.discordlinkaccount.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class AccountsFile {
	
	public static FileConfiguration config = null;
    public static File file = null;
	
    public static void load(Plugin plugin) {
    	
    	file = new File(plugin.getDataFolder(), "accounts.yml");
    	
        if(!file.exists()) {
        	
            try {
            	
                file.createNewFile();
                
            } catch (IOException e) {
            	
                e.printStackTrace();
                
            }
        }

        config = YamlConfiguration.loadConfiguration(file);
        
        try {
        	
              config.save(file);
              
        } catch(IOException e) {
        	
        	e.printStackTrace();
        	
        }
    }
    
    public static void addAccount(UUID uuid, String discord) {
    	
    	config.set(uuid.toString(), discord);
    	
    	try {
    		
			config.save(file);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
    	
    }
    
    public static String getAccount(UUID uuid) {
    	
    	return config.getString(uuid.toString());
    	
    }
    
}
