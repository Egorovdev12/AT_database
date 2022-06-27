package com.example.petproject.config;

import com.example.petproject.model.Character;
import com.example.petproject.repositories.CharacterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CharacterConfig {

    @Bean
    public List<Character> initialData(CharacterRepository repository) {
        Character char1 = new Character("Finn Mertens", "Hero", LocalDate.of(2022, Month.JUNE, 17), "https://adventuretime.fandom.com/wiki/Finn");
        Character char2 = new Character("Jake", "Adventurer", LocalDate.of(2022, Month.JUNE, 17), "https://adventuretime.fandom.com/wiki/Jake");

       return repository.saveAll(List.of(char1, char2));
    }
}