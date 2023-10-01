package com.thangok.chat.analytics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Conversation is the place where people chat together, type can be Direct Conversation or Group
 * Conversation.
 */
@Entity
@Table(name = "conversation")
public class Conversation {

  @Id
  private String id;

  @Column(name = "name", nullable = true)
  private String name;

  @Column(name = "type", nullable = false)
  private String type;

  @OneToMany(mappedBy = "conversation")
  private List<Member> members;

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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

}
