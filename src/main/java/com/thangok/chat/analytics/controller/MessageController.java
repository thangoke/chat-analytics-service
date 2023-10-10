package com.thangok.chat.analytics.controller;

import com.thangok.chat.analytics.dto.MessageDto;
import com.thangok.chat.analytics.entity.Message;
import com.thangok.chat.analytics.repository.MessageRepository;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageController {

  @Autowired private MessageRepository messageRepository;

  @GetMapping("")
  public List<MessageDto> getMessages(
      @RequestParam(value = "from-time", required = false) String fromTime,
      @RequestParam(value = "to-time", required = false) String toTime) {
    List<Message> messages = null;

    LocalDateTime _fromTime = null;
    LocalDateTime _toTime = null;

    if (fromTime != null && !fromTime.isBlank()) {
      _fromTime = LocalDateTime.parse(fromTime);
    }

    if (toTime != null && !toTime.isBlank()) {
      _toTime = LocalDateTime.parse(toTime);
    }

    if (_fromTime != null && _toTime != null) {
      messages = messageRepository.findByTimeRange(_fromTime, _toTime);
    } else if (_fromTime != null) {
      messages = messageRepository.findByFromTime(_fromTime);
    } else if (_toTime != null) {
      messages = messageRepository.findByToTime(_toTime);
    } else {
      messages = messageRepository.findAll();
    }

    if (messages == null || messages.isEmpty()) {
      return Collections.emptyList();
    }

    return messages.stream().map(MessageDto::fromEntity).toList();
  }
}
