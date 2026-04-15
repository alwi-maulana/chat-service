package com.alwi.chatapp.chat.dto.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageRequestDTO implements Serializable {
    private String conversationId;
    private String senderId;
    private String content;

    public MessageRequestDTO(String conversationId, String senderId, String content) {
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.content = content;
    }

}
