package com.practice16.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practice16.models.entities.Items;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> { }
