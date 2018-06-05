package com.javabycode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.javabycode.model.Mail;
import com.javabycode.service.MailService;

import static java.lang.System.exit;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootEmailApplication implements CommandLineRunner {

	@Autowired
	MailService mailService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootEmailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Mail mail = new Mail();
		mail.setMailFrom("pongsoonlung@gmail.com");
		mail.setMailTo("sam_ks_lee@manulife.com");
		mail.setMailCc("soon_lung_pong@manulife.com");
		mail.setMailSubject("Spring Boot - Email with FreeMarker template");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("firstName", "David");
		model.put("lastName", "Pham");
		model.put("location", "Columbus");
		model.put("signature", "www.javabycode.com");
		mail.setModel(model);

		mailService.sendEmail(mail);

		System.out.println("Done!");

		exit(0);
	}

}