package com.alwi.chatapp.chat.kafka.producer;

import com.alwi.chatapp.chat.kafka.event.MessageEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.alwi.chatapp.chat.constant.CommonConstant.KafkaTopics.MESSAGE_SENT;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, MessageEvent> kafkaTemplate;

    public void sendMessage(MessageEvent messageEvent) {
        kafkaTemplate.send(
                MESSAGE_SENT,
                messageEvent.getConversationId(),
                messageEvent
        );
    }
}
