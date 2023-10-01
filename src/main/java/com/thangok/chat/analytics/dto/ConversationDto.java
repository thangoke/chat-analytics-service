package com.thangok.chat.analytics.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.thangok.chat.analytics.entity.Conversation;
import com.thangok.chat.analytics.entity.Member;

/**
 * Conversation DTO.
 */
public class ConversationDto {
  private String id;

  private String name;

  private String type;

  private List<MemberDto> members;

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

  public List<MemberDto> getMembers() {
    return members;
  }

  public void setMembers(List<MemberDto> members) {
    this.members = members;
  }


  public ConversationDto fromEntity(Conversation conversation) {
    ConversationDto dto = new ConversationDto();

    dto.setId(conversation.getId());
    dto.setName(conversation.getName());
    dto.setType(conversation.getType());

    List<Member> members = conversation.getMembers();
    if (members != null) {
      dto.members = members.stream().map(MemberDto::fromEntity).collect(Collectors.toList());
    }

    return dto;
  }

}
