package com.jdhawan.slackdemo.controller;

import javax.servlet.annotation.WebServlet;

import com.slack.api.bolt.App;
import com.slack.api.bolt.servlet.SlackAppServlet;

@WebServlet("/slack/events")
public class SlackAppController extends SlackAppServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SlackAppController(App app) {
    super(app);
  }
  
  
}
