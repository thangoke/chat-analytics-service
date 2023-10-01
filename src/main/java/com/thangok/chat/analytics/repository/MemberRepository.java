package com.thangok.chat.analytics.repository;

import com.thangok.chat.analytics.entity.Member;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Member Repository.
 */
public interface MemberRepository extends JpaRepository<Member, UUID> {

}
