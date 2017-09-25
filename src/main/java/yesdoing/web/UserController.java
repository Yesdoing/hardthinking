package yesdoing.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String login() {
		return "user/loginForm";
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/signInForm";
	}
}