package com.liumapp.demo.cloud.stream.service.group.first;

import com.liumapp.demo.cloud.stream.service.group.first.sender.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("Output-1")
    private MessageChannel output1;

    @Autowired
    @Qualifier("Output-2")
    private MessageChannel output2;

    @Test
    public void sendText () {
        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
    }

    @Test
    public void sendTextByOutput1 () {
        output1.send(MessageBuilder.withPayload("from output1").build());
    }

    @Test
    public void sendTextByOutput2 () {
        output2.send(MessageBuilder.withPayload("from output2").build());
    }

    /**
     * 不推荐使用
     */
    @Test
    public void contextLoads () {
        input.send(MessageBuilder.withPayload("From MessageChannel").build());
    }



}
