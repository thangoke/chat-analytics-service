package com.thangok.chat.analytics.service;

import static org.junit.jupiter.api.Assertions.*;

import com.thangok.chat.analytics.dto.AttachmentDto;
import com.thangok.chat.analytics.dto.MessageDto;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageServiceTests {

  @Autowired private MessageService messageService;

  @Test
  public void contextLoads() {}

  @Test
  public void givenMessageService_whenAddMessage_thenOk() {
    MessageDto messageDto = new MessageDto();
    messageDto.setSenderPhoneNumber("84583650284");
    messageDto.setReceiverType("INDIVIDUAL");
    messageDto.setReceiverId("84294758395");
    messageDto.setConversation("Hey there, nice to meet you!");

    AttachmentDto attachmentDto1 = new AttachmentDto();
    attachmentDto1.setName("Profile picture");
    attachmentDto1.setContentType("application/png");
    attachmentDto1.setUrl("http://abc.com/thangok.png");

    AttachmentDto attachmentDto2 = new AttachmentDto();
    attachmentDto2.setName("Brief introduction");
    attachmentDto2.setContentType("application/docx");
    attachmentDto2.setUrl("http://abc.com/thangok.docx");

    messageDto.setAttachments(List.of(attachmentDto1, attachmentDto2));

    MessageDto retrieveMessageDto = messageService.addMessage(messageDto);
    assertNotNull(retrieveMessageDto);

    assertEquals(messageDto.getSenderPhoneNumber(), retrieveMessageDto.getSenderPhoneNumber());
    assertEquals(messageDto.getReceiverType(), retrieveMessageDto.getReceiverType());
    assertEquals(messageDto.getReceiverId(), retrieveMessageDto.getReceiverId());
    assertEquals(messageDto.getConversation(), retrieveMessageDto.getConversation());

    LocalDateTime referenceTime = LocalDateTime.now();
    assertNotNull(retrieveMessageDto.getAppendedTime());
    assertTrue(retrieveMessageDto.getAppendedTime().isBefore(referenceTime));

    List<AttachmentDto> retrieveAttachmentDtos = retrieveMessageDto.getAttachments();
    assertNotNull(retrieveAttachmentDtos);
    assertEquals(messageDto.getAttachments().size(), retrieveAttachmentDtos.size());

    assertTrue(
        retrieveAttachmentDtos.stream()
            .anyMatch(
                attachmentDto ->
                    attachmentDto.getName().equals(messageDto.getAttachments().get(0).getName())));
    assertTrue(
        retrieveAttachmentDtos.stream()
            .anyMatch(
                attachmentDto ->
                    attachmentDto.getName().equals(messageDto.getAttachments().get(1).getName())));
  }
}
