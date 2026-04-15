package com.alwi.chatapp.chat.dto.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResponseDTO implements Serializable {

    private String messageId;
    private String flag;

    public MessageResponseDTO(String messageId, String flag) {
        this.messageId = messageId;
        this.flag = flag;
    }
}
