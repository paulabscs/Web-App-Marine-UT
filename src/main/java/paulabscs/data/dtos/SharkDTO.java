package paulabscs.data.dtos;

import paulabscs.models.classes.Dimensions;

/* all fields are required here as the client doesn't 
   have access to modifier api (readonly) */
public class SharkDTO {

    private String species; // Shark's species
    private Dimensions size; // Shark's size dimensions
    private int age; // Shark's age

    // Getters and Setters
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Dimensions getSize() {
        return size;
    }

    public void setSize(Dimensions size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
