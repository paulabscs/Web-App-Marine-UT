package paulabscs.data.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import paulabscs.models.classes.EntityShark;

public class MarineDatabase {
    private final List<EntityShark> sharks = new ArrayList<>();
    private final AtomicLong currentId = new AtomicLong(1);

    /**
     * Adds a new shark to the database.
     */
    public void save(EntityShark shark) {
        shark.setId(currentId.getAndIncrement());
        sharks.add(shark);
    }

    /**
     * Retrieves all sharks.
     */
    public List<EntityShark> findAll() {
        return new ArrayList<>(sharks);
    }

    /**
     * Deletes all sharks from the database.
     */
    public void deleteAll() {
        sharks.clear();
        currentId.set(1);
    }

    /**
     * Finds a shark by ID.
     */
    public Optional<EntityShark> findById(long id) {
        return sharks.stream().filter(shark -> shark.getId() == id).findFirst();
    }
}
