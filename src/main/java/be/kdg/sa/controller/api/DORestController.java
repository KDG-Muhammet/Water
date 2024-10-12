package be.kdg.sa.controller.api;

import be.kdg.sa.controller.dto.DoDto;
import be.kdg.sa.service.DOService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/dok-operations")
public class DORestController {

    private final DOService doService;

    public DORestController(DOService doService) {
        this.doService = doService;
    }

    @PostMapping("")
    public void addDokOperation(@RequestBody DoDto doDto) {
        doService.createDo(doDto);
    }



}
