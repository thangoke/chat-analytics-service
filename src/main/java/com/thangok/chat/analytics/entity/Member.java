package com.thangok.chat.analytics.entity;

/**
 * Member in Conversation.
 */
public class Member {
  private String phoneNumber;

  private String name;

  public String getPhoneNumber() {
    return phoneNumber;
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
}
