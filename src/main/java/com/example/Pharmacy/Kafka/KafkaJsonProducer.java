package com.example.Pharmacy.Kafka;
import com.example.Pharmacy.Model.Drug;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;




@Service
public class KafkaJsonProducer {


    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String,Drug> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, Drug> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Drug drug){


        LOGGER.info(String.format("Message sent ->%s",drug.toString()));

        Message<Drug> message= MessageBuilder
                .withPayload(drug)
                .setHeader(KafkaHeaders.TOPIC,"Laptop")
                .build();

        kafkaTemplate.send(message);



    }
}
