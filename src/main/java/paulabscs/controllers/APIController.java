package paulabscs.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import paulabscs.data.dtos.SharkDTO;
import paulabscs.repository.MarineRepo;

@RestController
@RequestMapping("/api") // Identifies the API name such that api/{method} is in the URL
public class APIController {

    @Autowired
    private MarineRepo marineRepo;

    @GetMapping("/get_version")
    public ResponseEntity<Map<String, String>> get_version() {
        return ResponseEntity.ok(Map.of("version", "1.01")); // Returning a simple string response
    }

    // Utilizes marineRepo.get_sharks
    @GetMapping("/get_marines")
    public ResponseEntity<List<SharkDTO>> get_marines(
            @RequestParam(defaultValue = "0") int offset, 
            @RequestParam(defaultValue = "10") int limit) {
        List<SharkDTO> shark_dtos = marineRepo.get_sharks(offset, limit);

        return ResponseEntity.ok(shark_dtos);
    }
}
