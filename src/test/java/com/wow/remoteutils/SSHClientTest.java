package com.wow.remoteutils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kisrosen on 17/1/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:CommonUtils.xml")
public class SSHClientTest {

    @Autowired
    private SSHClient sshClient;

    @Before
    public void setUp() throws Exception {
        sshClient.setHost("10.13.132.38").setPort(10022).setUsername("root").setPassword("hello123");
        sshClient.login();
    }

    @Test
    public void sendCmd() throws Exception {
        String ret = sshClient.sendCmd("pwd");

        System.out.println("******************************");
        System.out.println(ret);
        System.out.println("******************************");

        Assert.assertNotNull(ret);
        Assert.assertTrue(ret.length() > 0);

        ret = sshClient.sendCmd("vmstat");

        System.out.println("******************************");
        System.out.println(ret);
        System.out.println("******************************");
    }

    @After
    public void tearDown() throws Exception {
        sshClient.logout();
    }
}