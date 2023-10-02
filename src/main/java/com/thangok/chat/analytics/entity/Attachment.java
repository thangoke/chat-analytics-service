package com.thangok.chat.analytics.entity;

import java.util.UUID;

public class Attachment {
  private UUID id;

  private String url;

  private String contentType;

  private String name;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
