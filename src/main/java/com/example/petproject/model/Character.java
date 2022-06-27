package com.example.petproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "at_characters")
public class Character {

    @Id
    @SequenceGenerator(
            name = "character_seq",
            sequenceName = "character_sequence",
            allocationSize = 1
    )
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "character_seq")
    private Long id;
    private String name;
    private String occupation;
    private LocalDate dou;
    private String link;


    public Character() {

    }

    public Character(Long id, String name, String occupation, LocalDate dob, String link) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.dou = dob;
        this.link = link;
    }

    public Character(String name, String occupation, LocalDate dob, String link) {
        this.name = name;
        this.occupation = occupation;
        this.dou = dob;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public LocalDate getDou() {
        return dou;
    }

    public String getLink() {
        return link;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setDou(LocalDate dou) {
        this.dou = dou;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", dou=" + dou +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Character character = (Character) o;
        return this.id.equals(character.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}