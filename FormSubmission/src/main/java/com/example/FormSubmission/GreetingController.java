package com.example.FormSubmission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class GreetingController implements CommandLineRunner
 {

    @GetMapping ( "/greeting" )
    public String greetingForm ( Model model ) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }


         @Autowired
         private JavaMailSender javaMailSender;

         @Override
         public void run ( String... args ) throws MessagingException, IOException {

             //System.out.println("Sending Email...");

             //sendEmail();


             //System.out.println("Done");

         }

    @PostMapping ( "/greeting" )
    public String greetingSubmit ( @ModelAttribute Greeting greeting, Model model ) {
        model.addAttribute("greeting", greeting);




        //CREARE FISIER

        try {
            File myObj = new File("/Users/alexandruvisan/Desktop/PROIECT_LICENTA/multi module/FormSubmission/src/main/resources/CerereStudent.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName() + myObj.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //SCRIERE IN FISIER

        try {
            FileWriter myWriter = new FileWriter("/Users/alexandruvisan/Desktop/PROIECT_LICENTA/multi module/FormSubmission/src/main/resources/CerereStudent.txt");
            myWriter.write("nume:    " + greeting.getNume());
            System.out.println(greeting.getNume());
            myWriter.write("Grupa:    " + greeting.getGrupa());
            System.out.println(greeting.getGrupa());
            myWriter.write("Motivul Cererii:    " + greeting.getMotivulCererii());
            System.out.println(greeting.getMotivulCererii());


            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



        System.out.println("Sending Email...");


        //TRIMITERE EMAIL DUPA MODIFICARE FISIER

        try {
            sendEmailWithAttachment();
            //sendEmail();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");

        return "result";
    }


	void sendEmail(){

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

		helper.addAttachment("/Users/alexandruvisan/Desktop/PROIECT_LICENTA/multi module/FormSubmission/src/main/resources/CerereStudent.txt", new ClassPathResource("CerereStudent.txt"));

		javaMailSender.send(msg);

	}



}


