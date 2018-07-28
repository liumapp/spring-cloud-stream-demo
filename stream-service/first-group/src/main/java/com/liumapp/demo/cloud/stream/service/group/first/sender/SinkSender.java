package com.liumapp.demo.cloud.stream.service.group.first.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author liumapp
 * @file SinkSender.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/7/28
 */
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();

}
