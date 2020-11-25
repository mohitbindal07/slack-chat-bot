/*
 * package com.jdhawan.slackdemo.controller;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.http.MediaType; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.hubspot.slack.client.SlackClient; import
 * com.hubspot.slack.client.SlackClientFactory; import
 * com.hubspot.slack.client.SlackClientRuntimeConfig; import
 * com.hubspot.slack.client.methods.params.chat.ChatPostMessageParams; import
 * com.slack.api.bolt.App; import com.slack.api.bolt.servlet.SlackAppServlet;
 * 
 * //@WebServlet("/")
 * 
 * @RestController("/") public class SlackAppController extends SlackAppServlet
 * {
 * 
 * App app = new App(); private static final Logger logger =
 * LoggerFactory.getLogger(SlackAppController.class);
 *//**
	 * 
	 *//*
		 * private static final long serialVersionUID = 1L;
		 * 
		 * public SlackAppController(App app) { super(app); }
		 * 
		 * @RequestMapping(value="slack/events", method = RequestMethod.POST, consumes =
		 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<String>
		 * onReceiveSlashCommand(@RequestBody String payloadString) {
		 * logger.info("Inside the event api method: "+ payloadString);
		 * 
		 * app.event(ReactionAddedEvent.class, (payload, ctx) -> { //String
		 * payloadString = body.getBodyAsString(); EventTypeExtractor eventTypeExtractor
		 * = (EventTypeExtractor) new EventsDispatcherImpl(); String eventType =
		 * eventTypeExtractor.extractEventType(payloadString); if (eventType != null &&
		 * eventType.equals("message")) { Gson gson = GsonFactory.createSnakeCase();
		 * MessagePayload payload2 = gson.fromJson(payloadString, MessagePayload.class);
		 * // 3. Whatever you want to do with the event data } else { // other patterns
		 * return ResponseEntity.ok("This is a String"); } // 4. Respond to the Slack
		 * API server with 200 OK as an acknowledgment return
		 * ResponseEntity.ok("This is a String"); ReactionAddedEvent event =
		 * body.getEvent(); if (event.getReaction().equals("white_check_mark")) {
		 * ChatPostMessageResponse message = ctx.client().chatPostMessage(r -> r
		 * .channel(event.getItem().getChannel()) .threadTs(event.getItem().getTs())
		 * .text("<@" + event.getUser() +
		 * "> Thank you! We greatly appreciate your efforts :two_hearts:")); if
		 * (!message.isOk()) { ctx.logger.error("chat.postMessage failed: {}",
		 * message.getError()); } } return ctx.ack(); }); }
		 * 
		 * @RequestMapping(value="slack/events", method = RequestMethod.POST, consumes =
		 * MediaType.APPLICATION_JSON_VALUE) public void
		 * onReceiveEventCommand(@RequestBody String payload) {
		 * 
		 * SlackClientRuntimeConfig runtimeConfig = SlackClientRuntimeConfig.builder()
		 * .setTokenSupplier(() ->
		 * "xoxb-1507109434786-1521587020117-YJmVF0rCzbEp3vflwW6zJXcS").build();
		 * 
		 * SlackClient slackClient =
		 * SlackClientFactory.defaultFactory().build(runtimeConfig);
		 * 
		 * slackClient.postMessage( ChatPostMessageParams.builder()
		 * .setText("Hey! there") .setChannelId("C01F382UQQ4") .build()
		 * ).join().unwrapOrElseThrow(); }
		 * 
		 * }
		 * 
		 */