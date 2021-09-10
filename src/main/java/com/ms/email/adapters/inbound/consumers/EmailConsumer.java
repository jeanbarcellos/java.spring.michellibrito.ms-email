package com.ms.email.adapters.inbound.consumers;

import com.ms.email.adapters.inbound.dtos.EmailDto;
import com.ms.email.application.entities.EmailModel;
import com.ms.email.application.services.EmailServiceImpl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailServiceImpl emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);

        emailService.sendEmail(emailModel);

        System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
    }
}