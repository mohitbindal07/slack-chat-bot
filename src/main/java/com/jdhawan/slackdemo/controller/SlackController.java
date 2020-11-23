package com.jdhawan.slackdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdhawan.slackdemo.model.Attachement;
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
        response.setText("This is the response text"+ "team id: " +teamId+
        		"domain : "+teamDomain+
        		"c id: "+ channelId+
        		" c name: "+channelName+
        		"uid:  "+userId+
        		"un: "+userName+
        		"com: "+command+
        		"text: "+text+
        		"rurl: "+responseUrl);
        
        response.setResponseType("in_channel");
        
        
        Attachement attachment = new Attachement();
        attachment.setText("This is the attachment text");
        attachment.setColor("#0000ff");

        response.attachments.add(attachment);

        return response;
    }
}

