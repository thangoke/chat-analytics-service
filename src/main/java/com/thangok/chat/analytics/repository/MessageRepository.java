package com.thangok.chat.analytics.repository;

import com.thangok.chat.analytics.entity.Message;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message, UUID> {

  @Query(
      value =
          " SELECT m "
              + " FROM message m "
              + " WHERE m.appendedTime >= :fromTime "
              + " AND m.appendedTime <= :toTime ")
  List<Message> findByTimeRange(
      @Param("fromTime") LocalDateTime fromTime, @Param("toTime") LocalDateTime toTime);

  @Query(value = " SELECT m " + " FROM message m " + " WHERE m.appendedTime >= :fromTime ")
  List<Message> findByFromTime(@Param("fromTime") LocalDateTime fromTime);

  @Query(value = " SELECT m " + " FROM message m " + " WHERE m.appendedTime <= :toTime ")
  List<Message> findByToTime(@Param("toTime") LocalDateTime toTime);
}
