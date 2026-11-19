package com.example.tabele_igraci.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="timovi_primaoci")
public class TimoviPrimaoci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="klub")
    private String klub;

    @Column(name="golovi")
    private Long golovi;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,
    CascadeType.REFRESH})
    @JoinColumn(name="golgeter")
    private Igrac igrac;

    public TimoviPrimaoci(){}

    public TimoviPrimaoci(String klub, Long golovi) {
        this.klub = klub;
        this.golovi = golovi;
    }
}