package com.thangok.chat.analytics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

/**
 * Member in Conversation.
 */
@Entity
@Table(name = "member")
public class Member {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "conversation_id", nullable = false)
  private Conversation conversation;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Conversation getConversation() {
    return conversation;
  }

  public void setConversation(Conversation conversation) {
    this.conversation = conversation;
  }

}
