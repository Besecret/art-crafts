package com.personal.works.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestConsumer {


    @KafkaListener(topics = "test")
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        log.info(" -------- 接受kafka消息 ----");
        log.info("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }

}
