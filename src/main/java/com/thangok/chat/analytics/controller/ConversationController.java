package com.thangok.chat.analytics.controller;

import com.thangok.chat.analytics.dto.ConversationDto;
import com.thangok.chat.analytics.service.ConversationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint to Chat Group CRUD.
 */
@RestController
@RequestMapping("conversations")
public class ConversationController {

  @Autowired
  private ConversationService conversationService;

  @GetMapping("")
  public List<String> getAll() {
    return List.of("Group-1", "Group-2");
  }

  @GetMapping("/{id}")
  public String get(@PathVariable("id") String id) {
    return "Group-" + id;
  }

  @PostMapping("")
  private ConversationDto createConversation(@RequestBody ConversationDto conversationDto) {
    return conversationService.createConversation(conversationDto);
  }
}
