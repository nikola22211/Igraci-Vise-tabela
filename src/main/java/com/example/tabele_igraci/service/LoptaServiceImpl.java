package com.example.tabele_igraci.service;

import com.example.tabele_igraci.JpaRepo.IgracRepository;
import com.example.tabele_igraci.JpaRepo.OcenaRepository;
import com.example.tabele_igraci.JpaRepo.TimoviPrimaociRepository;
import com.example.tabele_igraci.dto.IgracDTO;
import com.example.tabele_igraci.dto.OcenaDTO;
import com.example.tabele_igraci.dto.TimoviPrimaociDTO;
import com.example.tabele_igraci.entity.Igrac;
import com.example.tabele_igraci.entity.Ocena;
import com.example.tabele_igraci.entity.TimoviPrimaoci;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoptaServiceImpl implements LoptaService{

    private final IgracRepository igracRepository;
    private final OcenaRepository ocenaRepository;
    private final TimoviPrimaociRepository timoviPrimaociRepository;

    public LoptaServiceImpl(IgracRepository igracRepository,
                            OcenaRepository ocenaRepository,
                            TimoviPrimaociRepository timoviPrimaociRepository){

        this.igracRepository = igracRepository;
        this.ocenaRepository = ocenaRepository;
        this.timoviPrimaociRepository = timoviPrimaociRepository;
    }

    @Override
    public void save(Igrac igrac) {
        igracRepository.save(igrac);
    }

    @Override
    public void save(TimoviPrimaoci timoviPrimaoci){
        timoviPrimaociRepository.save(timoviPrimaoci);
    }

    @Override
    public void save(Ocena ocena) {
        ocenaRepository.save(ocena);
    }

    @Transactional
    @Override
    public void saveAll(List<Igrac> igraci){
        igracRepository.saveAll(igraci);
    }

    @Transactional
    @Override
    public IgracDTO getIgracDTO(Long theId) {
       Igrac igrac = igracRepository.findByIdWithOcene(theId).orElseThrow(()->
               new RuntimeException("Igrac nije pronadjen"));

        System.out.println("Ocene: " + igrac.getOcene().size());
        System.out.println("Primaoci: " + igrac.getTimoviPrimaoci().size());
        Igrac igrac2 = igracRepository.findByIdWithPrimaoci((theId)).orElseThrow(()->
                new RuntimeException("Igrac nije pronadjen"));;

        System.out.println("Ista instanca: " + (igrac == igrac2));

        System.out.println("Ocene nakon drugog upita: " + igrac.getOcene().size());

        System.out.println("Primaoci nakon drugog upita: " + igrac.getTimoviPrimaoci().size());

       return convertAllToDTO(igrac);
    }

    @Override
    public IgracDTO getAllFromIgracDTO(Long theId) {
        Igrac igrac = igracRepository.findById(theId).orElseThrow(()->
                new RuntimeException("Igrac nije pronadjen"));

        return convertAllToDTO(igrac);
    }

    private IgracDTO convertToDTO(Igrac igrac){
        return new IgracDTO(igrac.getIme(), igrac.getKlub(), igrac.getTitule());
    }

    private OcenaDTO convertToDTOOcena(Ocena ocena){
        return new OcenaDTO(ocena.getOcenjivac(),ocena.getOcena());
    }

    private TimoviPrimaociDTO convertToDTOTimoviPrimaoci(TimoviPrimaoci timoviPrimaoci){
        return new TimoviPrimaociDTO(timoviPrimaoci.getKlub(), timoviPrimaoci.getGolovi());
    }

    private IgracDTO convertAllToDTO(Igrac igrac){
        List<OcenaDTO> oceneDTO = igrac.getOcene()
                .stream().map(this::convertToDTOOcena).toList();

        List<TimoviPrimaociDTO> timoviPrimaociDTO = igrac.getTimoviPrimaoci()
                .stream().map(this::convertToDTOTimoviPrimaoci).toList();

        return new IgracDTO(igrac.getIme(),igrac.getKlub(),igrac.getTitule(),oceneDTO,timoviPrimaociDTO);
    }

    @Override
    @Transactional
    public List<IgracDTO> getAllDTO() {
        return igracRepository.findAll().stream().map(this::convertToDTO).toList();
    }
}
