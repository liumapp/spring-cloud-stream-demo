package com.liumapp.demo.cloud.stream.service.group.first;

import com.liumapp.demo.cloud.stream.service.group.first.sender.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {FirstGroupMain.class})
@WebAppConfiguration
public class FirstGroupTests {

    @Autowired
    private SinkSender sinkSender;

    @Autowired
    private MessageChannel input;

    @Test
    public void sendText () {
        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
    }

    @Test
    public void contextLoads () {

    }

}
