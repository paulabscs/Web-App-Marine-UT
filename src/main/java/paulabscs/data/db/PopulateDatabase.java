package paulabscs.data.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;

import paulabscs.models.classes.Dimensions;
import paulabscs.models.classes.EntityShark;

public class PopulateDatabase {

    /**
     * Populates the MarineDatabase with shark data from a CSV file.
     */
    public static void populate(MarineDatabase marineDatabase) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("shark_data.csv").getInputStream()))) {
            List<EntityShark> sharks = br.lines().skip(1).map(line -> {
                String[] fields = line.split(",");
                String species = fields[0];
                double length = Double.parseDouble(fields[1]);
                double width = Double.parseDouble(fields[2]);
                double height = Double.parseDouble(fields[3]);
                int age = Integer.parseInt(fields[4]);
                return new EntityShark(species, new Dimensions(length, width, height), age);
            }).collect(Collectors.toList());

            sharks.forEach(marineDatabase::save);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
