package com.project.ArmyEye.Controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j2
@Service
@RequiredArgsConstructor
public class TopicProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    //private static final Logger logger = LogManager.getLogger(ArmyEyeController.class);

    public void send(String topic, String message){
        //System.out.println("Payload enviado: " + message);
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(topic, message);
    }

}