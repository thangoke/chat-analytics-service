package com.thangok.chat.analytics.dto;

import java.util.UUID;
import com.thangok.chat.analytics.entity.Attachment;

/**
 * Attachment DTO.
 */
public class AttachmentDto {

  private String id;

  private String name;

  private String contentType;

  private String url;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public static AttachmentDto fromEntity(Attachment attachment) {
    AttachmentDto dto = new AttachmentDto();

    dto.setId(attachment.getId().toString());
    dto.setName(attachment.getName());
    dto.setUrl(attachment.getUrl());

    return dto;
  }

  public static Attachment toEntity(AttachmentDto attachmentDto) {
    Attachment entity = new Attachment();

    if (attachmentDto.getId() != null) {
      entity.setId(UUID.fromString(attachmentDto.getId()));
    }
    entity.setName(attachmentDto.getName());
    entity.setContentType(attachmentDto.getContentType());
    entity.setUrl(attachmentDto.getUrl());

    return entity;
  }
}
