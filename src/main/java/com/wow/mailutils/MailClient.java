package com.wow.mailutils;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * MailClient to send mail
 * <p>
 * Based On javax.mail
 * Refer to https://javamail.java.net/nonav/docs/api/
 * <p>
 * <p>
 * Created by kisrosen on 17/1/11.
 */
@Component
public class MailClient {

    /**
     * SMTP Server Host
     */
    private String smtpHost = "";

    /**
     * SMTP Server Port
     */
    private Integer smtpPort = 25;

    /**
     * mail usename
     */
    private String username = "";

    /**
     * mail pwd
     */
    private String password = "";

    /**
     * need auth
     */
    private Boolean auth = true;

    /**
     * mail protocol smtp/pop3/imap
     */
    private String protocol = "smtp";

    /**
     * mail properties
     */
    private Properties props = new Properties();

    private Authenticator authenticator = null;

    /**
     * mail session
     */
    private Session session = null;


    public MailClient() {
        // setting
        props.put("mail.smtp.host", this.smtpHost);
        props.put("mail.smtp.port", this.smtpPort);
        props.put("mail.smtp.auth", this.auth);
        props.put("mail.transport.protocol", this.protocol);
    }

    public MailClient setSmtpHost(String host) {
        this.smtpHost = host;
        props.put("mail.smtp.host", this.smtpHost);
        return this;
    }

    public MailClient setSmtpPort(Integer port) {
        this.smtpPort = port;
        props.put("mail.smtp.port", this.smtpPort);
        return this;
    }

    public MailClient setAuth(Boolean isauth) {
        this.auth = isauth;
        props.put("mail.smtp.auth", this.auth);
        return this;
    }

    public MailClient setUsername(String username) {
        this.username = username;
        return this;
    }

    public MailClient setPassword(String password) {
        this.password = password;
        return this;
    }

    public MailClient setProtocol(String protocol) {
        this.protocol = protocol;
        props.put("mail.transport.protocol", this.protocol);
        return this;
    }

    /**
     * Send Mail
     *
     * @param mailContent
     */
    public void sendTextMail(MailContent mailContent) {

        // check mail data
        if (null == mailContent.getToNames() || mailContent.getToNames().size() < 1) {
            return;
        }

        authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        this.session = Session.getInstance(props, authenticator);

        MimeMessage message = null;
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailContent.getMailFrom()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailContent.getToNamesString()));
            message.setSubject(mailContent.getTitle());

            message.setText(mailContent.getMailBody()); //pure text mail todo
            message.setSentDate(new Date());//send mail time
            message.saveChanges();//save mail setting
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        this.sendMail(message);
    }


    /**
     * Send Mail
     *
     * @param mailContent
     */
    public void sendHtmlMail(MailContent mailContent) {

        // check mail data
        if (null == mailContent.getToNames() || mailContent.getToNames().size() < 1) {
            return;
        }

        authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        this.session = Session.getInstance(props, authenticator);

        MimeMessage message = null;
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailContent.getMailFrom()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailContent.getToNamesString()));
            message.setSubject(mailContent.getTitle());

            message.setContent(mailContent.getMailBody(), "text/html;charset=gbk"); //html mail
            message.setSentDate(new Date());//send mail time
            message.saveChanges();//save mail setting
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        this.sendMail(message);
    }

    /**
     * send mail
     *
     * @param message
     */
    private void sendMail(MimeMessage message) {
        // send mail
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
