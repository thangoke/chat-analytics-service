package com.thangok.chat.analytics.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint to Chat Group CRUD.
 */
@RestController
@RequestMapping("chat-groups")
public class ConversationController {

  @GetMapping("")
  public List<String> getAll() {
    return List.of("Group-1", "Group-2");
  }

  @GetMapping("/{id}")
  public String get(@PathVariable("id") String id) {
    return "Group-" + id;
  }
}
