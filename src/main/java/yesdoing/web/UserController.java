package yesdoing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import yesdoing.domain.User;
import yesdoing.domain.UserRepository;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/login")
	public String login() {
		return "user/loginForm";
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/signInForm";
	}
	
	@PostMapping("/join")
	public String joinUser(User user) {
		System.out.println(user);
		userRepository.save(user);
		return "index";
	}
}
