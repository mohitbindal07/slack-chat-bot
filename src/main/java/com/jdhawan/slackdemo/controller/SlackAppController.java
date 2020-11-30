/*
 * package com.jdhawan.slackdemo.controller;
 * 
 * import java.io.IOException;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.http.MediaType; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.slack.api.bolt.App; import com.slack.api.bolt.AppConfig; import
 * com.slack.api.bolt.servlet.SlackAppServlet; import
 * com.slack.api.methods.SlackApiException; import
 * com.slack.api.methods.response.chat.ChatPostMessageResponse; import
 * com.slack.api.model.event.MessageEvent;
 * 
 * //@WebServlet("/")
 * 
 * @RestController("/") public class SlackAppController extends SlackAppServlet
 * {
 * 
 * private static final Logger logger =
 * LoggerFactory.getLogger(SlackAppController.class);
 *//**
	* 
	*//*
		 * private static final long serialVersionUID = 1L;
		 * 
		 * public SlackAppController(App app) { super(app); }
		 * 
		 * @RequestMapping(value="slack/events", method = RequestMethod.POST, consumes =
		 * MediaType.APPLICATION_JSON_VALUE) public void
		 * onReceiveSlashCommand(@RequestBody String payloadString) {
		 * logger.info("Inside the event api method: "+ payloadString);
		 * 
		 * callMethod();
		 * 
		 * }
		 * 
		 * public void callMethod() { AppConfig config = new AppConfig();
		 * config.setSingleTeamBotToken(System.getenv(
		 * "xoxb-1507109434786-1536463585410-2YBh69lslhXENRIRiymWfa5C"));
		 * config.setSigningSecret(System.getenv("0477ef2e963850c9e3a45558680c1101"));
		 * App app = new App(config); // `new App()` does the same
		 * 
		 * app.message("hello", (req, ctx) -> { Logger logger = ctx.logger; try {
		 * MessageEvent event = req.getEvent(); // Call the chat.postMessage method
		 * using the built-in WebClient ChatPostMessageResponse result =
		 * ctx.client().chatPostMessage(r -> r // The token you used to initialize your
		 * app is stored in the `context` object .token(ctx.getBotToken()) // Payload
		 * message should be posted in the channel where original message was heard
		 * .channel(event.getChannel()) .text("world") ); logger.info("result: {}",
		 * result); } catch (IOException | SlackApiException e) {
		 * logger.error("error: {}", e.getMessage(), e); } return ctx.ack(); });
		 * 
		 * //SlackAppServer server = new SlackAppServer(app); // server.start(); }
		 * 
		 * @RequestMapping(value = "slack/events", method = RequestMethod.POST, consumes
		 * = MediaType.APPLICATION_JSON_VALUE) public void
		 * onReceiveEventCommand(@RequestBody String payload) {
		 * 
		 * SlackClientRuntimeConfig runtimeConfig = SlackClientRuntimeConfig.builder()
		 * .setTokenSupplier(() ->
		 * "xoxb-1507109434786-1521587020117-YJmVF0rCzbEp3vflwW6zJXcS").build();
		 * 
		 * SlackClient slackClient =
		 * SlackClientFactory.defaultFactory().build(runtimeConfig);
		 * 
		 * slackClient
		 * .postMessage(ChatPostMessageParams.builder().setText("Hey! there").
		 * setChannelId("C01F382UQQ4").build()) .join().unwrapOrElseThrow(); }
		 * 
		 * }
		 */