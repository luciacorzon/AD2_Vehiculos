package com.example.AD2_Vehiculos;

import com.example.AD2_Vehiculos.entity.Moto;
import com.example.AD2_Vehiculos.repository.VehiculoRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class Ad2VehiculosApplication implements ApplicationRunner {
	VehiculoRepository vehiculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ad2VehiculosApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		vehiculoRepository.save(new Moto("Yamaha", "FZ", (short) 2015, 5000, 500, "Deportiva"));
	    vehiculoRepository.save(new Moto("Honda", "CBR", (short) 2018, 7000, 600, "Deportiva"));
		vehiculoRepository.save(new Moto("Kawasaki", "Ninja", (short) 2019, 8000, 1000, "Deportiva"));

		Pageable pageable = PageRequest.of(0, 5);
	}
}
