package paulabscs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import paulabscs.data.db.MarineDatabase;
import paulabscs.data.dtos.SharkDTO;
import paulabscs.models.classes.EntityShark;
import paulabscs.orm.SharkConverter;

@Repository
public class MarineRepo implements IMarineRepo {

    private final MarineDatabase marineDatabase;

    public MarineRepo(MarineDatabase marineDatabase) {
        this.marineDatabase = marineDatabase;
    }

    /**
     * Fetches a list of SharkDTOs based on pagination.
     */
    @Override
    public List<SharkDTO> get_sharks(int offset, int limit) {
        List<EntityShark> sharks = marineDatabase.findAll();
        int start = Math.min(offset, sharks.size());
        int end = Math.min(offset + limit, sharks.size());
        List<EntityShark> paginatedSharks = sharks.subList(start, end);

        List<SharkDTO> sharkDTOs = new ArrayList<>();
        for (EntityShark shark : paginatedSharks) {
            sharkDTOs.add(SharkConverter.shark_to_dto(shark));
        }

        return sharkDTOs;
    }

    /**
     * Saves a new shark to the marine database.
     */
    @Override
    public void save(EntityShark shark) {
        marineDatabase.save(shark);
    }

    /**
     * Deletes all sharks from the marine database.
     */
    @Override
    public void deleteAll() {
        marineDatabase.deleteAll();
    }
}
