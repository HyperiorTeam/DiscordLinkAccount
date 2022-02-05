package net.hyperior.discordlinkaccount.utils;

public class GenerateToken {
	
	public static String getString(int lenght, Mode mode){
		
		StringBuilder builder = new StringBuilder();
		String s = "";
		
		switch(mode){
		
		case ALPHA:
			s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			break;
			
		case ALPHANUMERIC:
			s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			
			break;
			
		case NUMERIC:
			s = "0123456789";
			
			break;
			
		case SYMBOLIC:
			s = "~,.:?;[]{}´`^!@#$%¨&*()-_+=></ ";
			
			break;
			
		case ALPHASYMBOLIC:
			s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~,.:?;[]{}´`^!@#$%¨&*()-_+=></ ";
			
			break;
			
		case NUMERICSYMBOLIC:
			s = "0123456789~,.:?;[]{}´`^!@#$%¨&*()-_+=></ ";
			
			break;
			
		case ALPHANUMERICSYMBOLIC:
			s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~,.:?;[]{}´`^!@#$%¨&*()-_+=></ ";
			
			break;
			
		}
		
		for(int i = 0; i<lenght; i++){
			double index = Math.random() * s.length();
			builder.append(s.charAt((int)index));
		}
		return builder.toString();
	}
	
}