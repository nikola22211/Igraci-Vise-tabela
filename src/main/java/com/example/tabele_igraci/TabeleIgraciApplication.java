package com.example.tabele_igraci;

import com.example.tabele_igraci.entity.Igrac;
import com.example.tabele_igraci.entity.Ocena;
import com.example.tabele_igraci.entity.TimoviPrimaoci;
import com.example.tabele_igraci.service.LoptaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TabeleIgraciApplication {

	public static void main(String[] args) {
		SpringApplication.run(TabeleIgraciApplication.class, args);
	}

	/*@Bean	public CommandLineRunner commandLineRunner(LoptaService loptaService){
		return runner -> {
			kreirajIgrace(loptaService);
		};
	}*/

    /*private void kreirajIgrace(LoptaService loptaService) {
		Igrac igrac1 = new Igrac("Hari Kejn","Bajern", new ArrayList<>(List.of("Bundesliga")));
		Igrac igrac2 = new Igrac("Lamin Jamal","Barselona",new ArrayList<>(List.of("LA Liga","Svetsko prvenstvo")));
		Igrac igrac3 = new Igrac("Kol Palmer","Celsi",new ArrayList<>(List.of("Premijer liga","Liga sampiona")));
		Igrac igrac4 = new Igrac("Malen","Roma",new ArrayList<>(List.of("Skudeto")));

		TimoviPrimaoci timoviPrimaoci1 = new TimoviPrimaoci("Frajburg",5L);
		TimoviPrimaoci timoviPrimaoci2 = new TimoviPrimaoci("Keln",6L);
		TimoviPrimaoci timoviPrimaoci3 = new TimoviPrimaoci("Alaves",4L);
		TimoviPrimaoci timoviPrimaoci4 = new TimoviPrimaoci("Djirona",7L);
		TimoviPrimaoci timoviPrimaoci5 = new TimoviPrimaoci("Bornmut",5L);
		TimoviPrimaoci timoviPrimaoci6 = new TimoviPrimaoci("Sanderlend",2L);
		TimoviPrimaoci timoviPrimaoci7 = new TimoviPrimaoci("Lece",5L);
		TimoviPrimaoci timoviPrimaoci8 = new TimoviPrimaoci("Sasuolo",3L);

		Ocena ocena1 = new Ocena("BBC",9L);
		Ocena ocena2 = new Ocena("Marca",6L);
		Ocena ocena3 = new Ocena("Gazzete Sportivo",4L);

		igrac1.addTimoviPrimaoci(timoviPrimaoci1);
		igrac1.addTimoviPrimaoci(timoviPrimaoci2);
		igrac2.addTimoviPrimaoci(timoviPrimaoci3);
		igrac2.addTimoviPrimaoci(timoviPrimaoci4);
		igrac3.addTimoviPrimaoci(timoviPrimaoci5);
		igrac3.addTimoviPrimaoci(timoviPrimaoci6);
		igrac4.addTimoviPrimaoci(timoviPrimaoci7);
		igrac4.addTimoviPrimaoci(timoviPrimaoci8);

		igrac1.addOcena(ocena1);
		igrac2.addOcena(ocena2);
		igrac3.addOcena(ocena1);
		igrac3.addOcena(ocena3);
		igrac4.addOcena(ocena1);
		igrac4.addOcena(ocena2);
		igrac4.addOcena(ocena3);

		loptaService.saveAll(List.of(igrac1,igrac2,igrac3,igrac4));

	}*/


}
