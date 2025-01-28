package paulabscs.orm;

import paulabscs.data.dtos.SharkDTO;
import paulabscs.models.classes.EntityShark;

public class SharkConverter {

    /**
     * Converts an EntityShark object to a SharkDTO.
     */
    public static SharkDTO shark_to_dto(EntityShark shark) {
        SharkDTO sharkDTO = new SharkDTO();
        sharkDTO.setSpecies(shark.getSpecies());
        sharkDTO.setSize(shark.getSize());
        sharkDTO.setAge(shark.getAge());
        return sharkDTO;
    }

}
