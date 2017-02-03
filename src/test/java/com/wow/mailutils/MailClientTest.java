package com.wow.mailutils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kisrosen on 17/2/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:CommonUtils.xml")
public class MailClientTest {

    @Autowired
    private MailClient mailClient;

    @Test
    public void sendMail() throws Exception {
        mailClient.setUsername("xxx");
        mailClient.setPassword("xxx");
        mailClient.setSmtpHost("smtp.yeah.net");

        MailContent content = new MailContent();
        List toNames = new ArrayList<String>();
        toNames.add("yyy@yeah.net");

        content.setToNames(toNames);
        content.setTitle("test mail");
        content.setMailFrom("xxx@yeah.net");
        content.setMailBody("hello world");

        mailClient.sendTextMail(content);
    }

}