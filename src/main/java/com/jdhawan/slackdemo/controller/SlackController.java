package com.jdhawan.slackdemo.controller;

import java.util.regex.Pattern;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdhawan.slackdemo.model.SlackResponse;

@RestController
public class SlackController {
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
    	if(text.contains("")|| text.isEmpty() || text==null) {
    		response.setText("You can always schedule one with 'setup meeting' command.");
    	}
    	if(text.contains("Hi")||text.contains("Hello")||text.contains("Good morning")) {
    		response.setText("Hi, I am a Bot User");
    	}
    	if(text.contains("setup meeting")|| text.contains("meeting")) {
    		response.setText("Cool! At what time (ex. 15:30) do you want me to set up the meeting?");
    	}
    	if(timePattern(text)) {
    		response.setText("Your meeting is set at " + text +
                    ". Would you like to repeat it tomorrow?");
    	}
    	if(text.contains("yes")|| text.contains("sure")) {
    		response.setText("Great! I will remind you tomorrow before the meeting.");
    	}else {
    		response.setText("No problem. You can always schedule one with 'setup meeting' command.");
    	}
    	
        response.setResponseType("in_channel");
        return response;
    }
    
    public boolean timePattern(String text) {
    	Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    	if (text == null) {
            return false; 
        }
        return pattern.matcher(text).matches();
    }
    
}

