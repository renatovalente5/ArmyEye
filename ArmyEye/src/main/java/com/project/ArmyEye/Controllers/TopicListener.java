package com.project.ArmyEye.Controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class TopicListener {

    //private static final Logger logger = LogManager.getLogger(ArmyEyeController.class);
    private String msg = "";
    private String msgCO = "";

    @KafkaListener(topics = "ecg", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Topic: {}", "plane");
        // logger.info("key: {}", payload.key());
        // logger.info("Headers: {}", payload.headers());
        // logger.info("Partion: {}", payload.partition());
        log.info("Order: {}", payload.value());
        msg = payload.value();
    }

    @KafkaListener(topics = "co", groupId = "group_id")
    public void consumeCO(ConsumerRecord<String, String> payload){
        log.info("Topic: {}", "plane");
        // logger.info("key: {}", payload.key());
        // logger.info("Headers: {}", payload.headers());
        // logger.info("Partion: {}", payload.partition());
        log.info("Order: {}", payload.value());
        msgCO = payload.value();
    }

    public String getMessage(){
        return msg;
    }

    public String getMessageCO() { return msgCO; }
}