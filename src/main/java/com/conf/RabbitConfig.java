package com.conf;

import com.bean.MQConfigBean;
import com.rabbitmq.client.Address;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeoutException;


@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.address-list}")
    private String addressList;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtual;
    @Value("${spring.rabbitmq.publisher-confirms}")
    private  boolean publisherConfirms;
    @Value("${spring.rabbitmq.queue}")
    private String queue;




    @Bean
    public MQConfigBean mqConfigBean() {
        MQConfigBean mqConfigBean = new MQConfigBean();

        if (StringUtils.isEmpty(addressList)) {
            throw new InvalidPropertyException(MQConfigBean.class, "addressList", "rabbitmq.address-list is Empty");
        }

        String[] addressStrArr = addressList.split(",");
        List<Address> addressList = new LinkedList<Address>();
        for (String addressStr : addressStrArr) {
            String[] strArr = addressStr.split(":");
            addressList.add(new Address(strArr[0], Integer.valueOf(strArr[1])));
        }
        mqConfigBean.setAddressList(addressList);

        mqConfigBean.setUsername(username);
        mqConfigBean.setPassword(password);
        mqConfigBean.setPublisherConfirms(publisherConfirms);
        mqConfigBean.setVirtualHost(virtual);
        mqConfigBean.setQueue(queue);
        return mqConfigBean;
    }

    @Bean("mqConnection")
    public Connection mqConnection(@Autowired MQConfigBean mqConfigBean) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //用户名
        factory.setUsername(username);
        //密码
        factory.setPassword(password);
        //虚拟主机路径（相当于数据库名）
        factory.setVirtualHost(virtual);
        //返回连接
        return factory.newConnection(mqConfigBean.getAddressList());
    }




}
