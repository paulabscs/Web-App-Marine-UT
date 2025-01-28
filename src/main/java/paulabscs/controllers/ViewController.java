package paulabscs.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") // Identifies the root URL for this controller
public class ViewController {

    // Loads the index.html file
    @GetMapping("/index")
    public ResponseEntity<Resource> policyPage() {
        Resource resource = new ClassPathResource("index.html");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(resource);
    }

    // Loads the script.js file
    @GetMapping("/script.js")
    public ResponseEntity<Resource> getScriptJs() {
        Resource resource = new ClassPathResource("script.js");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(resource);
    }

    // Loads the styles.css file
    @GetMapping("/styles.css")
    public ResponseEntity<Resource> getStylesCss() {
        Resource resource = new ClassPathResource("styles.css");
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("text/css"))
                .body(resource);
    }
}
