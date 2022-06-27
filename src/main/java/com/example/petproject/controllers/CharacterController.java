package com.example.petproject.controllers;

import com.example.petproject.model.Character;
import com.example.petproject.services.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CharacterController {

    private final CharacterService characterService;

    //TODO понять, почему прекрасно работает и без аннотации в этом месте
    //Потому что нет других кандидатов?
    //@Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<String> hello() {
        return List.of("Hello", "World!");
    }

    @GetMapping("/api/all-characters")
    public List<Character> showCharacterList() {
        return characterService.showCharacterList();
    }

    @PostMapping("/api/add-character")
    public void addNewCharacter(@RequestBody Character character) {
        characterService.addNewCharacter(character);
    }

    @DeleteMapping(path = "api/delete-character/{charId}")
    public void deleteCharacter(@PathVariable("charId") Long id) {
        System.out.println(id);
        characterService.deleteCharacter(id);
    }

    @PutMapping(path = "api/update-character/{charId}")
    public void updateCharacter(@PathVariable("charId") Long id,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String link) {
        characterService.updateCharacter(id, name, link);
    }
}