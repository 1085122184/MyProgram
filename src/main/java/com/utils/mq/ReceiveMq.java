//package com.utils;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Envelope;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.domain.Mq;
//import com.handler.HandlerFactory;
//
//import java.io.IOException;
//
//
//@Component
//@RabbitListener(queues = "hello")
//public class ReceiveMq {
//	@Autowired
//	HandlerFactory factory;
//
//    @RabbitHandler
//    public void process(Mq mq, Channel channel, Envelope envelope) {
//		try {
//			channel.basicAck(envelope.getDeliveryTag(),false);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		int type = mq.getType();
//    	factory.getHandler(type).handler("123");
//    }
//
//}