package com.thangok.chat.analytics.dto;

import com.thangok.chat.analytics.entity.Member;
import java.util.UUID;

/**
 * Member DTO.
 */
public class MemberDto {

  private String id;

  private String phoneNumber;

  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  /**
   * Convert Member Entity into Member DTO.
   *
   * @param member Member entity.
   * @return Member DTO.
   */
  public static MemberDto fromEntity(Member member) {
    MemberDto dto = new MemberDto();

    dto.setId(member.getId().toString());
    dto.setName(member.getName());
    dto.setPhoneNumber(member.getPhoneNumber());

    return dto;
  }

  /**
   * Convert Member DTO into Member Entity.
   *
   * @param memberDto Member DTO.
   * @return Member Entity
   */
  public static Member toEntity(MemberDto memberDto) {
    Member entity = new Member();

    entity.setId(UUID.fromString(memberDto.getId()));
    entity.setName(memberDto.getName());
    entity.setPhoneNumber(memberDto.getPhoneNumber());

    return entity;
  }

}
