package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom("springemail46@gmail.com");
        messageHelper.setTo("prdipkumar.java@gmail.com");
        messageHelper.setCc("pardipkumar46@gmail.com");
        messageHelper.setCc("rkg.aryan95@gmail.com");
        messageHelper.setText(body);
        messageHelper.setSubject(subject);

        FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
        messageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
        mailSender.send(mimeMessage);
        System.out.println("Email Send.....!");
    }
}
