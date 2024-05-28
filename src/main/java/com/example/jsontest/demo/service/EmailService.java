package com.example.jsontest.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.internet.MimeMessage;
import jakarta.mail.MessagingException;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    // add logging 
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.javaMailSender = mailSender;
        this.templateEngine = templateEngine;
        logger.info("EmailService initialized");
    }

    public void sendSimpleMessage(String to, String subject, String text) {
        MimeMessage message = javaMailSender.createMimeMessage();
        logger.info("Sending email to: " + to);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);

            // Create the HTML body using Thymeleaf
            Context context = new Context();
            context.setVariable("jsonContent", text);
            String html = templateEngine.process("validJsonEmail", context);

            helper.setText(html, true); // true indicates the content is HTML

            javaMailSender.send(message);
        } catch (MessagingException e) {
            logger.error("Failed to send email", e);
            e.printStackTrace();
        }
    }
}
