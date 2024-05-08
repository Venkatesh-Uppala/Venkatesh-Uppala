package com.javaexperts.realtime.kafka.repository;

import com.javaexperts.realtime.kafka.entity.WikiMediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaDataRepository extends JpaRepository<WikiMediaData,Long> {
}
