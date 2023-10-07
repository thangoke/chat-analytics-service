package com.thangok.chat.analytics.dto;

import com.thangok.chat.analytics.entity.Attachment;
import com.thangok.chat.analytics.entity.Message;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/** Message DTO. */
public class MessageDto {
  private String id;

  private String conversation;

  private List<AttachmentDto> attachments;

  private String senderPhoneNumber;

  private String receiverType;

  private String receiverId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getConversation() {
    return conversation;
  }

  public void setConversation(String conversation) {
    this.conversation = conversation;
  }

  public List<AttachmentDto> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<AttachmentDto> attachments) {
    this.attachments = attachments;
  }

  public String getSenderPhoneNumber() {
    return senderPhoneNumber;
  }

  public void setSenderPhoneNumber(String senderPhoneNumber) {
    this.senderPhoneNumber = senderPhoneNumber;
  }

  public String getReceiverType() {
    return receiverType;
  }

  public void setReceiverType(String receiverType) {
    this.receiverType = receiverType;
  }

  public String getReceiverId() {
    return receiverId;
  }

  public void setReceiverId(String receiverId) {
    this.receiverId = receiverId;
  }

  public static MessageDto fromEntity(Message message) {
    MessageDto dto = new MessageDto();
    dto.setId(message.getId().toString());
    dto.setSenderPhoneNumber(message.getSenderPhoneNumber());
    dto.setReceiverType(message.getReceiverType());
    dto.setReceiverId(message.getReceiverId());
    dto.setConversation(message.getConversation());
    dto.setAttachments(
        message.getAttachments().stream()
            .map(AttachmentDto::fromEntity)
            .collect(Collectors.toList()));
    return dto;
  }

  public static Message toEntity(MessageDto messageDto) {
    Message entity = new Message();
    if (messageDto.getId() != null) {
      entity.setId(UUID.fromString(messageDto.getId()));
    }
    entity.setSenderPhoneNumber(messageDto.getSenderPhoneNumber());
    entity.setReceiverType(messageDto.getReceiverType());
    entity.setReceiverId(messageDto.getReceiverId());
    entity.setConversation(messageDto.getConversation());
    entity.setAttachments(
        messageDto.getAttachments().stream()
            .map(
                attachmentDto -> {
                  Attachment attachment = AttachmentDto.toEntity(attachmentDto);
                  attachment.setMessage(entity);
                  return attachment;
                })
            .collect(Collectors.toList()));
    return entity;
  }
}
