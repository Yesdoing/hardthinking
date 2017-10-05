package yesdoing.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, length=30)
	private String subject;
	@Column(nullable=false, length=30)
	private String contents;
	private LocalDateTime createTime;
	
	public Subject() {
	}

	
	
	public Subject(String subject, String contents) {
		this.subject = subject;
		this.contents = contents;
		this.createTime = LocalDateTime.now();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getFormattedCreateTime() {
		if(createTime == null) {
			return "";
		}
		return createTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}	
	
}

