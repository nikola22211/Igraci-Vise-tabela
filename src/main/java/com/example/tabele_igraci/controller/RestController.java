package com.example.tabele_igraci.controller;


import com.example.tabele_igraci.dto.IgracDTO;
import com.example.tabele_igraci.dto.OcenaDTO;
import com.example.tabele_igraci.dto.SveIgracDTO;
import com.example.tabele_igraci.dto.TimoviPrimaociDTO;
import com.example.tabele_igraci.entity.Igrac;
import com.example.tabele_igraci.entity.TimoviPrimaoci;
import com.example.tabele_igraci.service.LoptaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/lopta/api")
public class RestController {

    private final LoptaService loptaService;

    public RestController(LoptaService loptaService) {
        this.loptaService = loptaService;
    }

    @GetMapping("igracIOcene/{id}")
    public IgracDTO getIgracWithOceneById(@PathVariable Long id) {
        return loptaService.getIgracWithOceneDTO(id);
    }

    @GetMapping("igracIPrimaoci/{id}")
    public IgracDTO getIgracWithPrimaociById(@PathVariable Long id) {
        return loptaService.getIgracWithPrimaociDTO(id);
    }

    @GetMapping("sviIgraci")
    public List<IgracDTO> getSviIgraci() {
        return loptaService.getAllDTO();
    }

    @GetMapping("sveIgrac/{id}")
    public IgracDTO getSveIgracById(@PathVariable Long id) {
        return loptaService.getAllFromIgracDTO(id);
    }

    @GetMapping("ocena/{igracId}")
    public List<OcenaDTO> findOcenaByIgracId(@PathVariable Long igracId) {
        return loptaService.getOceneIgraca(igracId);
    }

    @GetMapping("primaoc/{igracId}")
    public List<TimoviPrimaociDTO> findTimoviPrimaociByIgracId(@PathVariable Long igracId) {
        return loptaService.getTimoviPrimaociIgraca(igracId);
    }

    @PostMapping("saveIgrac")
    public Igrac addIgrac(@RequestBody IgracDTO igracDTO) {
        return loptaService.addIgrac(igracDTO);
    }

    @PostMapping("addSveIgrac")
    public IgracDTO addSveIgrac(@RequestBody SveIgracDTO sveIgracDTO) {

      return loptaService.addSveIgrac(sveIgracDTO.getIgracDTO(),sveIgracDTO.getOcenaDTO(),sveIgracDTO.getTimoviPrimaociDTO());

    }

    @PostMapping("dodajOcenuIgracu/{igracId}")
    public IgracDTO dodajOcenuIgracu(@RequestBody OcenaDTO ocenaDTO,@PathVariable Long igracId){

        return loptaService.dodajOcenuIgracu(ocenaDTO,igracId);
    }

    @PostMapping("dodajTimPrimaocIgracu/{igracId}")
    public IgracDTO dodajTimPrimaocIgracu(@RequestBody TimoviPrimaociDTO timoviPrimaociDTO,
                                          @PathVariable Long igracId){

        return loptaService.dodajTimPrimaocIgracu(timoviPrimaociDTO,igracId);
    }

    @DeleteMapping("deleteIgrac/{igracId}")
    public void deleteIgrac(@PathVariable Long igracId){
        loptaService.deleteIgrac(igracId);
    }
}
