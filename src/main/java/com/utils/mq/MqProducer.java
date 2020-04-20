package com.utils.mq;


import com.bean.MQConfigBean;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


@Component
public class MqProducer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MQChannelManager mqChannelManager;
    @Autowired
    MQConfigBean mqConfigBean;


    public void send(String message){
        Channel channel = mqChannelManager.getChannel();
        try {
            channel.confirmSelect();
            channel.basicPublish("",mqConfigBean.getQueue(), MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            boolean sendAcked = channel.waitForConfirms(100);



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }





}