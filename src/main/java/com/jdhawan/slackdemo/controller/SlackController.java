package com.jdhawan.slackdemo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdhawan.slackdemo.model.SlackResponse;

@RestController
public class SlackController {
	
	private static final Logger logger =
			  LoggerFactory.getLogger(SlackController.class);
	
	static Map<String,String> map = new HashMap<>();
	
    @RequestMapping(value = "/slack/slash",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public SlackResponse onReceiveSlashCommand(@RequestParam("team_id") String teamId,
                                               @RequestParam("team_domain") String teamDomain,
                                               @RequestParam("channel_id") String channelId,
                                               @RequestParam("channel_name") String channelName,
                                               @RequestParam("user_id") String userId,
                                               @RequestParam("user_name") String userName,
                                               @RequestParam("command") String command,
                                               @RequestParam("text") String text,
                                               @RequestParam("response_url") String responseUrl) {
    	SlackResponse response = new SlackResponse();
    	logger.info("The incoming text on /bot slash command : "+ text);
    	boolean isMeeting=false;
    	response.setResponseType("in_channel");
    	
    	if(text.trim().equalsIgnoreCase("help")) {
    		response.setText("How can I help you today, "+userName + "?\n"
    				+ "1. Schedule meeting\n"
    				+ "2. Reserve conference room");
    		map.clear();
    		return response;
    	}
    	if(text.toLowerCase().contains("conference")) {
    		map.put("command", "conference");
    	}
    	else if(text.toLowerCase().contains("meeting")) {
    		map.put("command", "meeting");
    	}
    	if(map.get("command").equals("conference")) {
    		if(timePattern(text)|| map.containsKey("conference-time") ) {
    			logger.info("The conference time :{} and extracted time {} : "+ text,extractTime(text));
        		 map.put("conference-time", extractTime(text));
        		
        	}else {
        		response.setText("From what time you want to reserve the conference room");
        		return response;
        	}
    		if(!text.contains("minutes") ) {
        		response.setText("Please provide duration in minutes");
        		return response;
        	}else {
        		map.put("conference-dur", extractDuration(text));
        	}
    		response.setText("Your conference room has been booked from "+map.get("conference-time") + " for " + map.get("conference-dur") + " minutes, and your conference room number is C"+(int) ((Math.random() * (10 - 1)) + 1));
    		map.clear();
    		return response;
    		
    		
    	}else if(map.get("command").equals("meeting")){
    		
    		if(timePattern(text) || map.containsKey("meeting-time")) {
    			logger.info("The meeting time ::{} and extracted time {} : "+ text,extractTime(text));
        		map.put("meeting-time", extractTime(text));
        		
        	}else {
        		response.setText("From what time you want to schedule a meeting?");
        		return response;
        	}
    
        	if(!text.contains("minutes") ) {
        		response.setText("Please provide duration in minutes");
        		return response;
        	}else {
        		map.put("meeting-dur", extractDuration(text));
        	}
        	response.setText("Your meeting has been schduled from "+map.get("meeting-time") + " for " + map.get("meeting-dur") + " minutes");
        	map.clear();
    		return response;
    	}
    	else {
    		response.setText("I'm sorry but I am not able to understand required functionality.Use /help to get suggestions.");
    		return response;
    	}
    	
    }
    
    public boolean timePattern2(String text) {
    	Pattern pattern = Pattern.compile("-?\\d{2}(\\:\\d{2})?");
    	if (text == null) {
            return false; 
        }
        return pattern.matcher(text).matches();
    }
    
    public boolean timePattern(String text) {
    	Pattern p = Pattern.compile(".*([01]?[0-9]|2[0-3]):[0-5][0-9].*");
    	 Matcher m = p.matcher(text);
         if(m.matches()){
             return true;
         }else{
             return false;
         }
    }
    
	/*
	  public static void main(String[] args) {
	  System.out.println(extractTime("please meeting at 02:00")); }
	 */
    public String extractTime(String text) {
    	if(text.contains(":")) {
    		return text.substring(text.indexOf(":")-2,text.indexOf(":")+3);
    		
    	}
    	return null;
    }
    public static String extractDuration(String text) {
    	if(text.contains("minutes")) {
    		String str = text.split("minutes")[0];
            String [] tmpStr = str.split(" ");
            int tmpLength = tmpStr.length;
            return tmpStr[tmpLength-1];
    	}
    	return null;
    }
}

