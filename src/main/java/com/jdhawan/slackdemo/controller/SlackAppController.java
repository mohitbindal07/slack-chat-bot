package com.jdhawan.slackdemo.controller;

import javax.servlet.annotation.WebServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slack.api.bolt.App;
import com.slack.api.bolt.servlet.SlackAppServlet;

//@WebServlet("/")
@RestController
public class SlackAppController extends SlackAppServlet {
	
	 private static final Logger logger =
			 LoggerFactory.getLogger(SlackAppController.class);
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SlackAppController(App app) {
    super(app);
  }
  
	@RequestMapping(value="slack/events",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String onReceiveSlashCommand(@RequestBody String body) {
		logger.info("Inside the event api method: "+ body);
		return body;
      
    }
}
