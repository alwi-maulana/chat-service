package com.alwi.chatapp.chat.service.serviceimpl;

import com.alwi.chatapp.chat.dto.message.MessageRequestDTO;
import com.alwi.chatapp.chat.dto.message.MessageResponseDTO;
import com.alwi.chatapp.chat.kafka.event.MessageEvent;
import com.alwi.chatapp.chat.kafka.producer.KafkaProducer;
import com.alwi.chatapp.chat.service.MessageService;

import java.time.Instant;
import java.util.UUID;

import static com.alwi.chatapp.chat.constant.CommonConstant.Default.SENT;

public class MessageServiceImpl implements MessageService {

    private final KafkaProducer kafkaProducer;

    public MessageServiceImpl(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public MessageResponseDTO sendMessage(MessageRequestDTO messageRequestDTO) {

        UUID messageId = UUID.randomUUID();

        MessageEvent event = new MessageEvent(
                messageId,
                messageRequestDTO.getConversationId(),
                messageRequestDTO.getSenderId(),
                messageRequestDTO.getContent(),
                Instant.now()
        );

        kafkaProducer.sendMessage(event);

        return new MessageResponseDTO(String.valueOf(messageId), SENT);

    }
}
