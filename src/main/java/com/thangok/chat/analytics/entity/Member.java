package com.thangok.chat.analytics.entity;

/**
 * Member in Conversation.
 */
public class Member {

  private String id;

  private String phoneNumber;

  private String name;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /**
   * invoke setPhoneNumber will also set id, as assumption.
   *
   * @param phoneNumber phone number.
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;

    // sync entity id with phone number, as assumption.
    this.id = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
