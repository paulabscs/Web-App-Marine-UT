package paulabscs.models.classes;

/* all fields are required here as the client doesn't 
   have access to modifier api (readonly) */
public class EntityShark {

    private Long id; // Shark's unique identifier
    private String species; // Shark's species
    private Dimensions size; // Shark's size dimensions
    private int age; // Shark's age

    public EntityShark() {}

    public EntityShark(String species, Dimensions size, int age) {
        this.species = species;
        this.size = size;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
