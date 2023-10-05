package com.thangok.chat.analytics.repository;

import com.thangok.chat.analytics.entity.Message;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, UUID> {
}
