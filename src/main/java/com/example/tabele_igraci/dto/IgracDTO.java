package com.example.tabele_igraci.dto;

import com.example.tabele_igraci.entity.TimoviPrimaoci;

import java.util.List;

public class IgracDTO {

    private String ime;
    private String klub;
    private List<String> titule;

    private List<OcenaDTO> ocene;
    private List<TimoviPrimaociDTO> timoviPrimaoci;

    public IgracDTO(String ime, String klub, List<String> titule) {
        this.ime = ime;
        this.klub = klub;
        this.titule = titule;
    }

    public IgracDTO(String ime, String klub, List<String> titule,
                    List<OcenaDTO> ocene, List<TimoviPrimaociDTO> timoviPrimaoci) {
        this.ime = ime;
        this.klub = klub;
        this.titule = titule;
        this.ocene = ocene;
        this.timoviPrimaoci = timoviPrimaoci;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getKlub() {
        return klub;
    }

    public void setKlub(String klub) {
        this.klub = klub;
    }

    public List<String> getTitule() {
        return titule;
    }

    public void setTitule(List<String> titule) {
        this.titule = titule;
    }

    public List<OcenaDTO> getOcene() {
        return ocene;
    }

    public void setOcene(List<OcenaDTO> ocene) {
        this.ocene = ocene;
    }

    public List<TimoviPrimaociDTO> getTimoviPrimaoci() {
        return timoviPrimaoci;
    }

    public void setTimoviPrimaoci(List<TimoviPrimaociDTO> timoviPrimaoci) {
        this.timoviPrimaoci = timoviPrimaoci;
    }
}
