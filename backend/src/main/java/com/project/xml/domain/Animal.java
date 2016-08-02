package com.project.xml.domain;

/**
 * Created by vladbulimac on 08/05/16.
 */
public class Animal {

    private String name;
    private String species;
    private String gender;
    private String breed;
    private String size;
    private String details;

    public Animal() {
    }

    public Animal(String name, String species, String gender, String breed, String size, String details) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.breed = breed;
        this.size = size;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
