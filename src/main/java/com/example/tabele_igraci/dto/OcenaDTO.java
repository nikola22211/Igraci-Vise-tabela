package com.example.tabele_igraci.dto;

public class OcenaDTO {

    private String ocenjivac;

    private Long ocena;

    public OcenaDTO(String ocenjivac, Long ocena){
        this.ocenjivac = ocenjivac;
        this.ocena = ocena;
    }

    public OcenaDTO(){}

    public String getOcenjivac() {
        return ocenjivac;
    }

    public void setOcenjivac(String ocenjivac) {
        this.ocenjivac = ocenjivac;
    }

    public Long getOcena() {
        return ocena;
    }

    public void setOcena(Long ocena) {
        this.ocena = ocena;
    }


}
