package com.thangok.chat.analytics.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.thangok.chat.analytics.dto.ConversationDto;
import com.thangok.chat.analytics.dto.MemberDto;
import com.thangok.chat.analytics.entity.Conversation;
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

    ConversationDto conversation = conversationService.createConversation(conversationDto);
    assertNotNull(conversation);

  }
}
