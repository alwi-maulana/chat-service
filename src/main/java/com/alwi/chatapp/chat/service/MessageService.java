package com.alwi.chatapp.chat.service;

import com.alwi.chatapp.chat.dto.message.MessageRequestDTO;
import com.alwi.chatapp.chat.dto.message.MessageResponseDTO;

public interface MessageService {

    MessageResponseDTO sendMessage(MessageRequestDTO messageRequestDTO);

}
