package yesdoing.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import yesdoing.domain.Subject;

@RestController
public class SubjectController {
	
	@PostMapping("/subject")
	public ResponseEntity<?> insertSubject(String subjectName, String content, HttpSession session) {
		Subject subject = new Subject(subjectName, content);
		
		return ResponseEntity.ok("success");
	}
}
