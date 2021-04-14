package com.practice19.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.FileSystem;

//TODO if application does`t work use Google app password in application propeties https://support.google.com/accounts/answer/185833
@Service
public class EmailService {

    final JavaMailSender emailSendler;

    public EmailService(JavaMailSender emailSendler) {
        this.emailSendler = emailSendler;
    }

    public void sendMessageAttach(String itemName){
        MimeMessage message = emailSendler.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("zheludkovdm01@gmail.com");
            helper.setTo("kimoror@mail.ru");
            helper.setSubject("Add item");
            helper.setText("Item: " + itemName + " added");

            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/shrek.jpg"));
            helper.addAttachment("Shrek.jpg", file);

            emailSendler.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
