package com.thangok.chat.analytics.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thangok.chat.analytics.entity.Conversation;
import com.thangok.chat.analytics.entity.Member;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ConversationRepositoryTests {
  @Autowired private ConversationRepository conversationRepository;

  @Test
  void contextLoads() {}

  @Test
  public void givenConversationRepository_whenSaveAndRetrieveEntity_thenOk() {
    Conversation conversation = new Conversation();
    conversation.setId("c1");
    conversation.setName("conversation-thangok");
    conversation.setType("INDIVIDUAL");

    Member member1 = new Member();
    member1.setName("thangok-1");
    member1.setPhoneNumber("84769375847");
    member1.setConversation(conversation);

    Member member2 = new Member();
    member2.setName("thangok-2");
    member2.setPhoneNumber("84673957685");
    member2.setConversation(conversation);

    conversation.setMembers(List.of(member1, member2));

    String id = conversationRepository.save(conversation).getId();

    Optional<Conversation> retrieveConversationOptional = conversationRepository.findById(id);
    assertTrue(retrieveConversationOptional.isPresent());

    Conversation retrieveConversation = retrieveConversationOptional.get();
    assertNotNull(retrieveConversation);
    assertEquals(conversation.getId(), retrieveConversation.getId());
    assertEquals(conversation.getName(), retrieveConversation.getName());
    assertEquals(conversation.getType(), retrieveConversation.getType());

    List<Member> retrieveMembers = retrieveConversation.getMembers();
    assertEquals(conversation.getMembers().size(), retrieveMembers.size());

    assertTrue(
        retrieveMembers.stream()
            .allMatch(
                member ->
                    member
                        .getPhoneNumber()
                        .equals(conversation.getMembers().get(0).getPhoneNumber())));
    assertTrue(
        retrieveMembers.stream()
            .allMatch(
                member ->
                    member
                        .getPhoneNumber()
                        .equals(conversation.getMembers().get(1).getPhoneNumber())));
  }
}
