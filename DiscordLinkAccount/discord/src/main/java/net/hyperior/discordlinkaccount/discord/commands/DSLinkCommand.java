package net.hyperior.discordlinkaccount.discord.commands;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.hyperior.discordlinkaccount.utils.LinkManager;

public class DSLinkCommand extends ListenerAdapter {
	
	public void onMessageReceived(MessageReceivedEvent event) {
		
        if (event.getAuthor().isBot()) return;
        
        Message message = event.getMessage();
        String content = message.getContentRaw(); 
        
        if (content.startsWith(".linkaccount")) {
        	
            String token = content.split(" ")[1];
            MessageChannel channel = event.getChannel();
            
            String discord = event.getAuthor().getAsTag();
            
            EmbedBuilder embed = new EmbedBuilder();
    		
    		embed.setColor(Color.RED);
            
            if(LinkManager.link(token, discord)) {
            	
            	embed.setDescription("Account successfully Linked!");
            	
               
            	
            }else {
            	
            	embed.setDescription("Invalid Token!");
            	
            }
            
            channel.sendMessageEmbeds(embed.build()).queue();
            
        }
    }
	
}
