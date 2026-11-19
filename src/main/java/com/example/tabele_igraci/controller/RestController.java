package com.example.tabele_igraci.controller;


import com.example.tabele_igraci.dto.IgracDTO;
import com.example.tabele_igraci.entity.Igrac;
import com.example.tabele_igraci.service.LoptaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/lopta/api")
public class RestController {

    private final LoptaService loptaService;

    public RestController(LoptaService loptaService){
        this.loptaService = loptaService;
    }

    @GetMapping("igrac/{id}")
    public IgracDTO getIgracById(@PathVariable Long id){
        return loptaService.getIgracDTO(id);
    }

    @GetMapping("sviIgraci")
    public List<IgracDTO> getSviIgraci(){
        return loptaService.getAllDTO();
    }

    @GetMapping("sveIgrac/{id}")
    public IgracDTO getSveIgracById(@PathVariable Long id){
        return loptaService.getAllFromIgracDTO(id);
    }

}
