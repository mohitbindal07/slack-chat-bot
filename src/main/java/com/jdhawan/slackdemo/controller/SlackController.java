package com.jdhawan.slackdemo.controller;

import java.util.HashMap;
import java.util.Map;
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
    	if(text.trim().isEmpty()) {
    		response.setText("You can always schedule one with 'setup meeting' command.");
    		return response;
    	}
    	if(text.trim().equalsIgnoreCase("help")) {
    		response.setText("How can I help you today, "+userName + "?"
    				+ "1. Schedule meeting"
    				+ "2. Reserve conference room");
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
        		 map.put("conference-time", text);
        		//response.setText("How many minutes (ex. 30 minutes) you want to schedule a conference?");
        		//return response;
        	}else {
        		response.setText("From what time you want to reserve the conference room");
        		return response;
        	}
    		if(!text.contains("minutes") ) {
        		response.setText("Please provide duration in minutes");
        		return response;
        	}else {
        		//TODO extract minutes and set in map
        	}
    		response.setText("Your conference room has been booked, and your conference room number is C"+(int) ((Math.random() * (10 - 1)) + 1));
    		return response;
    		
    		
    	}else if(map.get("command").equals("meeting")){
    		
    		if(timePattern(text) || map.containsKey("meeting-time")) {
    			
        		map.put("meeting-time", text);
        		
        	}else {
        		response.setText("From what time you want to schedule a meeting?");
        		return response;
        	}
    
        	if(!text.contains("minutes") ) {
        		response.setText("Please provide duration in minutes");
        		return response;
        	}else {
        		//TODO extract minutes and set in map
        	}
        	response.setText("Your meeting scheduled for "+map.get("meeting-time")+ " minutes");
    		return response;
    	}
    	else {
    		response.setText("I'm sorry but I am not able to understand required functionality.Use /help to get suggestions.");
    		return response;
    	}
    	
    }
    
    public boolean timePattern(String text) {
    	Pattern pattern = Pattern.compile("-?\\d{2}(\\:\\d{2})?");
    	if (text == null) {
            return false; 
        }
        return pattern.matcher(text).matches();
    }
    
}

