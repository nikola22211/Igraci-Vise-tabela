package com.example.tabele_igraci.service;

import com.example.tabele_igraci.dto.IgracDTO;
import com.example.tabele_igraci.dto.OcenaDTO;
import com.example.tabele_igraci.dto.TimoviPrimaociDTO;
import com.example.tabele_igraci.entity.Igrac;
import com.example.tabele_igraci.entity.Ocena;
import com.example.tabele_igraci.entity.TimoviPrimaoci;

import java.util.List;

public interface LoptaService {

    void save(Igrac igrac);
    void save(TimoviPrimaoci timoviPrimaoci);
    void save(Ocena ocena);

    void saveAll(List<Igrac> igraci);

    IgracDTO getIgracWithOceneDTO(Long theId);
    IgracDTO getIgracWithPrimaociDTO(Long theId);
    List<IgracDTO> getAllDTO();

    IgracDTO getAllFromIgracDTO(Long theId);

    List<OcenaDTO> getOceneIgraca(Long igracId);
    List<TimoviPrimaociDTO> getTimoviPrimaociIgraca(Long igracId);

    Igrac addIgrac(IgracDTO igrac);

    IgracDTO addSveIgrac(IgracDTO igracDTO,OcenaDTO ocenaDTO,TimoviPrimaociDTO timoviPrimaociDTO);

    IgracDTO dodajOcenuIgracu(OcenaDTO ocenaDTO,Long igracId);
    IgracDTO dodajTimPrimaocIgracu(TimoviPrimaociDTO timoviPrimaociDTO,Long igracId);
    void deleteIgrac(Long igracId);
}
