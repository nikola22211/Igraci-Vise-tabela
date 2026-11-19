package com.example.tabele_igraci.service;

import com.example.tabele_igraci.dto.IgracDTO;
import com.example.tabele_igraci.entity.Igrac;
import com.example.tabele_igraci.entity.Ocena;
import com.example.tabele_igraci.entity.TimoviPrimaoci;

import java.util.List;

public interface LoptaService {

    void save(Igrac igrac);
    void save(TimoviPrimaoci timoviPrimaoci);
    void save(Ocena ocena);

    void saveAll(List<Igrac> igraci);

    IgracDTO getIgracDTO(Long theId);
    List<IgracDTO> getAllDTO();

    IgracDTO getAllFromIgracDTO(Long theId);

}
