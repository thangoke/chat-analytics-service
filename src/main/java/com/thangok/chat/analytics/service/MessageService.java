package com.thangok.chat.analytics.service;

import com.thangok.chat.analytics.dto.MessageDto;
import com.thangok.chat.analytics.entity.Message;
import com.thangok.chat.analytics.repository.MessageRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
  @Autowired private MessageRepository messageRepository;

  public MessageDto addMessage(MessageDto messageDto) {
    Message message = MessageDto.toEntity(messageDto);

    // set appendedTime at the moment message received
    message.setAppendedTime(LocalDateTime.now());

    message = messageRepository.save(message);

    return MessageDto.fromEntity(message);
  }
}
