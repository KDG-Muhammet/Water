package be.kdg.sa.controller.api;


import be.kdg.sa.controller.dto.IODto;
import be.kdg.sa.service.IOService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/ioOperations")
public class IORestController {

    private final IOService ioService;

    public IORestController(IOService ioService) {
        this.ioService = ioService;
    }


    @GetMapping("")
    @PreAuthorize("hasAuthority('inspectionOperation')")
    public Collection<IODto> getIOs() {
        return ioService.findIOs();
    }

    @PutMapping("/{inspectionNumber}")
    @PreAuthorize("hasAuthority('inspectionOperation')")
    public void updateInspection(@PathVariable String inspectionNumber) {
        ioService.performInspection(inspectionNumber);
    }
}
