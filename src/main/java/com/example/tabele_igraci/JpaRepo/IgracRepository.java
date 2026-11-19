package com.example.tabele_igraci.JpaRepo;

import com.example.tabele_igraci.entity.Igrac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IgracRepository extends JpaRepository<Igrac, Long> {

    @Query("""
            SELECT i FROM Igrac i LEFT JOIN FETCH i.ocene 
                         WHERE i.id=:id""")
    Optional<Igrac> findByIdWithOcene(Long id);

    @Query("""
            SELECT i FROM Igrac i LEFT JOIN FETCH i.timoviPrimaoci 
                         WHERE i.id=:id""")
    Optional<Igrac> findByIdWithPrimaoci(Long id);

}
