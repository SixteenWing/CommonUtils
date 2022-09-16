package com.wow.basicutils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kisrosen on 17/2/17.
 */
public class StringAssertTest {

    @Before
    public void setUp()
    {

    }

    @Test
    public void assertIsIp() throws Exception {
        Assert.assertTrue(StringAssert.assertIsIp("1.1.2.3"));
        Assert.assertTrue(StringAssert.assertIsIp("0.1.1.2"));
        Assert.assertTrue(StringAssert.assertIsIp("1.0.2.3"));
        Assert.assertFalse(StringAssert.assertIsIp("1.1.0.2.3.1.1.1.1.1.1."));
        Assert.assertFalse(StringAssert.assertIsIp("1.1.0"));
    }

    @Test
    public void assertIsCell() throws Exception {
        Assert.assertTrue(StringAssert.assertIsCell("18205099166"));
        Assert.assertFalse(StringAssert.assertIsCell("1820509916"));
        Assert.assertFalse(StringAssert.assertIsCell("182050991666"));
    }

    @Test
    public void assertIsIdentity() throws Exception {
        Assert.assertTrue(StringAssert.assertIsIdentity("421127198601050112"));
        Assert.assertFalse(StringAssert.assertIsIdentity("42112719860105011"));
        Assert.assertFalse(StringAssert.assertIsIdentity("4211271986010501122"));
    }

    @Test
    public void assertIsChinesePhone() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Test
    public void assertIsChineseLetter() throws Exception {

    }

    @Test
    public void assertIsEmail() throws Exception {

    }

    @Test
    public void assertIsTrue() throws Exception {

    }


}