package com.jdhawan.slackdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.slack.api.bolt.App;

@Configuration
@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.jdhawan"})
public class SlackdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlackdemoApplication.class, args);
	}
	
	 @Bean
	  public App initSlackApp() {
	    App app = new App();
	    app.command("/hello", (req, ctx) -> {
	      return ctx.ack("What's up?");
	    });
	    return app;
	  }

}
