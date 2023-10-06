package com.thangok.chat.analytics.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.thangok.chat.analytics.entity.Attachment;
import com.thangok.chat.analytics.entity.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MessageRepositoryTests {
  @Autowired private MessageRepository messageRepository;

  @Test
  void contextLoads() {}

  @Test
  public void givenMessageRepository_whenSaveAndRetrieve_thenOk() {
    Message message = new Message();
    message.setReceiverType("INDIVIDUAL");
    message.setReceiverId("84957483958");
    message.setSenderPhoneNumber("84758367937");
    message.setConversation("Hi, nice to meet you");
    message.setAttachments(new ArrayList<>());

    Attachment att1 = new Attachment();
    att1.setMessage(message);
    att1.setName("Attachment file 1");
    att1.setContentType("application/docx");
    att1.setUrl("http://abc.com/def.docx");
    message.getAttachments().add(att1);

    Attachment att2 = new Attachment();
    att2.setMessage(message);
    att2.setName("Attachment file 2");
    att2.setContentType("application/docx");
    att2.setUrl("http://abc.com/def.docx");
    message.getAttachments().add(att2);

    UUID id = messageRepository.save(message).getId();

    Optional<Message> retrieveMessageOptional = messageRepository.findById(id);
    assertTrue(retrieveMessageOptional.isPresent());

    Message retrieveMessage = retrieveMessageOptional.get();
    assertNotNull(retrieveMessage);
    assertEquals(message.getId(), retrieveMessage.getId());
    assertEquals(message.getReceiverType(), retrieveMessage.getReceiverType());
    assertEquals(message.getReceiverId(), retrieveMessage.getReceiverId());
    assertEquals(message.getSenderPhoneNumber(), retrieveMessage.getSenderPhoneNumber());
    assertEquals(message.getConversation(), retrieveMessage.getConversation());

    List<Attachment> retrieveAttachments = retrieveMessage.getAttachments();
    assertNotNull(retrieveAttachments);
    assertEquals(message.getAttachments().size(), retrieveAttachments.size());

    assertTrue(
        retrieveAttachments.stream()
            .anyMatch(
                attachment ->
                    attachment.getName().equals(message.getAttachments().get(0).getName())));
    assertTrue(
        retrieveAttachments.stream()
            .anyMatch(
                attachment ->
                    attachment.getName().equals(message.getAttachments().get(1).getName())));
  }
}
