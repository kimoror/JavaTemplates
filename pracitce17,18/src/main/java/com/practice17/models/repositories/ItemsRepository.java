package com.practice17.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practice17.models.entities.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> { }
