package com.example.petproject.repositories;

import com.example.petproject.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    //TODO почитать про @Query

    // SELECT * FROM at_characters WHERE id = ?
    Optional<Character> findCharacterById(Long id);
}
