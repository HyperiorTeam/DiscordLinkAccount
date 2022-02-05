package net.hyperior.discordlinkaccount.discord.commands;

import java.awt.Color;
import java.util.UUID;

import org.bukkit.Bukkit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.hyperior.discordlinkaccount.utils.AccountsFile;

public class DSInfoCommand extends ListenerAdapter {
	
	public void onMessageReceived(MessageReceivedEvent event) {
		
        if (event.getAuthor().isBot()) return;
        
        Message message = event.getMessage();
        String content = message.getContentRaw(); 
        
        if (content.startsWith(".info")) {
        	
            MessageChannel channel = event.getChannel();
            
            String discord = event.getAuthor().getAsTag();
            
            for(String uuid : AccountsFile.config.getKeys(false)) {
            	
            	if(AccountsFile.config.getString(uuid).equals(discord)) {
            		
            		EmbedBuilder embed = new EmbedBuilder();
            			
            		embed.setDescription(event.getAuthor().getName() + ": " + Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName());
            		
            		embed.setColor(Color.RED);
            		
            		channel.sendMessageEmbeds(embed.build()).queue();
            		
            	}
            	
            }
            
        }
    }
	
}
