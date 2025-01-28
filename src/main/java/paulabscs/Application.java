package paulabscs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import paulabscs.data.db.MarineDatabase;
import paulabscs.data.db.PopulateDatabase;
import paulabscs.repository.MarineRepo;

@SpringBootApplication(scanBasePackages = "paulabscs")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MarineDatabase marineDatabase() {
        return new MarineDatabase();
    }

    @Bean
    public MarineRepo marineRepo(MarineDatabase marineDatabase) {
        return new MarineRepo(marineDatabase);
    }

    @Bean
    public CommandLineRunner runner(MarineRepo marineRepo, MarineDatabase marineDatabase) {
        /**
         * Initializes the application with sample data and clears any existing data.
         */
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                marineRepo.deleteAll();
                PopulateDatabase.populate(marineDatabase); // Populates the database

                marineRepo.get_sharks(0, 10).forEach(shark -> System.out.println("Shark Species: " + shark.getSpecies()));
            }
        };
    }
}
