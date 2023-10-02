package com.thangok.chat.analytics.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.thangok.chat.analytics.dto.ConversationDto;
import com.thangok.chat.analytics.dto.MemberDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConversationServiceTests {
  @Autowired
  private ConversationService conversationService;

  @Test
  void contextLoads() {}

  @Test
  public void givenConversationService_whenCreateConversation_ThenOk() {

    List<MemberDto> memberDtos = new ArrayList<>();

    MemberDto alice = new MemberDto();
    alice.setName("Alice");
    alice.setPhoneNumber("84836582057");
    memberDtos.add(alice);

    MemberDto bob = new MemberDto();
    bob.setName("Bob");
    bob.setPhoneNumber("84836683928");
    memberDtos.add(bob);

    ConversationDto conversationDto = new ConversationDto();
    conversationDto.setId("c1");
    conversationDto.setName("conversation-alice-bob");
    conversationDto.setType("INDIVIDUAL");
    conversationDto.setMembers(memberDtos);

    ConversationDto result = conversationService.createConversation(conversationDto);
    assertNotNull(result);
    assertEquals(conversationDto.getId(), result.getId());
    assertEquals(conversationDto.getName(), result.getName());
    assertEquals(conversationDto.getType(), result.getType());

    assertFalse(result.getMembers().isEmpty());
    assertEquals(conversationDto.getMembers().size(), result.getMembers().size());

    assertTrue(result.getMembers().stream().anyMatch(member -> "Bob".equals(member.getName())));
    assertTrue(result.getMembers().stream().anyMatch(member -> "Alice".equals(member.getName())));
  }
}
