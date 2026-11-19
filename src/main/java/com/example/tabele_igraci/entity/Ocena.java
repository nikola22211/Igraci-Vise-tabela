package com.example.tabele_igraci.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="ocena")
public class Ocena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="ocenjivac")
    private String ocenjivac;

    @Column(name="ocena")
    private Long ocena;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name="igrac_ocena",
            joinColumns = @JoinColumn(name="ocena_id"),
            inverseJoinColumns = @JoinColumn(name="igrac_id"))
    private List<Igrac> igraci;


    public void addIgrac(Igrac igrac){
        if(igraci == null){
            igraci = new ArrayList<>();
        }

        igraci.add(igrac);
    }

    public Ocena(){}

    public Ocena(String ocenjivac, Long ocena) {
        this.ocenjivac = ocenjivac;
        this.ocena = ocena;
    }
}
