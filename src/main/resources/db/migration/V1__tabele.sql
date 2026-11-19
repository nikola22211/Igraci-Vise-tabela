CREATE TABLE igrac(
		id BIGSERIAL CONSTRAINT firstkey1 PRIMARY KEY,
		ime VARCHAR(50) NOT NULL,
		klub VARCHAR(40) NOT NULL,
		titule VARCHAR(40) ARRAY
		);
		
CREATE TABLE timovi_primaoci(
		id BIGSERIAL CONSTRAINT firstkey2 PRIMARY KEY,
		klub VARCHAR(40) NOT NULL,
		golovi BIGINT NOT NULL,
		golgeter BIGINT NOT NULL,
		
		CONSTRAINT fk_timovi_primaoci
			FOREIGN KEY (golgeter)
				REFERENCES igrac(id) 
		);
		
CREATE TABLE ocena(
		id BIGSERIAL CONSTRAINT firstkey3 PRIMARY KEY,
		ocenjivac VARCHAR(40) NOT NULL,
		ocena BIGINT NOT NULL
		);
		
CREATE TABLE igrac_ocena(
		igrac_id BIGINT NOT NULL,
		ocena_id BIGINT NOT NULL,
		
		PRIMARY KEY(igrac_id,ocena_id),
		
		CONSTRAINT fk_igrac_ocena1 FOREIGN KEY (igrac_id)
		REFERENCES igrac(id),
		
		CONSTRAINT fk_igrac_ocena2 FOREIGN KEY (ocena_id)
		REFERENCES ocena(id)
		);
		

		


		
