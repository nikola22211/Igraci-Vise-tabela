package com.example.tabele_igraci.dto;

import com.example.tabele_igraci.entity.Ocena;

public class SveIgracDTO {

    IgracDTO igracDTO;
    OcenaDTO ocenaDTO;
    TimoviPrimaociDTO timoviPrimaociDTO;

    public SveIgracDTO(IgracDTO igracDTO, OcenaDTO ocenaDTO, TimoviPrimaociDTO timoviPrimaociDTO) {
        this.igracDTO = igracDTO;
        this.ocenaDTO = ocenaDTO;
        this.timoviPrimaociDTO = timoviPrimaociDTO;
    }

    public SveIgracDTO(){}

    public IgracDTO getIgracDTO() {
        return igracDTO;
    }

    public void setIgracDTO(IgracDTO igracDTO) {
        this.igracDTO = igracDTO;
    }

    public OcenaDTO getOcenaDTO() {
        return ocenaDTO;
    }

    public void setOcenaDTO(OcenaDTO ocenaDTO) {
        this.ocenaDTO = ocenaDTO;
    }

    public TimoviPrimaociDTO getTimoviPrimaociDTO() {
        return timoviPrimaociDTO;
    }

    public void setTimoviPrimaociDTO(TimoviPrimaociDTO timoviPrimaociDTO) {
        this.timoviPrimaociDTO = timoviPrimaociDTO;
    }
}
