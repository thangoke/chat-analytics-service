package com.thangok.chat.analytics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thangok.chat.analytics.entity.Conversation;
import com.thangok.chat.analytics.entity.Member;
import com.thangok.chat.analytics.repository.ConversationRepository;
import com.thangok.chat.analytics.repository.MemberRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberRepositoryTests {

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private ConversationRepository conversationRepository;

  @Test
  void contextLoads() {}

  @Test
  public void givenMemberRepository_whenSaveAndRetreiveEntity_thenOk() {

    Conversation conversation = new Conversation();
    conversation.setId("c1");
    conversation.setName("conversation-thangok");
    conversation.setType("INDIVIDUAL");
    conversation = conversationRepository.save(conversation);

    Member member = new Member();
    member.setName("thangok");
    member.setPhoneNumber("84769375847");
    member.setConversation(conversation);
    memberRepository.save(member);

    Optional<Member> retrieveMemberOptional = memberRepository.findById(member.getId());
    assertTrue(retrieveMemberOptional.isPresent());

    Member retrieveMember = retrieveMemberOptional.get();
    assertNotNull(retrieveMember);
    assertEquals(member.getId(), retrieveMember.getId());
    assertEquals(member.getName(), retrieveMember.getName());
    assertEquals(member.getPhoneNumber(), retrieveMember.getPhoneNumber());

    Conversation retrieveConversation = member.getConversation();
    assertNotNull(retrieveConversation);
    assertEquals(conversation.getId(), retrieveConversation.getId());
    assertEquals(conversation.getName(), retrieveConversation.getName());
    assertEquals(conversation.getType(), retrieveConversation.getType());

  }

}
