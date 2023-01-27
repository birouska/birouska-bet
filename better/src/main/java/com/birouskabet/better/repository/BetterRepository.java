package com.birouskabet.better.repository;

import com.birouskabet.better.entity.Better;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BetterRepository extends JpaRepository<Better, Long> {
    Better findByPersonalId(String personalId);
}