package com.example.FormSubmission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class FormSubmissionApplication //implements CommandLineRunner
 {

	public static void main(String[] args)
	{
		SpringApplication.run(FormSubmissionApplication.class, args);
	}

/*
	@Autowired
	private JavaMailSender javaMailSender;



	@Override
	public void run(String... args) throws MessagingException, IOException {

		System.out.println("Sending Email...");

		sendEmail();
		//sendEmailWithAttachment();

		System.out.println("Done");

	}

	void sendEmail() {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("alexandru.george.visan@gmail.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);

	}

	void sendEmailWithAttachment() throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo("alexandru.george.visan@gmail.com");

		helper.setSubject("Testing from Spring Boot");

		// default = text/plain
		//helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText("<h1>Check attachment for image!</h1>", true);

		//FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

		//Resource resource = new ClassPathResource("android.png");
		//InputStream input = resource.getInputStream();

		//ResourceUtils.getFile("classpath:android.png");

		helper.addAttachment("CerereStudent.txt", new ClassPathResource("CerereStudent.txt"));

		javaMailSender.send(msg);

	}
*/

}
