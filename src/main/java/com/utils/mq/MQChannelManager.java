package com.utils.mq;

import com.bean.MQConfigBean;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/*
获取当前线程的mq连接
使用threadlocal
 */
@Component
public class MQChannelManager {
    private static final Logger logger = LoggerFactory.getLogger(MQChannelManager.class);
    @Resource(name = "mqConnection")
    Connection mqConnection;
    @Autowired
    private MQConfigBean mqConfigBean;

    private ThreadLocal<Channel> threadLocal = new InheritableThreadLocal<Channel>(){
        public Channel initialValue(){
            try {
                Channel channel = mqConnection.createChannel();
                channel.queueDeclare(mqConfigBean.getQueue(), true, false, false, null);
                return channel;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    };


    public Channel getChannel(){
        logger.info("Send_CurThread.id={}--->", Thread.currentThread().getId());
        Channel channel = threadLocal.get();
        if(channel==null){
            try {
                channel.queueDeclare(mqConfigBean.getQueue(), true, false, false, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return channel;
    }



}
