package com.example.tabele_igraci.JpaRepo;

import com.example.tabele_igraci.entity.TimoviPrimaoci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimoviPrimaociRepository extends JpaRepository<TimoviPrimaoci, Long> {

    List<TimoviPrimaoci> findByIgracId(Long igracId);
}
