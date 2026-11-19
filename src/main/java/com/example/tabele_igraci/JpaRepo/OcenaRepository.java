package com.example.tabele_igraci.JpaRepo;

import com.example.tabele_igraci.entity.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long> {

}
