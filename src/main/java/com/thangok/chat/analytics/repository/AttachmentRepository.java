package com.thangok.chat.analytics.repository;

import com.thangok.chat.analytics.entity.Attachment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
