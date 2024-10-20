package be.kdg.sa.controller.api;

import be.kdg.sa.controller.dto.DoDto;
import be.kdg.sa.controller.dto.OperationsDto;
import be.kdg.sa.service.dokOperation.DOService;
import be.kdg.sa.service.dokOperation.CreateDoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/dokOperations")
public class DORestController {

    private final DOService doService;
    private final CreateDoService createDoService;


    public DORestController(DOService doService, CreateDoService createDoService) {
        this.doService = doService;
        this.createDoService = createDoService;
    }

    @GetMapping("/{vesselNumber}")
    @PreAuthorize("hasAuthority('captain')")
    public OperationsDto getDo(@PathVariable String vesselNumber) {
        return doService.findDoByVesselNumber(vesselNumber);
    }


    @PostMapping("")
    @PreAuthorize("hasAuthority('captain')")
    public void addDokOperation(@RequestBody DoDto doDto) {
        createDoService.createDo(doDto);
    }



}
