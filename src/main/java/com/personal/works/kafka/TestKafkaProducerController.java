package com.personal.works.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("kafka")
@Slf4j
public class TestKafkaProducerController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("send")
    public String send(String msg){
        kafkaTemplate.send("test", msg);
        log.info("------发送成功----");
        return "success";
    }

}
