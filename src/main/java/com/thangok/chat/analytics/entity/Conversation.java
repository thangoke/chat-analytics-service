package com.thangok.chat.analytics.entity;

import java.util.List;

/**
 * Conversation is the place where people chat together,
 * type can be Direct Conversation or Group Conversation.
 */
public class Conversation {

  private String id;

  private String name;

  private String type;

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
