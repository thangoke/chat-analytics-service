package com.thangok.chat.analytics.entity;

import java.util.List;
import java.util.UUID;

public class Content {
  private UUID id;

  private String conversation;

  private List<Attachment> attachments;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getConversation() {
    return conversation;
  }

  public void setConversation(String conversation) {
    this.conversation = conversation;
  }

  public List<Attachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<Attachment> attachments) {
    this.attachments = attachments;
  }
}
