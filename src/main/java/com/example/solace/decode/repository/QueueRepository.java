package com.example.solace.decode.repository;

import com.example.solace.decode.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, String> {
}
