package com.bolaobrasil.better.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolaobrasil.better.entity.Better;


@Repository
public interface BetterRepository extends JpaRepository<Better, Long> {
    Better findByPersonalId(String personalId);
}