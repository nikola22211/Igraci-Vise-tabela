package com.example.tabele_igraci.dto;

import com.example.tabele_igraci.entity.Igrac;

public class TimoviPrimaociDTO {

    private String klub;
    private Long golovi;
    private IgracDTO igrac;

    public TimoviPrimaociDTO(String klub, Long golovi){
        this.klub = klub;
        this.golovi = golovi;
    }

    public TimoviPrimaociDTO(String klub, Long golovi, IgracDTO igrac){
        this.klub = klub;
        this.golovi = golovi;
        this.igrac = igrac;
    }

    public TimoviPrimaociDTO(){}

    public String getKlub() {
        return klub;
    }

    public void setKlub(String klub) {
        this.klub = klub;
    }

    public Long getGolovi() {
        return golovi;
    }

    public void setGolovi(Long golovi) {
        this.golovi = golovi;
    }


}
