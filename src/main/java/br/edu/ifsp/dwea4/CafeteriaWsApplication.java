package br.edu.ifsp.dwea4;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CafeteriaWsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CafeteriaWsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CafeteriaWsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BebidaRepositorio repositorio) {
		return (args) -> {
			Cafe b1 = new Cafe("Expresso", 2.00, false, false);
			Cafe b2 = new Cafe("Latte", 3.00, true, false);
			Cafe b3 = new Cafe("Cappuccino", 3.50, true, false);
			Cafe b4 = new Cafe("Frappuccino", 6.00, true, true);
			
			Suco b5 = new Suco("Suco de Laranja", 3.00, false, 
					Arrays.asList("Laranja"));
			Suco b6 = new Suco("Suco de Vita C", 3.50, false, 
					Arrays.asList("Laranja", "Acerola"));
			Suco b7 = new Suco("Vitaminado", 7.00, true, 
					Arrays.asList("Maçã", "Banana", "Morango"));
			
			repositorio.save(b1);
			repositorio.save(b2);
			repositorio.save(b3);
			repositorio.save(b4);			
			repositorio.save(b5);
			repositorio.save(b6);
			repositorio.save(b7);


			log.info("BEBIDAS:");
			log.info("-------------------------------");
			for (Bebida bebida : repositorio.findAll()) {
				log.info("Nome: " + bebida.getNome());
			}
			log.info("------- FIM -------");
		};
	}

}
