package com.thangok.chat.analytics.service;

import com.thangok.chat.analytics.dto.ConversationDto;
import com.thangok.chat.analytics.entity.Conversation;
import com.thangok.chat.analytics.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Conversation business logic.
 */
@Service
public class ConversationService {

  @Autowired
  private ConversationRepository conversationRepository;

  /**
   * Create Conversation.
   *
   * @param conversationDto Conversation DTO.
   * @return Conversation.
   */
  public Conversation createConversation(ConversationDto conversationDto) {
    Conversation conversation = ConversationDto.toEntity(conversationDto);

    conversationRepository.save(conversation);

    return conversation;
  }

}
