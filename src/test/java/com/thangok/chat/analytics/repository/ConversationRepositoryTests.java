package com.thangok.chat.analytics.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.thangok.chat.analytics.entity.Conversation;
import com.thangok.chat.analytics.entity.Member;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ConversationRepositoryTests {
  @Autowired
  private ConversationRepository conversationRepository;

  @Test
  void contextLoads() {}

  @Test
  public void givenConversationRepository_whenSaveAndRetreiveEntity_thenOk() {

    Conversation conversation = new Conversation();
    conversation.setId("c1");
    conversation.setName("conversation-thangok");
    conversation.setType("INDIVIDUAL");

    Member member = new Member();
    member.setName("thangok");
    member.setPhoneNumber("84769375847");
    member.setConversation(conversation);

    conversation.setMembers(List.of(member));

    conversationRepository.save(conversation);

    Conversation retrieveConversation = member.getConversation();
    assertNotNull(retrieveConversation);
    assertEquals(conversation.getId(), retrieveConversation.getId());
    assertEquals(conversation.getName(), retrieveConversation.getName());
    assertEquals(conversation.getType(), retrieveConversation.getType());
    assertFalse(conversation.getMembers().isEmpty());

    Member retrieveMember = retrieveConversation.getMembers().get(0);
    assertNotNull(retrieveMember);
    assertEquals(member.getId(), retrieveMember.getId());
    assertEquals(member.getName(), retrieveMember.getName());
    assertEquals(member.getPhoneNumber(), retrieveMember.getPhoneNumber());

  }
}
