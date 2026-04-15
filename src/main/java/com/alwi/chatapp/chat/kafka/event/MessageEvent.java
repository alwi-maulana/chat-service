package com.alwi.chatapp.chat.kafka.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;


@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageEvent implements Serializable {

    private UUID messageId;
    private String conversationId;
    private String senderId;
    private String content;
    private Instant createdAt;

    public MessageEvent(UUID messageId, String conversationId, String senderId, String content, Instant createdAt) {
        this.messageId = messageId;
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.content = content;
        this.createdAt = createdAt;
    }
}
