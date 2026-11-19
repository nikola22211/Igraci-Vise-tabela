package com.example.tabele_igraci.dto;

public class TimoviPrimaociDTO {

    private String klub;
    private Long golovi;

    public TimoviPrimaociDTO(String klub, Long golovi){
        this.klub = klub;
        this.golovi = golovi;
    }

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
