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
    public IgracDTO getIgracWithOceneDTO(Long theId) {
       Igrac igrac = igracRepository.findByIdWithOcene(theId).orElseThrow(()->
               new RuntimeException("Igrac nije pronadjen"));

       List<OcenaDTO> oceneDTO = igrac.getOcene().stream().map(this::convertToDTOOcena).toList();

       return new IgracDTO(igrac.getIme(), igrac.getKlub(),igrac.getTitule(),oceneDTO);
    }

    @Override
    public IgracDTO getIgracWithPrimaociDTO(Long theId) {
        Igrac igrac = igracRepository.findByIdWithPrimaoci(theId).orElseThrow(()->
                new RuntimeException("Igrac sa id "+ theId + " nije pronadjen."));

        List<TimoviPrimaociDTO> primaociDTO = igrac.getTimoviPrimaoci().stream().map(this::convertToDTOTimoviPrimaoci)
                .toList();

        return new IgracDTO(igrac.getKlub(),igrac.getTitule(),primaociDTO,igrac.getIme());
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

    @Override
    public List<OcenaDTO> getOceneIgraca(Long igracId) {
        return ocenaRepository.findByIgraciId(igracId).stream()
                .map(this::convertToDTOOcena).toList();
    }

    @Override
    public List<TimoviPrimaociDTO> getTimoviPrimaociIgraca(Long igracId) {
        return timoviPrimaociRepository.findByIgracId(igracId)
                .stream().map(this::convertToDTOTimoviPrimaoci).toList();
    }

    @Override
    public Igrac addIgrac(IgracDTO igrac) {
        Igrac igracPom = new Igrac();

        igracPom.setIme(igrac.getIme());
        igracPom.setKlub(igrac.getKlub());
        igracPom.setTitule(igrac.getTitule());

        return igracRepository.save(igracPom);
    }

    @Transactional
    @Override
    public IgracDTO addSveIgrac(IgracDTO igracDTO, OcenaDTO ocenaDTO, TimoviPrimaociDTO timoviPrimaociDTO) {
        TimoviPrimaoci timoviPrimaoci = new TimoviPrimaoci(timoviPrimaociDTO.getKlub(),
                timoviPrimaociDTO.getGolovi());
        Ocena ocena = new Ocena(ocenaDTO.getOcenjivac(),
                ocenaDTO.getOcena());

        Igrac igrac = new Igrac(igracDTO.getIme(), igracDTO.getKlub(), igracDTO.getTitule());

        igrac.addTimoviPrimaoci(timoviPrimaoci);
        igrac.addOcena(ocena);

        igracRepository.save(igrac);

        return convertAllToDTO(igrac);
    }
    @Transactional
    @Override
    public IgracDTO dodajOcenuIgracu(OcenaDTO ocenaDTO,Long igracId) {
        Igrac igrac = igracRepository.findById(igracId).orElseThrow(
                ()->new RuntimeException("Igrac ne postoji id="+igracId)
        );

        Ocena ocena = new Ocena(ocenaDTO.getOcenjivac(),ocenaDTO.getOcena());

        igrac.addOcena(ocena);

        igracRepository.save(igrac);

        List<OcenaDTO> oceneDTO = igrac.getOcene().stream().map(this::convertToDTOOcena).toList();

        return new IgracDTO(igrac.getIme(),igrac.getKlub(),igrac.getTitule(),
                oceneDTO);

    }

    @Transactional
    @Override
    public IgracDTO dodajTimPrimaocIgracu(TimoviPrimaociDTO timoviPrimaociDTO, Long igracId) {
        Igrac igrac = igracRepository.findById(igracId).orElseThrow(()->
                new RuntimeException("Nema tog igraca"));

        TimoviPrimaoci timoviPrimaoci = new TimoviPrimaoci(timoviPrimaociDTO.getKlub(),
                timoviPrimaociDTO.getGolovi(),igrac);

        igrac.addTimoviPrimaoci(timoviPrimaoci);

        igracRepository.save(igrac);
        List<TimoviPrimaociDTO> timoviPrimaociDTO1 = igrac.getTimoviPrimaoci().stream()
                .map(this::convertToDTOTimoviPrimaoci).toList();

        IgracDTO igrac1 = new IgracDTO(igrac.getKlub(),igrac.getTitule(),timoviPrimaociDTO1,igrac.getIme());

        return igrac1;
    }

    @Transactional
    @Override
    public void deleteIgrac(Long igracId) {

        Igrac igrac = igracRepository.findById(igracId).orElseThrow(
                ()->new RuntimeException("Nema tog igraca sa id" +
                        "jem" + igracId));

        for(Ocena ocenaPom : igrac.getOcene()){
            ocenaPom.getIgraci().remove(igrac);
        }

        igrac.getOcene().clear();

        igracRepository.delete(igrac);

    }
}
