package com.thangok.chat.analytics.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "message")
public class Message {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  @Column(name = "conversation", nullable = false)
  private String conversation;

  @OneToMany(
      mappedBy = "message",
      cascade = {CascadeType.ALL})
  private List<Attachment> attachments;

  @Column(name = "sender_phone_number", nullable = false)
  private String senderPhoneNumber;

  @Column(name = "receiver_type", nullable = false)
  private String receiverType;

  @Column(name = "receiver_id", nullable = false)
  private String receiverId;

  @Column(name = "appended_time", columnDefinition = "TIMESTAMP")
  private LocalDateTime appendedTime;

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

  public LocalDateTime getAppendedTime() {
    return appendedTime;
  }

  public void setAppendedTime(LocalDateTime appendedTime) {
    this.appendedTime = appendedTime;
  }
}
