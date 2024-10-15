package be.kdg.sa.controller.api;


import be.kdg.sa.controller.dto.BODto;
import be.kdg.sa.service.BOService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/boOperations")
public class BORestController {

    private final BOService boService;


    public BORestController(BOService boService) {
        this.boService = boService;
    }

    @GetMapping("")
    public Collection<BODto> getBOs() {
        return boService.findBOs();
    }

    @PutMapping("/{vesselNumber}")
    public void updateBunker(@PathVariable String vesselNumber) {
        boService.performBunker(vesselNumber);
    }
}
