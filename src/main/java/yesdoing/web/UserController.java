package yesdoing.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import yesdoing.domain.User;
import yesdoing.domain.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/login")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@PostMapping("")
	public String login(String eamil, String password, HttpSession session) {
		User user = userRepository.findByEmail(eamil);
		if(user == null) {
			return "user/signInForm";
		}
		
		if(!user.getPassword().equals(password)) {
			return "user/loginForm";
		}
		
		session.setAttribute("loginedUser", user);
		
		return "redirect:/";
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
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
