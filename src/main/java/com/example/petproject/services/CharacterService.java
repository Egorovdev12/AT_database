package com.example.petproject.services;
import com.example.petproject.model.Character;
import com.example.petproject.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> showCharacterList() {
        return characterRepository.findAll();
    }

    public void addNewCharacter(Character character) {
        Optional<Character> charById = characterRepository.findCharacterById(character.getId());
        if (charById.isPresent()) {
            throw new IllegalStateException("Character with id = " + character.getId() + " already exists");
        }
        else {
            characterRepository.save(character);
        }
    }

    public void deleteCharacter(Long id) {
        Optional<Character> charById = characterRepository.findCharacterById(id);
        if (charById.isPresent()) {
            characterRepository.delete(charById.get());
        }
        else {
            throw new IllegalStateException("Character with id = " + id + " doesnt exist");
        }
    }

    @Transactional
    public void updateCharacter(Long id, String name, String link) {
        Character character = characterRepository.findCharacterById(id).orElseThrow(
                () -> new IllegalStateException("Character with id " + id + " does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(character.getName(), name)) {
            character.setName(name);
        }

        if (link != null && link.length() > 0 && !Objects.equals(character.getLink(), link)) {
            character.setLink(link);
        }
    }
}