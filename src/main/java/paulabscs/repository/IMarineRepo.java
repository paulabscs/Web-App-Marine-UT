package paulabscs.repository;

import java.util.List;

import paulabscs.data.dtos.SharkDTO;
import paulabscs.models.classes.EntityShark;

public interface IMarineRepo {

    void save(EntityShark shark); // Saves a shark
    void deleteAll(); // Deletes all sharks
    List<SharkDTO> get_sharks(int offset, int limit); // Fetches a list of SharkDTOs based on pagination
}
