package com.example.tabele_igraci.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="igrac")
public class Igrac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="ime")
    private String ime;

    @Column(name="klub")
    private String klub;

    @Column(name="titule")
    private List<String> titule;

    @ToString.Exclude
    @OneToMany(mappedBy = "igrac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TimoviPrimaoci> timoviPrimaoci = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST}
            , mappedBy = "igraci")
    private List<Ocena> ocene = new ArrayList<>();

    public void addOcena(Ocena ocena){
        if(ocene == null){
            ocene = new ArrayList<>();
        }

        ocene.add(ocena);
        ocena.addIgrac(this);

    }

    public void addTimoviPrimaoci(TimoviPrimaoci tim){
        if(timoviPrimaoci == null){
            timoviPrimaoci = new ArrayList<>();
        }

        timoviPrimaoci.add(tim);
        tim.setIgrac(this);
    }

    public Igrac(){}

    public Igrac(String ime, String klub, List<String> titule) {
        this.ime = ime;
        this.klub = klub;
        this.titule = titule;
    }

    public Igrac(String ime, String klub, List<String> titule, List<Ocena> ocene) {
        this.ime = ime;
        this.klub = klub;
        this.titule = titule;
        this.ocene = ocene;
    }

}
