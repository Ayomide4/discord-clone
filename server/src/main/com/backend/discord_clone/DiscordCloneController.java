package com.backend.discord_clone;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * Controller for Discord Clone web application.
 */
@Controller
public class DiscordCloneController {

	/**
	 * Creates mapping to /index
	 * @return returns index from resources.
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}



}
