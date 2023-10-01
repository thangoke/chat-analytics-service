package com.thangok.chat.analytics.repository;

import com.thangok.chat.analytics.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Conversation Repository.
 */
public interface ConversationRepository extends JpaRepository<Conversation, String> {

}
