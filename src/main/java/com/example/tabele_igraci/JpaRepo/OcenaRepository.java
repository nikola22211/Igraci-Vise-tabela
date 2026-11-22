package com.example.tabele_igraci.JpaRepo;

import com.example.tabele_igraci.entity.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long> {

    List<Ocena> findByIgraciId(Long igracId);
}
