package com.liumapp.demo.cloud.stream.service.group.first.receiver;

import com.liumapp.demo.cloud.stream.service.group.first.sender.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author liumapp
 * @file SinkReceiver.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/7/28
 */
@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive (Object payload) {
        logger.info("Received: " + payload);
    }

    @StreamListener("Output-1")
    public void receivePut1 (Object payload) {
        logger.info("put 1 Received: " + payload);
    }

    @StreamListener("Output-2")
    public void receivePut2 (Object payload) {
        logger.info("put 2 Received: " + payload);
    }

}
