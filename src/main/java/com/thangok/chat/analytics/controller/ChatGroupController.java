package com.thangok.chat.analytics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chat-groups")
public class ChatGroupController {

  @GetMapping("")
  public List<String> getAll() {
    return List.of("Group-1", "Group-2");
  }

  @GetMapping("/{id}")
  public String get(@PathVariable("id") String id) {
    return "Group-" + id;
  }
}
