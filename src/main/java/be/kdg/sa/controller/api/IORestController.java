package be.kdg.sa.controller.api;


import be.kdg.sa.controller.dto.IODto;
import be.kdg.sa.service.IOService;
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
    public Collection<IODto> getIOs() {
        return ioService.findIOs();
    }

    @PutMapping("/{inspectionNumber}")
    public void updateInspection(@PathVariable String inspectionNumber) {
        ioService.performInspection(inspectionNumber);
    }
}
